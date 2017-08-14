package com.bms.prce.service.impl;

import com.bms.prce.bean.param.PRCE0403UploadDetailParam;
import com.bms.prce.bean.param.PRCE0403UploadParam;
import com.framework.base.consts.NumberConst;
import com.framework.boot.plugin.async.bean.param.AsyncUploadParam;
import com.framework.boot.plugin.async.service.impl.UploadExcelReadImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.DecimalUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by memorykai on 2017/5/7.
 */
@Service("prce0403Read")
public class Prce0403UploadRead extends UploadExcelReadImpl {
    //excel单元格常量定义
    private static final int LGCS_AREA_NAME = NumberConst.IntDef.INT_ZERO;   //物流区code
    private static final int COMMODITITY_CODE = NumberConst.IntDef.INT_ONE;      //商品编码
    private static final int PRODUCT_CODE = NumberConst.IntDef.INT_THREE;      //产品编码
    private static final int MARKETING_STATUS_NAME = NumberConst.IntDef.INT_TWELVE;     //营销状态
    private static final int USER_TYPE_NAME = NumberConst.IntDef.INT_FOURTEEN;    //价盘用户类型
    private static final int BUYER_LEVEL_NAME = NumberConst.IntDef.INT_FIFTEEN;  //买家等级
    private static final int START_TIME = NumberConst.IntDef.INT_SIXTEEN;     //生效时间
    private static final int NORM_PRICE = NumberConst.IntDef.INT_SEVENTEEN;      //标准价格
    private static final int WAY_CONFIG_NAME = NumberConst.IntDef.INT_EIGHTEEN;      //通道分类描述（第一个）
    private static final int FACT_PRICE = NumberConst.IntDef.INT_EIGHTEEN;      //实际价格
    private static final String END = "END";      //结束符

    @Override
    public List<PRCE0403UploadParam> toRead(Workbook workbook, AsyncUploadParam asyncUploadParam) {
        Sheet sheet = workbook.getSheetAt(NumberConst.IntDef.INT_ZERO);     //获取sheet,默认取第一个sheet
        int rowNum = sheet.getLastRowNum();     //总行数
        //TODO
        if (NumberConst.IntDef.INT_FIVE >= rowNum)
            throw new BusinessException("PRCE", "导入模板没有数据");
        //结束符判断
        Row endRow = sheet.getRow(rowNum);
        if (null == endRow || endRow.equals("") || !END.equals(getCellValue(endRow.getCell(NumberConst.IntDef.INT_ZERO)))){
            throw new BusinessException("PRCE", "无法获取到数据结束符");
        }

        this.checkParams(sheet, rowNum);        //检查excel中是否存在空值
        int colNum = sheet.getRow(NumberConst.IntDef.INT_ZERO).getPhysicalNumberOfCells();      //总列数,计算营销通道个数
        int wayConfigNum = (colNum - WAY_CONFIG_NAME) / NumberConst.IntDef.INT_TWO;   //作为循环的长度
        Row row = null;
        List<PRCE0403UploadParam> uploadParamList = new ArrayList<>();
        PRCE0403UploadParam uploadParam = null;
        List<PRCE0403UploadDetailParam> pricePlateList;
        PRCE0403UploadDetailParam uploadDetailParam = null;
        for (int i = NumberConst.IntDef.INT_FIVE; i < rowNum; i++) {     //除去第一行头部信息
            row = sheet.getRow(i);
            if (null == row || row.equals(""))
                continue;

            uploadParam = new PRCE0403UploadParam();  //读取excel参数
            pricePlateList = new ArrayList<>();
            uploadParam.setLgcsAreaName(getCellValue(row.getCell(LGCS_AREA_NAME)));
            uploadParam.setCommodityCode(getCellValue(row.getCell(COMMODITITY_CODE)));
            uploadParam.setProductCode(getCellValue(row.getCell(PRODUCT_CODE)));
            uploadParam.setMarketingStatusName(getCellValue(row.getCell(MARKETING_STATUS_NAME)));
            uploadParam.setUserTypeName(getCellValue(row.getCell(USER_TYPE_NAME)));
            uploadParam.setBuyerLevelName(getCellValue(row.getCell(BUYER_LEVEL_NAME)));
            uploadParam.setStartTime(getCellValue(row.getCell(START_TIME)));
            uploadParam.setNormPrice(DecimalUtils.getBigDecimal(getCellValue(row.getCell(NORM_PRICE))));
            for (int j = NumberConst.IntDef.INT_ZERO; j < wayConfigNum; j++) {  //遍历多有通道分类
                uploadDetailParam = new PRCE0403UploadDetailParam();
                //从18列（大宗1级）开始，计算每一级对应的cell
                uploadDetailParam.setWayConfigName(getCellValue(sheet.getRow(NumberConst.IntDef.INT_TWO).getCell(WAY_CONFIG_NAME + j * NumberConst.IntDef.INT_TWO)));
                uploadDetailParam.setFactPrice(DecimalUtils.getBigDecimal(getCellValue(row.getCell(FACT_PRICE + j * NumberConst.IntDef.INT_TWO))));
                pricePlateList.add(uploadDetailParam);
            }

            uploadParam.setPricePlateList(pricePlateList);
            uploadParamList.add(uploadParam);
        }
        return uploadParamList;

    }

    /**
     * check数据必须性(只校验字段是否非空,业务校验在process处理)
     */
    private void checkParams(Sheet sheet, int rowNum) {
        int colNum = sheet.getRow(NumberConst.IntDef.INT_ZERO).getPhysicalNumberOfCells();      //总列数,计算营销通道个数
        int wayConfigNum = (colNum - WAY_CONFIG_NAME) / NumberConst.IntDef.INT_TWO;   //作为循环的长度
        //excel单元格对应的字段
        String commodityCodeStr = null;
        String marketStatusNameStr = null;
        String lgcsAreaNameStr = null;
        String userTypeNameStr = null;
        String buyerLevelNameStr = null;
        String startTimeStr = null;
        String normPriceStr = null;
//        String wayConfigNameStr = getCellValue(sheet.getRow(NumberConst.IntDef.INT_TWO).getCell(WAY_CONFIG_NAME));
        String factPriceStr = null;
        Row row = null;     //每一行数据
        StringBuilder str_empty = new StringBuilder();      //excel的商品编码为空
        for (int i = NumberConst.IntDef.INT_FIVE; i < rowNum; i++) {     //除去第一行头部信息,行和列从0开始的,log加一
            row = sheet.getRow(i);
            if (null == row || row.equals(""))
                continue;

            commodityCodeStr = getCellValue(row.getCell(COMMODITITY_CODE));
            marketStatusNameStr = getCellValue(row.getCell(MARKETING_STATUS_NAME));
            lgcsAreaNameStr = getCellValue(row.getCell(LGCS_AREA_NAME));
            userTypeNameStr = getCellValue(row.getCell(USER_TYPE_NAME));
            buyerLevelNameStr = getCellValue(row.getCell(BUYER_LEVEL_NAME));
            startTimeStr = getCellValue(row.getCell(START_TIME));
            normPriceStr = getCellValue(row.getCell(NORM_PRICE));
//            factPriceStr = getCellValue(row.getCell(FACT_PRICE));

            if (StringUtils.isEmpty(commodityCodeStr))
                str_empty.append(i + 1 + "行-" + (COMMODITITY_CODE + 1) + "列,");
            if (StringUtils.isEmpty(lgcsAreaNameStr))
                str_empty.append(i + 1 + "行-" + (LGCS_AREA_NAME + 1 )+ "列,");
            if (StringUtils.isEmpty(marketStatusNameStr))
                str_empty.append(i + 1 + "行-" + (MARKETING_STATUS_NAME + 1) + "列,");
            if (StringUtils.isEmpty(userTypeNameStr))
                str_empty.append(i + 1 + "行-" + (USER_TYPE_NAME + 1) + "列,");
            if (StringUtils.isEmpty(startTimeStr))
                str_empty.append(i + 1 + "行-" + (START_TIME + 1) + "列,");
            if (!Prce0403UploadProcess.AGENT.equals(userTypeNameStr)) {
                //用户类型为买家和账期买家时判断买家等级,为买手时,不判断买家等级
                if (StringUtils.isEmpty(buyerLevelNameStr))
                    str_empty.append(i + 1 + "行-" + (BUYER_LEVEL_NAME + 1 )+ "列,");
            }
            if (StringUtils.isEmpty(normPriceStr))
                str_empty.append(i + 1 + "行-" + (NORM_PRICE + 1) + "列,");
//            if (StringUtils.isEmpty(wayConfigNameStr))
//                str_empty.append(i + "行-" + WAY_CONFIG_NAME + "列,");
            //循环实际价格，判断不能为空
            //买手只判断第一个
            if (!StringUtils.isEmpty(userTypeNameStr) && Prce0403UploadProcess.AGENT.equals(userTypeNameStr)) {
                if (StringUtils.isEmpty(getCellValue(row.getCell(FACT_PRICE))))
                    str_empty.append(i + 1 + "行-" + (FACT_PRICE + 1 ) + "列,");
            } else {
                //买家和账期买家判断全部
                for (int j = NumberConst.IntDef.INT_ZERO; j < wayConfigNum; j++) {  //判断通道分类个数
                    if (StringUtils.isEmpty(getCellValue(row.getCell(FACT_PRICE + j * NumberConst.IntDef.INT_TWO))))
                        str_empty.append(i+ 1 + "行-" + (FACT_PRICE + j * NumberConst.IntDef.INT_TWO + 1 )+ "列,");
                }
            }

        }
        if (!ObjectUtils.isEmpty(str_empty))
            throw new BusinessException("PRCE", str_empty.append("不能为空").toString());
    }

    /**
     * 获取对应单元格的值
     */
    private String getCellValue(Cell cell) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.0000");
        if (cell == null)
            return "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return DateUtils.formatDateTime(DateUtil.getJavaDate(cell.getNumericCellValue()));
                }
                return decimalFormat.format(cell.getNumericCellValue());
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();
            case Cell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();
            case Cell.CELL_TYPE_BLANK:
                return "";
            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() + "";
            case Cell.CELL_TYPE_ERROR:
                return cell.getErrorCellValue() + "";
        }
        return "";
    }

}
