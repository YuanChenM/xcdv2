package com.bms.bypo.constant;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface MessageDef {
    String MODULE_NAME = "BYPO.";


    interface Info{
        /**I00001:{0}数据查询成功*/
        String I00001 = MODULE_NAME + "I00001";
        /**I00002:{0}数据插入成功,插入的数据如下所示*/
        String I00002 = MODULE_NAME + "I00002";
        /**I00003:{0}数据更新成功,更新的主键ID如下所示*/
        String I00003 = MODULE_NAME + "I00003";
    }

    interface Error{
        /**E00001:第{0}条数据{1}重复*/
        String E00001 = MODULE_NAME + "E00001";
        /**E00002:第{0}条数据{1}与DB数据重复*/
        String E00002 = MODULE_NAME + "E00002";
        /**E00003:新增失败*/
        String E00003 = MODULE_NAME + "E00003";
    }

    interface Warn{
        /**W00001:*/
        String W00001 = MODULE_NAME + "W00001";
    }

    interface Label{
        /**L00001:分类买家池*/
        String L00001 = MODULE_NAME + "L00001";
        /**L00002:传入参数*/
        String L00002 = MODULE_NAME + "L00002";
        /**L00003:物流区编码*/
        String L00003 = MODULE_NAME + "L00003";
        /**L00004:物流区名称*/
        String L00004 = MODULE_NAME + "L00004";
        /**L00005:买家类型*/
        String L00005 = MODULE_NAME + "L00005";
        /**L00006:买家一级分类编码*/
        String L00006 = MODULE_NAME + "L00006";
        /**L00007:买家一级分类名称*/
        String L00007 = MODULE_NAME + "L00007";
        /**L00008:买家二级分类编码*/
        String L00008 = MODULE_NAME + "L00008";
        /**L00009:买家二级分类名称*/
        String L00009 = MODULE_NAME + "L00009";
        /**L00010:分类买家池编码*/
        String L00010 = MODULE_NAME + "L00010";
        /**L00011:分类买家池名称*/
        String L00011 = MODULE_NAME + "L00011";
        /**L00012:filter*/
        String L00012 = MODULE_NAME + "L00012";
        /**L00013:target*/
        String L00013 = MODULE_NAME + "L00013";
        /**L00014:分类买家池ID*/
        String L00014 = MODULE_NAME + "L00014";
        /**L00015:买家ID*/
        String L00015 = MODULE_NAME + "L00015";
        /**L00016:买家编码*/
        String L00016 = MODULE_NAME + "L00016";
        /**L00017:买家名称*/
        String L00017 = MODULE_NAME + "L00017";
        /**L00018:调研ID*/
        String L00018 = MODULE_NAME + "L00018";


        /**L00019:单品一级分类ID*/
        String L00019 = MODULE_NAME + "L00019";
        /**L00020:单品一级分类编码*/
        String L00020 = MODULE_NAME + "L00020";
        /**L00021:单品一级分类名称*/
        String L00021 = MODULE_NAME + "L00021";
        /**L00022:单品二级分类ID*/
        String L00022 = MODULE_NAME + "L00022";
        /**L00023:单品二级分类编码*/
        String L00023 = MODULE_NAME + "L00023";
        /**L00024:单品二级分类名称*/
        String L00024 = MODULE_NAME + "L00024";
        /**L00025:品种ID*/
        String L00025 = MODULE_NAME + "L00025";
        /**L00026:品种编码*/
        String L00026 = MODULE_NAME + "L00026";
        /**L00027:品种标准市场销售名*/
        String L00027 = MODULE_NAME + "L00027";
        /**L00028:品种学名*/
        String L00028 = MODULE_NAME + "L00028";
        /**L00029:品种俗名*/
        String L00029 = MODULE_NAME + "L00029";
        /**L00030:单品特征ID*/
        String L00030 = MODULE_NAME + "L00030";
        /**L00031:单品特征编码*/
        String L00031 = MODULE_NAME + "L00031";
        /**L00032:单品特征名称*/
        String L00032 = MODULE_NAME + "L00032";
        /**L00033:品牌ID*/
        String L00033 = MODULE_NAME + "L00033";
        /**L00034:品牌编码*/
        String L00034 = MODULE_NAME + "L00034";
        /**L00035:品牌名称*/
        String L00035 = MODULE_NAME + "L00035";
        /**L00036:生产商ID*/
        String L00036 = MODULE_NAME + "L00036";
        /**L00037:生产商编码*/
        String L00037 = MODULE_NAME + "L00037";
        /**L00038:生产商名称*/
        String L00038 = MODULE_NAME + "L00038";
        /**L00039:产品需求等级*/
        String L00039 = MODULE_NAME + "L00039";
        /**L00040:分类买家池标准产品池*/
        String L00040 = MODULE_NAME + "L00040";
        /**L00041:分类买家池标准产品池ID*/
        String L00041 = MODULE_NAME + "L00041";

        /**L00042:品牌所有人编码*/
        String L00042 = MODULE_NAME + "L00042";
        /**L00043:品牌所有人名称*/
        String L00043 = MODULE_NAME + "L00043";
        /**L00044:小包装特征*/
        String L00044 = MODULE_NAME + "L00044";
        /**L00045:小包装件数/大包装个数*/
        String L00045 = MODULE_NAME + "L00045";
        /**L00046:净重*/
        String L00046 = MODULE_NAME + "L00046";
        /**L00047:毛重*/
        String L00047 = MODULE_NAME + "L00047";
        /**L00048:纸箱尺寸*/
        String L00048 = MODULE_NAME + "L00048";
        /**L00049:产品等级*/
        String L00049 = MODULE_NAME + "L00049";
        /**L00050:托盘堆码数*/
        String L00050 = MODULE_NAME + "L00050";
        /**L00051:是否标准产品*/
        String L00051 = MODULE_NAME + "L00051";
        /**L00052:买家产品销售调研产品信息*/
        String L00052 = MODULE_NAME + "L00052";
        /**L00053:调研产品ID*/
        String L00053 = MODULE_NAME + "L00053";


        /**L00054:产品销售信息*/
        String L00054 = MODULE_NAME + "L00054";
        /**L00055:产品销售ID*/
        String L00055 = MODULE_NAME + "L00055";
        /**L00056:销售日期*/
        String L00056 = MODULE_NAME + "L00056";
        /**L00057:销售量*/
        String L00057 = MODULE_NAME + "L00057";
        /**L00058:单价*/
        String L00058 = MODULE_NAME + "L00058";
        /**L00059:价盘通道*/
        String L00059 = MODULE_NAME + "L00059";
        /**L00060:客户对象*/
        String L00060 = MODULE_NAME + "L00060";
        /**L00061:买家类型名称*/
        String L00061 = MODULE_NAME + "L00061";

    }
}
