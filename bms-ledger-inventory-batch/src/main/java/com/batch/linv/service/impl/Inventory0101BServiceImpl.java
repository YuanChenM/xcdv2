package com.batch.linv.service.impl;

import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.batch.linv.bean.entity.*;
import com.batch.linv.dao.LinvSynInvDao;
import com.framework.core.utils.DateUtils;
import com.framework.redis.dao.BaseRedisDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.TypeReference;
import com.batch.linv.constant.LinvApiUrlConstant;
import com.batch.linv.constant.ResponseDataReader;
import com.batch.linv.dao.Inventory0101BDao;
import com.batch.linv.service.Inventory0101BService;
import com.bms.common.rest.batchclient.RestBatchClient;
import com.bms.common.rest.batchclient.RestBatchClientFactory;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;

/**
 * Created by sunjiaju on 2017/2/16.
 */
@Service
public class Inventory0101BServiceImpl extends BaseServiceImpl implements Inventory0101BService{

    @Autowired
    private RestBatchClientFactory restClientFactory;

    @Autowired
    private Inventory0101BDao inventory0101BDao;

    @Autowired
    private LinvSynInvDao linvSynInvDao;


    @Autowired
    private BaseRedisDao baseRedisDao;


    @Override
    public BaseDao getBaseDao() {
        return inventory0101BDao;
    }


    /**
     * 获取需备份商品数据
     *
     * @return
     */
    @Override
    public List<Map> findLoadData() {
        Date time = DateUtils.getCurrent();
        String sign = "SYSTEM";//super.getLoginUserId();

        List<Map> map = new ArrayList<Map>();
        String url = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.SLPD.CODE, LinvApiUrlConstant.SLPD.URIS.COMM_SEARCH);
        HashMap requestSku = new HashMap();
        RestBatchClient restClient = restClientFactory.newBatchRestClient();
        BaseWebPaginationResult<HashMap> skuResult = restClient.post(url,requestSku,
                new TypeReference<BaseWebPaginationResult<HashMap>>() {
                },"Linv0001B");

        Map skuData = ResponseDataReader.skuInfoReader(skuResult.getData(),sign,time);

        //请求SKU接口获取到的productId再请求COMM接口
        List<LinvCommInfo> commList=new ArrayList<LinvCommInfo>();
        for (int i = 0; i < skuResult.getData().size(); i++) {
            Map tempSku = (HashMap)skuResult.getData().get(i);
            String productId = String.valueOf(tempSku.get("productId"));
            String skuCode=String.valueOf(tempSku.get("manufacturerProductSku"));
            HashMap requestComm = new HashMap();
            requestComm.put("productId",productId);
            String commUrl = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.COMO.CODE, LinvApiUrlConstant.COMO.URIS.COMM_SEARCH);
            BaseWebPaginationResult<HashMap> commResult = restClient.post(commUrl, requestComm,
                    new TypeReference<BaseWebPaginationResult<HashMap>>() {
                    },"Linv0001B");
            LinvCommInfo tComm = ResponseDataReader.commInfoReader(commResult.getData(), skuCode, sign, time);
            if(tComm != null){
                commList.add(tComm);
            }
        }

        HashMap<String, List> commMap = new HashMap<String, List>();
        commMap.put("COMM", commList);
        skuData.putAll(commMap);
        map.add(skuData);
        return map;
    }

    /**
     * 备份本地数据库LOAD表数据，同步WMS库存到LOAD_SYNC表
     * @return
     */
    @Override
    public List<InvmLoad> findAllSkuCode() {

        //1.清除3天前的数据，设置INVM_LOAD_LOG表数据delfag置为1
        linvSynInvDao.cleanLoadLogData();
        linvSynInvDao.setLoadLogDelFlag();

        //2.备份load表数据到load_log表中
        linvSynInvDao.backUpData();

        //清除3天前的数据，设置commo_log表数据delfag置为1
        linvSynInvDao.cleanCommoLogData();
        linvSynInvDao.setCommoLogDelFlag();

        //备份commo表数据到commo_log表中
        linvSynInvDao.backUpCommoData();

        //3.设置历史数据delfag置为1
        linvSynInvDao.setLoadSyncDelFlag();

        List<InvmLoad> invmLoadList = new ArrayList<>();
        
        //4.查询INVM_LOAD中的数据所有SKU
        int total=linvSynInvDao.countSku();
        int start=0; //设置查询
        int end=100;
        int size=total/end;
       // List<InvmLoad> invmLoadLists= new ArrayList<>();
            for (int i = 0; i < size; i++) {
                InvmPage invmPage = new InvmPage();
                invmPage.setStartNum(start);
                invmPage.setEndNum(end);
                List<InvmLoad> invmLoadLists = linvSynInvDao.findAllSkuCode(invmPage);
                start=start+100;
                invmLoadList = syncInvmLoads(invmLoadLists);
            }
            if(start<total){
                InvmPage invmPage = new InvmPage();
                invmPage.setStartNum(start);
                invmPage.setEndNum(end);
                List<InvmLoad> invmLoadLists = linvSynInvDao.findAllSkuCode(invmPage);
                invmLoadList= syncInvmLoads(invmLoadLists);
            }
        return  invmLoadList;
    }

    /**
     * 库存同步表插入
     * @param invmLoadLists
     * @return
     */
    private List<InvmLoad> syncInvmLoads(List<InvmLoad> invmLoadLists) {
        List<InvmLoad> invmLoadList = null;
        if (invmLoadLists.size()>0) {
            //处理相同物流区多个SKUCODE
            invmLoadList = dealSkuCode(invmLoadLists);

            Date time = DateUtils.getCurrent();
            String sign = "WMS";//super.getLoginUserId();

            DefaultHttpClient httpClient = null;
            try {
                //5.业务参数：一个物流区，多个skucode，去WMS查询产品库存数据并插入库存数据库
                for (int j = 0;  j< invmLoadList.size(); j++) {
                    httpClient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost(LinvApiUrlConstant.WMS_SKU.URL); //webservice服务地址
                    String soapRequestData = getRequestXml(invmLoadList.get(j)); //soap协议的格式，定义了方法和参数
                    HttpEntity re = new StringEntity(soapRequestData, HTTP.UTF_8);
                    httppost.setHeader("Content-Type", "application/soap+xml; charset=utf-8");
                    httppost.setEntity(re);
                    HttpResponse response = httpClient.execute(httppost); //调用接口
                    if (response.getStatusLine().getStatusCode() == 200) {  //调用状态
                        String xmlString = EntityUtils.toString(response.getEntity());
                        xmlString = xmlString.replaceAll("return>", "result>");
                        XStream xstream = new XStream(new DomDriver());
                        xstream.setMode(XStream.NO_REFERENCES);
                        //注册使用了注解的VO
                        xstream.processAnnotations(new Class[]{Envelope.class});
                        Envelope envelope = (Envelope) xstream.fromXML(xmlString);
                        String jsonString = envelope.getBody().getStockByCodesResponse().getResult();
                        if(!"".equals(jsonString)) {
                            Map map = JSON.parseObject(jsonString);
                            JSONArray producerProducts = (JSONArray) map.get("productList");
                            for (int i = 0; i < producerProducts.size(); i++) {
                                LINV0117IResultParam resultParam = new LINV0117IResultParam();
                                JSONObject product = producerProducts.getJSONObject(i);
                                resultParam.setLaCode(String.valueOf(product.get("lgcsCode")));
                                resultParam.setSkuCode(String.valueOf(product.get("skuCode")));
                                resultParam.setSkuName(String.valueOf(product.get("skuName")));
                                resultParam.setLotNo(String.valueOf(product.get("lotNo")));
                                resultParam.setUnit(String.valueOf(product.get("unit")));
                                resultParam.setInboundQty(String.valueOf(product.get("inboundQty")));
                                resultParam.setStatus(String.valueOf(product.get("status")));
                                resultParam.setSalesLabel(String.valueOf(product.get("salesLabel")));
                                resultParam.setConsignee(String.valueOf(product.get("consignee")));
                                resultParam.setWhCode(String.valueOf(product.get("whCode")));
                                resultParam.setWhName(String.valueOf(product.get("whName")));
                                resultParam.setCrtId(sign);
                                resultParam.setCrtTime(time);
                                //保存
                                resultParam.setSyncId(baseRedisDao.getTablePrimaryKey("invm_load_sync", 1));
                                resultParam.setSyncTime(time);
                                linvSynInvDao.saveLoadSync(resultParam);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                httpClient.getConnectionManager().shutdown(); //关闭连接
            }
        }
        return  invmLoadList;
    }

    /**
     * 处理相同物流区多个SKUCODE
     *
     * @param invmLoadList
     * @return
     */
    private List<InvmLoad> dealSkuCode(List<InvmLoad> invmLoadList){
        List<InvmLoad> invmLoadResult= new ArrayList<>();
        Map<String, String> keyMap = new HashMap<String, String>();
        for (int i = 0; i < invmLoadList.size(); i++) {
            String value=invmLoadList.get(i).getSkuCode();
            boolean flag=keyMap.containsKey(invmLoadList.get(i).getLaCode());
            if (flag){
                value=value+","+keyMap.get(invmLoadList.get(i).getLaCode());
            }
            keyMap.put(invmLoadList.get(i).getLaCode(), value);
        }
        Iterator entries = keyMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            InvmLoad lnvmLoad= new InvmLoad();
            lnvmLoad.setLaCode((String)entry.getKey());
            lnvmLoad.setSkuCode((String)entry.getValue());
            invmLoadResult.add(lnvmLoad);
        }
        return  invmLoadResult;
    }



    /**
     * 一个物流区，多个skucode 参数拼接
     * @param invmLoad
     * @return
     */
    private static String getRequestXml(InvmLoad invmLoad) {
        String lgcsCode=invmLoad.getLaCode();
        String skuString=invmLoad.getSkuCode();
        String head="{\"skuCode\":\"";
        skuString=skuString.replaceAll(",","\"}, {\"skuCode\":\"");
        String end="\"}";
        String skuResult=head+skuString+end;

        String xmlString = "{\"lgcsCode\":\""+lgcsCode+"\", \"productList\":["+skuResult+"]}";
        StringBuilder sb = new StringBuilder();
        sb.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");  //xml协议格式请根据自己的soap协议构建。不然无法使用
        sb.append("<soap:Body>");
        sb.append("<ns2:getStockByCodes xmlns:ns2=\"http://ws.top.dhc.com/\">");  //要调用的webservice服务的方法名称
        sb.append("<skuInfo>"+xmlString+"</skuInfo>"); //上面获取到的参数
        sb.append("</ns2:getStockByCodes>");
        sb.append("</soap:Body>");
        sb.append("</soap:Envelope>");
        return sb.toString();
    }

}
