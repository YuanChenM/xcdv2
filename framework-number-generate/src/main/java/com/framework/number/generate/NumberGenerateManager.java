package com.framework.number.generate;

import com.framework.number.generate.bean.param.GenerateParam;
import com.framework.number.generate.bean.param.SequenceParam;

/**
 * Created by zhu_kai1 on 2016/11/17.
 */
public final class NumberGenerateManager {


    public static String sequences(String prefix){
        SequenceParam sequenceParam = new SequenceParam();
        sequenceParam.setPrefix(prefix);
        GenerateContext generateContext = new GenerateContext();
        return generateContext.generateNumber(sequenceParam);
    }

    /**
     *获取指定长度的业务编码
     * @param prefix 前缀名称
     * @param length 编码长度
     * @return
     */
    public static String sequences(String prefix,int length){
        return sequences(prefix,length,"0");
    }
    /**
     * 获取指定长度业务编码，以及指定补位符
     * @param prefix
     * @param length
     * @param padChar  自定义的补位符，默认补位符为0
     * @return
     */
    public static String sequences(String prefix,int length,String padChar){
        SequenceParam sequenceParam = new SequenceParam();
        sequenceParam.setPrefix(prefix);
        sequenceParam.setLength(length);
        sequenceParam.setPlaceholder(Boolean.TRUE);
        sequenceParam.setPadChar(padChar);
        GenerateContext context = new GenerateContext();
        return context.generateNumber(sequenceParam);
    }

    public static String sequences(NumberGenerate<GenerateParam> numberGenerate, GenerateParam param){
        return param.getPrefix()+"-"+numberGenerate.generateNumber(param)+"-"+sequences(param.getPrefix());
    }

//
//    /**
//     *获取指定方式重置的业务编码
//     * @param prefix 前缀
//     * @param resetType 重置方式 yyyy-代表每年，MM-每月，dd-每天，HH-每小时，mm-每分钟
//     * @return
//     */
//    public static String sequences(String prefix,ResetType resetType){
//        BusinessNumBean sequenceBean = new BusinessNumBean();
//        sequenceBean.setPrefix(prefix);
//        sequenceBean.setResetType(resetType);
//        GenerateContext context = new GenerateContext(new SequencesNumberGenerate(),sequenceBean);
//        return context.createNumber();
//    }
//
//    /**
//     *获取指定长度的业务编码，并且按照那种方式重置
//     * @param prefix 前缀
//     * @param resetType  ResetType该类已定义需要的resetType
//     *  重置方式 yyyy-代表每年，MM-每月，dd-每天，HH-每小时，mm-每分钟
//     * @return
//     */
//    public static String sequences(String prefix,ResetType resetType,int length){
//        BusinessNumBean sequenceBean = new BusinessNumBean();
//        sequenceBean.setPrefix(prefix);
//        sequenceBean.setResetType(resetType);
//        sequenceBean.setLength(length);
//        GenerateContext context = new GenerateContext(new SequencesNumberGenerate(),sequenceBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取默认yyyy-MM-dd-HH-mm-ss-SSSS格式的时间戳格式的业务编码
//     * @param prefix 如PD
//     * @return
//     */
//    public static String timestamp(String prefix){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setPrefix(prefix);
//        GenerateContext context = new GenerateContext(new TimestampGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取指定时间戳格式的业务编码
//     * @param dataFormat   DateFormatDef类已定义需要的dataFormat类型
//     * @return
//     */
//    public static String timestamp(String prefix,String dataFormat){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setPrefix(prefix);
//        timestampBean.setDataFormat(dataFormat);
//        GenerateContext context = new GenerateContext(new TimestampGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//
//    /**
//     * 获取指定时间戳格式、长度的业务编码
//     * @param prefix
//     * @param dataFormat DateFormatDef类已定义需要的dataFormat类型
//     * @param length
//     * @return
//     */
//    public static String timestamp(String prefix,String dataFormat,int length){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setDataFormat(dataFormat);
//        timestampBean.setPrefix(prefix);
//        timestampBean.setLength(length);
//        GenerateContext context = new GenerateContext(new TimestampGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取指定时间戳、长度、重置方式
//     * @param prefix
//     * @param dataFormat DateFormatDef类已定义需要的dataFormat类型
//     * @param length
//     * @return
//     */
//    public static String timestamp(String prefix,String dataFormat,int length,ResetType resetType){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setDataFormat(dataFormat);
//        timestampBean.setPrefix(prefix);
//        timestampBean.setLength(length);
//        timestampBean.setResetType(resetType);
//        GenerateContext context = new GenerateContext(new TimestampGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取指定长度、补位符、重置机制的业务编码
//     * @param prefix
//     * @param length
//     * @param resetType 重置方式 ResetType该类已定义需要的resetType
//     * @param coverStr  自定义补位符
//     * @return
//     */
//    public static String timestamp(String prefix,int length,ResetType resetType,String coverStr){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setPrefix(prefix);
//        timestampBean.setLength(length);
//        timestampBean.setResetType(resetType);
//        timestampBean.setCoverStr(coverStr);
//        GenerateContext context = new GenerateContext(new SequencesNumberGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取指定时间戳格式、长度、补位符、重置机制的业务编码
//     * @param prefix
//     * @param dataFormat DateFormatDef类已定义需要的dataFormat类型
//     * @param length
//     * @param resetType  ResetType该类已定义需要的resetType
//     * @param coverStr 自定义补位符
//     * @return
//     */
//    public static String timestamp(String prefix,String dataFormat,int length,ResetType resetType,String coverStr){
//        BusinessNumBean timestampBean = new BusinessNumBean();
//        timestampBean.setDataFormat(dataFormat);
//        timestampBean.setPrefix(prefix);
//        timestampBean.setLength(length);
//        timestampBean.setResetType(resetType);
//        timestampBean.setCoverStr(coverStr);
//        GenerateContext context = new GenerateContext(new TimestampGenerate(),timestampBean);
//        return context.createNumber();
//    }
//
//    /**
//     * 获取UUID的业务编码
//     * @param prefix
//     * @return
//     */
//    public static String uuid(String prefix){
//        BusinessNumBean uuidBean = new BusinessNumBean();
//        uuidBean.setPrefix(prefix);
//        GenerateContext context = new GenerateContext(new UUIDGenerate(),uuidBean);
//        return context.createNumber();
//    }

}
