package com.batch.bybatch.service.impl;

import java.math.BigDecimal;
import java.util.*;

import com.batch.bybatch.bean.entity.ByimFrequenterLevel;
import com.batch.bybatch.bean.entity.ByimGrade;
import com.framework.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.batch.bybatch.bean.entity.ByimBuyer;
import com.batch.bybatch.bean.result.*;
import com.batch.bybatch.constant.ByimCommConstant;
import com.batch.bybatch.dao.BYIM0101BDao;
import com.batch.bybatch.service.BYIM0101BService;
import com.batch.bybatch.util.BaseRestClientUtil;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@Service
public class BYIM0101BServiceImpl extends BaseServiceImpl implements BYIM0101BService {

    @Autowired
    private BYIM0101BDao byim0101BDao;

    private List<StandardFrequenterLevelResult> frequenterLevelList;

    private List<StandardGradeResult> gradeList;

    private ByimGrade byimGrade;

    private ByimFrequenterLevel frequenterLevel;

    @Override
    public BaseDao getBaseDao() {
        return byim0101BDao;
    }

    /**
     * 查询买家基础信息
     *
     * @return
     */
    @Override
    public List<ByimBuyerResult> findByimBasicList() {
        return byim0101BDao.findByimBasicList();
    }

    ;

    /**
     * 单个买家处理计算标准信息
     *
     * @param byimBuyerResult
     */
    @Override
    public void doProcessWork(ByimBuyerResult byimBuyerResult) {
        byimGrade = new ByimGrade();
        byimGrade.setGradeId(this.maxId("BYIM_GRADE"));
        byimGrade.setCrtId(ByimCommConstant.CommString.BYIM_BATCH);
        byimGrade.setCrtTime(DateUtils.getCurrent());
        byimGrade.setUpdId(ByimCommConstant.CommString.BYIM_BATCH);
        byimGrade.setUpdTime(DateUtils.getCurrent());
        byimGrade.setBuyerId(byimBuyerResult.getBuyerId());
        frequenterLevel = new ByimFrequenterLevel();
        frequenterLevel.setLevelId(this.maxId("BYIM_FREQUENTER_LEVEL"));
        frequenterLevel.setCrtId(ByimCommConstant.CommString.BYIM_BATCH);
        frequenterLevel.setCrtTime(DateUtils.getCurrent());
        frequenterLevel.setUpdId(ByimCommConstant.CommString.BYIM_BATCH);
        frequenterLevel.setUpdTime(DateUtils.getCurrent());
        frequenterLevel.setBuyerId(byimBuyerResult.getBuyerId());


        // 获取常客标准
        frequenterLevelList = byim0101BDao.findStandardLevelList();
        // 获取定性标准
        gradeList = byim0101BDao.findStandardGradeList();
        Map<String, Object> standardResult = new HashMap<>();
        OrderSearchRestResult<BuyerOrderResult> result = BaseRestClientUtil.getOrderListInfo(byimBuyerResult);

        if (result != null && result.getTotal() > 0) {
            // 进行数据的解析计算操作
            List<BuyerOrderResult> resultList = result.getData();
            standardResult = this.computeStandard(resultList);
        }else{
            standardResult = this.checkBasicLevel(0, 0, 0, 0);
            frequenterLevel.setAmount("0");
            frequenterLevel.setFrequency("0");
            byimGrade.setSingelAmount("0");
            byimGrade.setAllAmount("0");
        }

        ByimBuyer byimBuyer = new ByimBuyer();
        byimBuyer.setBuyerId(byimBuyerResult.getBuyerId());
        byimBuyer.setUpdTime(DateUtils.getCurrent());
        byimBuyer.setUpdId(ByimCommConstant.CommString.BYIM_BATCH);
        if (standardResult.get(ByimCommConstant.CommString.FREQ_MAP_F) != null) {
            StandardFrequenterLevelResult standardFrequenterLevelResult = (StandardFrequenterLevelResult) standardResult
                    .get(ByimCommConstant.CommString.FREQ_MAP_F);
            String freqMapF = "频次" + standardFrequenterLevelResult.getLevelStandard();
            frequenterLevel.setFrequenterLevelF(freqMapF);
            byimBuyer.setFrequenterLevelF(freqMapF);
        } else {
            frequenterLevel.setFrequenterLevelF(ByimCommConstant.CommString.NOT_FREQ_MAP_F);
            byimBuyer.setFrequenterLevelF(ByimCommConstant.CommString.NOT_FREQ_MAP_F);
        }
        if (standardResult.get(ByimCommConstant.CommString.FREQ_MAP_A) != null) {
            StandardFrequenterLevelResult standardFrequenterLevelResult = (StandardFrequenterLevelResult) standardResult
                    .get(ByimCommConstant.CommString.FREQ_MAP_A);
            String freqMapA = "量级" + standardFrequenterLevelResult.getLevelStandard();
            frequenterLevel.setFrequenterLevelA(freqMapA);
            byimBuyer.setFrequenterLevelA(freqMapA);
        } else {
            frequenterLevel.setFrequenterLevelA(ByimCommConstant.CommString.NOT_FREQ_MAP_A);
            byimBuyer.setFrequenterLevelA(ByimCommConstant.CommString.NOT_FREQ_MAP_A);
        }
        // 后台通过平台判定是哪来的数据  单纯订单数据 后面“+”  单纯进货单 “-” 两者都有用“+”
        if (standardResult.get(ByimCommConstant.CommString.GRADE_MAP) != null) {
            StandardGradeResult standardGradeResult = (StandardGradeResult) standardResult
                    .get(ByimCommConstant.CommString.GRADE_MAP);
            String gradeMap = "";
            if(ByimCommConstant.CommString.STR_ZERO.equals(byimGrade.getSingelAmount())
                    && ByimCommConstant.CommString.STR_ZERO.equals(byimGrade.getAllAmount())){
                gradeMap = standardGradeResult.getGradeStandard() + "-";
            }else{
                gradeMap = standardGradeResult.getGradeStandard() + "+";
            }
            byimBuyer.setGrade(gradeMap);
        } else {
            byimBuyer.setGrade(ByimCommConstant.CommString.NOT_GRADE_MAP);
        }

        if (standardResult.get(ByimCommConstant.CommString.FREQ_CODE) != null) {
            byimBuyer.setFrequenterLevelCode(StringUtils.toString(standardResult.get(ByimCommConstant.CommString.FREQ_CODE)));
            frequenterLevel.setFrequenterLevelCode(StringUtils.toString(standardResult.get(ByimCommConstant.CommString.FREQ_CODE)));

        } else {
            byimBuyer.setFrequenterLevelCode(ByimCommConstant.CommString.STR_ZERO);
            frequenterLevel.setFrequenterLevelCode(ByimCommConstant.CommString.STR_ZERO);

        }

        frequenterLevel.setFrequenterLevelF(byimBuyer.getFrequenterLevelF());
        frequenterLevel.setFrequenterLevelA(byimBuyer.getFrequenterLevelA());
        frequenterLevel.setFrequenterLevelCode(byimBuyer.getFrequenterLevelCode());

        byimGrade.setGrade(byimBuyer.getGrade());

        // 更新买家信息
        byim0101BDao.updateStandard(byimBuyer);
        // 记录该次变更的履历信息
        byim0101BDao.saveFrequenterLevel(frequenterLevel);
        byim0101BDao.saveGrade(byimGrade);
    }

    /**
     * 所有订单信息必定到第三层级 如果不到 则 数据本身错误
     */
    public Map<String, Object> computeStandard(List<BuyerOrderResult> resultList) {
        // 记录常客频次
        Map<String, Integer> frequenter = new HashMap<>();
        int allFrequenter = 0; // 总频次
        int orderAllNum = 0; // 两个半旬销售订单的所有箱数
        int singelAmount = 0; // 所有符合条件订单中数量最大的单品个数(针对某一笔订单中)
        int allAmount = 0; // 所有符合条件订单中数量最大的单品个数(针对一笔订单中)

        for (BuyerOrderResult buyer : resultList) {
            // 统计常客频次（一天存在订单 即为 1）
            String day = DateUtils.format(DateUtils.FORMAT_YYYY_MM_DD, buyer.getOrderPlaceDatetime());
            if (!frequenter.containsKey(day)) {
                frequenter.put(day, 1);
            }
            // 判断是否分批订单 不是分批订单 表示只有一条记录信息
            // 获取分批订单信息
            // int singelAmountBatch = 0;// 记录单笔订单中最大交易商品的数量
            int allAmountBatch = 0; // 统计一笔订单中所有商品数量总和
            List<BuyerOrderBatchResutl> batchOrders = buyer.getBatchOrders();
            for (BuyerOrderBatchResutl buyerOrderBatchBean : batchOrders) {
                // 获取订单明细
                List<BuyerOrderBatchDetailResult> batchOrderDetails = buyerOrderBatchBean.getBatchOrderDetails();
                for (BuyerOrderBatchDetailResult buyerOrderBatchDetailBean : batchOrderDetails) {
                    // 获取实际销售数量信息
                    BigDecimal num = buyerOrderBatchDetailBean.getGoodsQuantity()
                            .subtract(buyerOrderBatchDetailBean.getCancelQuantity());
                    orderAllNum += num.intValue(); // 用于所有订单中的数量总数量
                    allAmountBatch += num.intValue(); // 记录当前订单中所有商品的总数量
                    if (num.intValue() > singelAmount) {
                        singelAmount = num.intValue();
                    }
                }
            }
            // 取最大的一个订单商品数量
            if (allAmountBatch > allAmount) {
                allAmount = allAmountBatch;
            }
        }
        // 计算获取订单频次
        allFrequenter = frequenter.size();
        frequenterLevel.setAmount(StringUtils.toString(allAmount));
        frequenterLevel.setFrequency(StringUtils.toString(allFrequenter));
        byimGrade.setSingelAmount(StringUtils.toString(singelAmount));
        byimGrade.setAllAmount(StringUtils.toString(allAmount));
        Map<String, Object> result = this.checkBasicLevel(allFrequenter, orderAllNum, singelAmount, allAmount);
//        System.out.println("=================================================");
//        System.out.println("数据值;" + allFrequenter +"  "+ orderAllNum+"   "+singelAmount+"    "+allAmount);
//        System.out.println("=================================================");
        return result;
    }

    /**
     * @param allFrequenter 总频次
     * @param orderAllNum   两个半旬销售订单的所有箱数
     * @param singelAmount  两个半旬销售订单的所有箱数
     * @param allAmount     所有符合条件订单中数量最大的单品个数(针对一笔订单中)
     */
    public Map<String, Object> checkBasicLevel(int allFrequenter, int orderAllNum, int singelAmount, int allAmount) {
        List<Integer> frequenNum = new ArrayList<>();
        List<Integer> magnitude = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        if (frequenterLevelList != null) {
            for (StandardFrequenterLevelResult frequenBean : frequenterLevelList) {
                frequenNum.add(frequenBean.getMinFrequency());
                magnitude.add(frequenBean.getMinAmount());

                if (allFrequenter >= frequenBean.getMinFrequency()) {
                    // 取出符合条件的级别
                    StandardFrequenterLevelResult res = (StandardFrequenterLevelResult) resultMap
                            .get(ByimCommConstant.CommString.FREQ_MAP_F);
                    if (res == null) {
                        resultMap.put(ByimCommConstant.CommString.FREQ_MAP_F, frequenBean);
                    } else {
                        if (frequenBean.getMinFrequency() > res.getMinFrequency()) {
                            resultMap.put(ByimCommConstant.CommString.FREQ_MAP_F, frequenBean);
                        }
                    }
                }
                if (orderAllNum >= frequenBean.getMinAmount()) {
                    StandardFrequenterLevelResult res = (StandardFrequenterLevelResult) resultMap
                            .get(ByimCommConstant.CommString.FREQ_MAP_A);
                    if (res == null) {
                        resultMap.put(ByimCommConstant.CommString.FREQ_MAP_A, frequenBean);
                    } else {
                        if (frequenBean.getMinFrequency() > res.getMinFrequency()) {
                            resultMap.put(ByimCommConstant.CommString.FREQ_MAP_A, frequenBean);
                        }
                    }
                }
            }
            Collections.sort(frequenNum);
            Collections.sort(magnitude);
            List<Integer> frequenLevel = frequenNum.subList(0, 4);
            List<Integer> magnitudeLevel = magnitude.subList(0, 4);
            Integer frequenterLevelCode = null;
            if(resultMap.size() > 0){
                for (int i = 0; i < 4; i++) {
                    StandardFrequenterLevelResult frequenterResult = (StandardFrequenterLevelResult) resultMap
                            .get(ByimCommConstant.CommString.FREQ_MAP_F);
                    StandardFrequenterLevelResult magnitudeResult = (StandardFrequenterLevelResult) resultMap
                            .get(ByimCommConstant.CommString.FREQ_MAP_A);
                    if ((frequenterResult != null && frequenLevel.get(i) == frequenterResult.getMinFrequency()) || (magnitudeResult != null && magnitudeLevel.get(i) == magnitudeResult.getMinAmount())) {
                        if (frequenterLevelCode == null) {
                            frequenterLevelCode = i;
                        } else {
                            if (i >= frequenterLevelCode) {
                                // 取最小一层级
                                frequenterLevelCode = i;
                            }
                        }
                    }
                }
            }
            if (frequenterLevelCode == null) {
                frequenterLevelCode = 0;
            }
            resultMap.put(ByimCommConstant.CommString.FREQ_CODE, frequenterLevelCode);
        }
        if (gradeList != null) {
            for (StandardGradeResult gradeBean : gradeList) {
                if (singelAmount >= gradeBean.getSingelAmount() || allAmount >= gradeBean.getAllAmount()) {
                    StandardGradeResult res = (StandardGradeResult) resultMap
                            .get(ByimCommConstant.CommString.GRADE_MAP);
                    if (res == null) {
                        resultMap.put(ByimCommConstant.CommString.GRADE_MAP, gradeBean);
                    } else {
                        if (gradeBean.getSingelAmount() > res.getSingelAmount()) {
                            resultMap.put(gradeBean.getGradeStandard(), gradeBean);
                        }
                    }

                }
            }
        }

        return resultMap;
    }
}
