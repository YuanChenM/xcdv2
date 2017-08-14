package com.bms.bymt.constant;

/**
 * Created by guan_zhongheng on 2016/12/15.
 */
public interface MessageDef {
    String MODULE_NAME = "BYMT.";

    interface Info{
        /**I00001:{0}数据查询成功*/
        String I00001 = MODULE_NAME + "I00001";
        /**I00002:{0}数据插入成功*/
        String I00002 = MODULE_NAME + "I00002";
        /**I00003:{0}数据批量插入成功,插入的数据如下所示*/
        String I00003 = MODULE_NAME + "I00003";
        /**I00004:{0}数据修改成功,插入的数据如下所示*/
        String I00004 = MODULE_NAME + "I00004";
        /**I00005:{0}字段长度不得超过{1}位 数据如下所示*/
        String I00005 = MODULE_NAME + "I00005";
        /**I00001:未查询到数据*/
        String I00006 = MODULE_NAME + "I00006";
        /**I00007:操作成功*/
        String I00007 = MODULE_NAME + "I00007";
    }
    interface Error{
        /**E00001:第{0}条数据{1}重复*/
        String E00001 = MODULE_NAME + "E00001";
        /**E00002:第{0}条数据{1}与DB数据重复*/
        String E00002 = MODULE_NAME + "E00002";
        /**E00003:数据库操作异常*/
        String E00003 = MODULE_NAME + "E00003";
        /**E00004:级别标准编码或级别标准等级已存在！不可新增！*/
        String E00004 = MODULE_NAME + "E00004";
        /**E00005:第{0}条数据修改失败 */
        String E00005 = MODULE_NAME + "E00005";
    }
    interface Warn{
        /**W00001:*/
        String W00001 = MODULE_NAME + "W00001";
    }
    interface Label{
        String L00001 = MODULE_NAME + "L00001";
        String L00002 = MODULE_NAME + "L00002";
        String L00003 = MODULE_NAME + "L00003";
        String L00004 = MODULE_NAME + "L00004";
        String L00005 = MODULE_NAME + "L00005";
        String L00006 = MODULE_NAME + "L00006";
        String L00007 = MODULE_NAME + "L00007";
        String L00008 = MODULE_NAME + "L00008";
        String L00009 = MODULE_NAME + "L00009";
        String L00010 = MODULE_NAME + "L00010";
        String L00011 = MODULE_NAME + "L00011";
        String L00012 = MODULE_NAME + "L00012";

        String L00013 = MODULE_NAME + "L00013";
        String L00014 = MODULE_NAME + "L00014";
        String L00015 = MODULE_NAME + "L00015";
        String L00016 = MODULE_NAME + "L00016";
        String L00017 = MODULE_NAME + "L00017";
        String L00018 = MODULE_NAME + "L00018";
        String L00019 = MODULE_NAME + "L00019";
        /**级别标准编码 */
        String L00020 = MODULE_NAME + "L00020";
        /**级别标准等级 */
        String L00021 = MODULE_NAME + "L00021";
        /**占地面积 */
        String L00022 = MODULE_NAME + "L00022";
        /**市场年销售额 */
        String L00023 = MODULE_NAME + "L00023";
        /**最大分类目标买家 */
        String L00024 = MODULE_NAME + "L00024";
        /**目标买家总数 */
        String L00025 = MODULE_NAME + "L00025";
        /**主要买家群体 */
        String L00026 = MODULE_NAME + "L00026";
        /**市场辐射范围 */
        String L00027 = MODULE_NAME + "L00027";
        /**请输入参数 */
        String L00028 = MODULE_NAME + "L00028";
        /**年交易额 */
        String L00029 = MODULE_NAME + "L00029";
        /**标准级别ID */
        String L00042 = MODULE_NAME + "L00042";
        /**非目标买家名称 */
        String L00043 = MODULE_NAME + "L00043";
        /**非目标买家户数 */
        String L00050 = MODULE_NAME + "L00050";
        /**菜场名称 */
        String L00030 = MODULE_NAME + "L00030";
        /**菜场编码 */
        String L00031 = MODULE_NAME + "L00031";
        /**菜场地址 */
        String L00032 = MODULE_NAME + "L00032";
        /**菜场类型 */
        String L00033 = MODULE_NAME + "L00033";
        /**地段类型 */
        String L00034 = MODULE_NAME + "L00034";
        /**物流区编码 */
        String L00035 = MODULE_NAME + "L00035";
        /**物流区名称 */
        String L00036 = MODULE_NAME + "L00036";
        /**城市编码 */
        String L00037 = MODULE_NAME + "L00037";
        /**城市名称 */
        String L00038 = MODULE_NAME + "L00038";
        /**区县编码 */
        String L00039 = MODULE_NAME + "L00039";
        /**区县名称 */
        String L00040 = MODULE_NAME + "L00040";
        /**菜场ID */
        String L00041 = MODULE_NAME + "L00041";
        /**地段类型 */
        String L00044 = MODULE_NAME + "L00044";

        /**证件图片类型 */
        String L00045 = MODULE_NAME + "L00045";

        /**批发市场名称 */
        String L00046 = MODULE_NAME + "L00046";
        /**市场等级 */
        String L00047 = MODULE_NAME + "L00047";
        /**批发市场编码 */
        String L00048 = MODULE_NAME + "L00048";
        /**批发市场地址 */
        String L00049 = MODULE_NAME + "L00049";
        /**非目标买家ID */
        String L00051 = MODULE_NAME + "L00051";

        /**证件ID */
        String L00052 = MODULE_NAME + "L00052";
        /**市场ID */
        String L00053 = MODULE_NAME + "L00053";
        /**证件图片地址 */
        String L00054 = MODULE_NAME + "L00054";
        /**删除标志 */
         String L00055 = MODULE_NAME + "L00055";


        /**市场买家最大分类产品 */
        String L00056 = MODULE_NAME + "L00056";
        /**市场买家最大分类产品个数 */
        String L00057 = MODULE_NAME + "L00057";
        /**市场买家最大分类产品标准 */
        String L00058 = MODULE_NAME + "L00058";
        /**菜场辐射范围 */
        String L00059 = MODULE_NAME + "L00059";
        /**菜场辐射范围级别标准 */
        String L00060 = MODULE_NAME + "L00060";
        /**买家平均定价 */
        String L00061 = MODULE_NAME + "L00061";
        /**定价标准 */
        String L00062 = MODULE_NAME + "L00062";


        /**定级详情ID */
        String L00068 = MODULE_NAME + "L00068";
        /**买家数最多的分类产品 */
        String L00063 = MODULE_NAME + "L00063";
        /**买家最大分类产品个数 */
        String L00064 = MODULE_NAME + "L00064";
        /**买家平均定价 */
        String L00065 = MODULE_NAME + "L00065";
        /**菜场级别 */
        String L00066 = MODULE_NAME + "L00066";
        /**辐射范围 */
        String L00067 = MODULE_NAME + "L00067";


        /**批发市场详情ID */
        String L00069 = MODULE_NAME + "L00069";
        /**批发市场级别 */
        String L00070 = MODULE_NAME + "L00070";
        /**批发市场服务类型 */
        String L00071 = MODULE_NAME + "L00071";
        /**批发市场辐射范围 */
        String L00072 = MODULE_NAME + "L00072";


        /**依托大型冷库(依托) */
        String L00073 = MODULE_NAME + "L00073";
        /**批发市场定性类别 */
        String L00074 = MODULE_NAME + "L00074";


    }
}
