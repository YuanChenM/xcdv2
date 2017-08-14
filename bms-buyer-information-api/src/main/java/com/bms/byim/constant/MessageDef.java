package com.bms.byim.constant;

/**
 * @author zhou_yajun
 * @version 1.0
 */
public interface MessageDef {
    String MODULE_NAME = "BYIM.";


    interface Info{
        /**I00001:{0}数据查询成功*/
        String I00001 = MODULE_NAME + "I00001";
        /**I00002:{0}数据插入成功,插入的数据如下所示*/
        String I00002 = MODULE_NAME + "I00002";
        /**I00003:{0}数据更新成功,更新的主键ID如下所示*/
        String I00003 = MODULE_NAME + "I00003";
        /**I00004:{0}未查询到数据*/
        String I00004 = MODULE_NAME + "I00004";
    }

    interface Error{
        /**第{0}条数据{1}已存在:*/
        String E00001 = MODULE_NAME + "E00001";
        /**第{0}条数据{1}不存在 */
        String E00002 = MODULE_NAME + "E00002";
        /**插入异常 */
        String E00003 = MODULE_NAME + "E00003";
        /**更新失败*/
        String E00004 = MODULE_NAME + "E00004";
        /**第{0}条数据更新失败:*/
        String E00005 = MODULE_NAME + "E00005";
        /**第{0}条数{1}不能重复:*/
        String E00006 = MODULE_NAME + "E00006";
        /**{0}不存在，不可修改:*/
        String E00007 = MODULE_NAME + "E00007";
        /**第{0}条数据{1}和其他相同节点下数据编码相同，不可新增:*/
        String E00008 = MODULE_NAME + "E00008";
        /**输入参数*/
        String E00009 = MODULE_NAME + "E00009";
        /**第{0}条数据{1}在数据集中存在重复数据*/
        String E00010 = MODULE_NAME + "E00010";
        /**第{0}条数据的买家在买家池中已绑定数据*/
        String E00011 = MODULE_NAME + "E00011";
    }

    interface Warn{
        /**W00001:*/
        String W00001 = MODULE_NAME + "W00001";
    }

    interface Label{
        String CITY_CODE = "城市编码";
        /**买家分类信息 */
        String L00001 = MODULE_NAME + "L00001";
        /**父节点 */
        String L00002 = MODULE_NAME + "L00002";
        /**分类名称 */
        String L00003 = MODULE_NAME + "L00003";
        /**分类编码 */
        String L00004 = MODULE_NAME + "L00004";
        /**买家上线状态 */
        String L00005 = MODULE_NAME + "L00005";
        /** 买家分类ID */
        String L00006 = MODULE_NAME + "L00006";
        /**买家上线状态ID */
        String L00007 = MODULE_NAME + "L00007";
        /**车辆通行区域 */
        String L00008 = MODULE_NAME + "L00008";
        /**请传入参数 */
        String L00009 = MODULE_NAME + "L00009";
        /**上线状态编码 */
        String L00010 = MODULE_NAME + "L00010";
        /**上线状态名称 */
        String L00011 = MODULE_NAME + "L00011";
        /*逻辑删除 */
        String L00012 = MODULE_NAME + "L00012";

        /**配送区域 */
        String L00013 = MODULE_NAME + "L00013";

        /**通行编码*/
        String L00014 = MODULE_NAME + "L00014";

        /**配送车型 */
        String L00015 = MODULE_NAME + "L00015";
        /**节点地址 */
        String L00016 = MODULE_NAME + "L00016";
        /**城市名称 */
        String L00017 = MODULE_NAME + "L00017";
        /**省编码 */
        String L00018 = MODULE_NAME + "L00018";
        /**省名称 */
        String L00019 = MODULE_NAME + "L00019";
        /**城市编码 */
        String L00020 = MODULE_NAME + "L00020";
        /**通行区域ID */
        String L00021 = MODULE_NAME + "L00021";

        /**物流区编码 */
        String L00022 = MODULE_NAME + "L00022";

        /**物流区名称 */
        String L00023 = MODULE_NAME + "L00023";

        /**传入参数 */
        String L00024 = MODULE_NAME + "L00024";
        /**filter */
        String L00025 = MODULE_NAME + "L00025";
        /**target */
        String L00026 = MODULE_NAME + "L00026";
        /** 买家名称*/
        String L00027 = MODULE_NAME	+ "L00027";
        /** 买家类型*/
        String L00028 = MODULE_NAME	+ "L00028";
        /** 买家类型名称*/
        String L00029 = MODULE_NAME	+ "L00029";
        /** 买家一级分类编码*/
        String L00030 = MODULE_NAME	+ "L00030";
        /** 买家一级分类名称*/
        String L00031 = MODULE_NAME	+ "L00031";
        /** 物流区ID*/
        String L00032 = MODULE_NAME	+ "L00032";
        /** 买家微信*/
        String L00033 = MODULE_NAME	+ "L00033";
        /** 买家QQ*/
        String L00034 = MODULE_NAME	+ "L00034";
        /** 省ID*/
        String L00035 = MODULE_NAME	+ "L00035";
        /** 买家地址*/
        String L00036 = MODULE_NAME	+ "L00036";
        /** 店铺ID*/
        String L00037 = MODULE_NAME	+ "L00037";
        /** 市ID*/
        String L00038 = MODULE_NAME	+ "L00038";
        /** 区县ID*/
        String L00041 = MODULE_NAME	+ "L00041";
        /** 区县编码*/
        String L00042 = MODULE_NAME	+ "L00042";
        /** 区县名称*/
        String L00043 = MODULE_NAME	+ "L00043";
        /** 买家注册来源*/
        String L00044 = MODULE_NAME	+ "L00044";
        /** 买家注册来源名称*/
        String L00045 = MODULE_NAME	+ "L00045";
        /** 市场ID*/
        String L00046 = MODULE_NAME	+ "L00046";
        /** 市场编码*/
        String L00047 = MODULE_NAME	+ "L00047";
        /** 市场名称*/
        String L00048 = MODULE_NAME	+ "L00048";
        /** 市场类型*/
        String L00049 = MODULE_NAME	+ "L00049";
        /** 市场规模*/
        String L00050 = MODULE_NAME	+ "L00050";

        /** 买家ID*/
        String L00051 = MODULE_NAME	+ "L00051";
        /** 买家池ID*/
        String L00052 = MODULE_NAME	+ "L00052";
        /** 买家池名称*/
        String L00053 = MODULE_NAME	+ "L00053";
        /** 买家池编码*/
        String L00054 = MODULE_NAME	+ "L00054";
        /** 买家池买家一级上线状态*/
        String L00055 = MODULE_NAME	+ "L00055";
        /** 买家池买家一级上线状态名称   */
        String L00056 = MODULE_NAME	+ "L00056";
        /** 买家池买家二级上线状态*/
        String L00057 = MODULE_NAME	+ "L00057";
        /** 买家池买家二级上线状态名称*/
        String L00058 = MODULE_NAME	+ "L00058";
        /** 买家池类型*/
        String L00059 = MODULE_NAME	+ "L00059";
        /** 买家所属买家池*/
        String L00060 = MODULE_NAME	+ "L00060";
        /** 买家店铺证照信息*/
        String L00061 = MODULE_NAME	+ "L00061";
        /** 买家编码*/
        String L00062 = MODULE_NAME + "L00062";
        /** 习惯支付方式*/
        String L00063 = MODULE_NAME + "L00063";
        /** 正常收获时间段*/
        String L00064 = MODULE_NAME + "L00064";
        /** 最早时间*/
        String L00065 = MODULE_NAME + "L00065";
        /** 最晚时间*/
        String L00066 = MODULE_NAME + "L00066";
        /** 电话营销标准时间段*/
        String L00067 = MODULE_NAME + "L00067";
        /** 电话营销号码*/
        String L00068 = MODULE_NAME + "L00068";
        /** 微信营销号*/
        String L00069 = MODULE_NAME + "L00069";
        /** QQ营销号*/
        String L00070 = MODULE_NAME + "L00070";
        /** 上线状态一级分类*/
        String L00071 = MODULE_NAME + "L00071";
        /** 上线状态一级分类名称*/
        String L00072 = MODULE_NAME + "L00072";
        /** 上线状态二级分类*/
        String L00073 = MODULE_NAME + "L00073";
        /** 上线状态二级分类名称*/
        String L00074 = MODULE_NAME + "L00074";
        /** 信息错误买家*/
        String L00075 = MODULE_NAME + "L00075";
        /** 信息错误备注*/
        String L00076 = MODULE_NAME + "L00076";
        /** 法人证件类型*/
        String L00077 = MODULE_NAME + "L00077";
        /** 法人证件号*/
        String L00078 = MODULE_NAME + "L00078";
        /** 法人证件照*/
        String L00079 = MODULE_NAME + "L00079";
        /** 经营地址*/
        String L00080 = MODULE_NAME + "L00080";
        /** 店铺号*/
        String L00081 = MODULE_NAME + "L00081";
        /** 店铺营业电话*/
        String L00082 = MODULE_NAME + "L00082";
        /** 店铺网址*/
        String L00083 = MODULE_NAME + "L00083";
        /** 店铺微信公众号*/
        String L00084 = MODULE_NAME + "L00084";
        /** 店铺营业执照类型*/
        String L00085 = MODULE_NAME + "L00085";
        /** 店铺营业执照号*/
        String L00086 = MODULE_NAME + "L00086";
        /** 是否默认店铺*/
        String L00087 = MODULE_NAME + "L00087";
        /** 证照类型*/
        String L00088 = MODULE_NAME + "L00088";
        /** 证照图片*/
        String L00089 = MODULE_NAME + "L00089";

        /** 买家雇员信息*/
        String L00090 = MODULE_NAME + "L00090";
        /** 雇员ID*/
        String L00091 = MODULE_NAME + "L00091";
        /** 店铺ID*/
        String L00092 = MODULE_NAME + "L00092";
        /** 雇员姓名*/
        String L00093 = MODULE_NAME + "L00093";
        /** 雇员类型*/
        String L00094 = MODULE_NAME + "L00094";
        /** 雇员手机*/
        String L00095 = MODULE_NAME + "L00095";
        /** 雇员QQ*/
        String L00096 = MODULE_NAME + "L00096";
        /** 雇员微信*/
        String L00097 = MODULE_NAME + "L00097";
        /** 有无名片照*/
        String L00098 = MODULE_NAME + "L00098";
        /** 雇员名片照*/
        String L00099 = MODULE_NAME + "L00099";
        /** 是否联络人*/
        String L00100 = MODULE_NAME + "L00100";
        /** 是否采购人*/
        String L00101 = MODULE_NAME + "L00101";
        /** 是否收货人*/
        String L00102 = MODULE_NAME + "L00102";
        /** 是否默认老板*/
        String L00103 = MODULE_NAME + "L00103";

        /** 证照图片ID*/
        String L00104 = MODULE_NAME + "L00104";

        /** 配送地址*/
        String L00105 = MODULE_NAME + "L00105";
        /** 城市ID*/
        String L00106 = MODULE_NAME + "L00106";
        /** 收货联系人*/
        String L00107 = MODULE_NAME + "L00107";
        /** 联系人电话*/
        String L00108 = MODULE_NAME + "L00108";
        /** 配送地址ID*/
        String L00109 = MODULE_NAME + "L00109";
        /** 配送参照地址*/
        String L00110 = MODULE_NAME + "L00110";
        /** 经营地址*/
        String L00111 = MODULE_NAME + "L00111";

        /** 联系人微信*/
        String L00112 = MODULE_NAME + "L00112";
        /** 联系人QQ*/
        String L00113 = MODULE_NAME + "L00113";
        /** 默认配送地址*/
        String L00114 = MODULE_NAME + "L00114";

    }
}
