package com.bms.region.constant;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface MessageDef {
    String MODULE_NAME = "REGN.";

    interface Info{
        /**I00001:{0}数据查询成功*/
        String I00001 = MODULE_NAME + "I00001";
        /**I00002:{0}数据插入成功*/
        String I00002 = MODULE_NAME + "I00002";
        /**I00003:{0}数据批量插入成功,插入的数据如下所示*/
        String I00003 = MODULE_NAME + "I00003";
        /**I00004:{0}数据修改成*/
        String I00004 = MODULE_NAME + "I00004";
        /**I00005:{0}没有查询到数据*/
        String I00005 = MODULE_NAME + "I00005";

    }

    interface Error{
        /**E00001: 第{0}条数据{1}重复*/
        String E00001 = MODULE_NAME + "E00001";
        /**E00002: 第{0}条数据{1}与DB数据重复*/
        String E00002 = MODULE_NAME + "E00002";
        /**E00003: 数据库操作异常{0}*/
        String E00003 = MODULE_NAME + "E00003";
        /**E00004: 数据库插入异常*/
        String E00004 = MODULE_NAME + "E00004";
        /**E00005: 数据库字段修改异常*/
        String E00005 = MODULE_NAME + "E00005";
        /**E00006: 数据库字段修改异常*/
        String E00006 = MODULE_NAME + "E00006";
        /**E00007: 数据库字段修改异常*/
        String E00007 = MODULE_NAME + "E00007";
        /** E00008 第{0}条数据更新失败*/
        String E00008 = MODULE_NAME + "E00008";
        /** E00009 第{0}条数据{1}不存在*/
        String E00009 = MODULE_NAME + "E00009";
        /** E00010 第{0}条数据{1}为数据类型*/
        String E00010 = MODULE_NAME + "E00010";
        /** E00011 请传入参数*/
        String E00011 = MODULE_NAME + "E00011";
        /** E00012 第{0}条数据{1}和前几条某编码相同，不可新增*/
        String E00012 = MODULE_NAME + "E00012";
        /** E00012 第{0}条数据{1}和前几条某编码相同，不可新增*/
        String E00013 = MODULE_NAME + "E00013";
    }

    interface Warn{
        /**W00001:*/
        String W00001 = MODULE_NAME + "W00001";
    }

    interface Label{
        /**L00001: 物流区信息*/
        String L00001 = MODULE_NAME + "L00001";
        /**L00002: 省信息*/
        String L00002 = MODULE_NAME + "L00002";
        /**L00003: 城市信息*/
        String L00003 = MODULE_NAME + "L00003";
        /**L00004: 区县信息*/
        String L00004 = MODULE_NAME + "L00004";
        /**L00005: 街道信息*/
        String L00005 = MODULE_NAME + "L00005";
        /**L00006: 物流到街道关联关系*/
        String L00006 = MODULE_NAME + "L00006";

        /**L00007: 物流区编码*/
        String L00007 = MODULE_NAME + "L00007";
        /**L00008: 物流区名称*/
        String L00008 = MODULE_NAME + "L00008";
        /**L00009: 是否有效*/
        String L00009 = MODULE_NAME + "L00009";
        /**L00010: 物流区ID*/
        String L00010 = MODULE_NAME + "L00010";

        /**L00011: 省编码*/
        String L00011 = MODULE_NAME + "L00011";
        /**L00012: 省名称*/
        String L00012 = MODULE_NAME + "L00012";
        /**L00013: 省ID*/
        String L00013 = MODULE_NAME + "L00013";

        /**L00011: 街道编码*/
        String L00014 = MODULE_NAME + "L00014";
        /**L00012: 街道名称*/
        String L00015 = MODULE_NAME + "L00015";
        /**L00013: 街道ID*/
        String L00016 = MODULE_NAME + "L00016";

        /**L00017: 城市编码*/
        String L00017 = MODULE_NAME + "L00017";
        /**L00018: 城市名称*/
        String L00018 = MODULE_NAME + "L00018";
        /**L00019: 城市ID*/
        String L00019 = MODULE_NAME + "L00019";


        /**L00020: 区县编码*/
        String L00020 = MODULE_NAME + "L00020";
        /**L00021: 区县名称*/
        String L00021 = MODULE_NAME + "L00021";
        /**L00022: 区县ID*/
        String L00022 = MODULE_NAME + "L00022";
        /**L00023: 逻辑删除*/
        String L00023 = MODULE_NAME + "L00023";

        /**L00020: 物流区城市ID*/
        String L00024 = MODULE_NAME + "L00024";
        /**L00021: 物流区城市编码*/
        String L00025 = MODULE_NAME + "L00025";
        /**L00022: 物流区城市名称*/
        String L00026 = MODULE_NAME + "L00026";

        /**L00023: 配送站ID*/
        String L00027 = MODULE_NAME + "L00027";
        /**L00023: 配送站类型*/
        String L00028 = MODULE_NAME + "L00028";
        /**L00023: 配送站编码*/
        String L00029 = MODULE_NAME + "L00029";
        /**L00023: 配送站表示码(名称)*/
        String L00030 = MODULE_NAME + "L00030";

        /**L00023: 领地ID*/
        String L00031 = MODULE_NAME + "L00031";
        /**L00023: 领地类型*/
        String L00032 = MODULE_NAME + "L00032";
        /**L00023: 领地编码*/
        String L00033 = MODULE_NAME + "L00033";
        /**L00023: 领地表示码(名称)*/
        String L00034 = MODULE_NAME + "L00034";
    }

}