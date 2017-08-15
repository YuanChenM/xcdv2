package com.bms.order.constant.i18n;

/**
 * 错误编码
 *
 * @author li_huiqian
 */
public class ErrorCode {

    /**
     * E000001: {0}没有执行操作的权限
     */
    public static final String E000001 = "ORDR.E000001";
    /**
     * E000002: 数据异常，{0}
     */
    public static final String E000002 = "ORDR.E000002";
    /**
     * E000003: 不能对已存在的数据进行插入操作
     */
    public static final String E000003 = "ORDR.E000003";
    /**
     * E000004: 唯一约束冲突
     */
    public static final String E000004 = "ORDR.E000004";
    /**
     * E000005: 插入数据失败
     */
    public static final String E000005 = "ORDR.E000005";
    /**
     * E000006: 修改的数据必须要先从数据库取一遍
     */
    public static final String E000006 = "ORDR.E000006";
    /**
     * E000007: 更新失败，数据不存在或已被他人修改
     */
    public static final String E000007 = "ORDR.E000007";
    /**
     * E000008: 删除的数据必须要先从数据库取一遍
     */
    public static final String E000008 = "ORDR.E000008";
    /**
     * E000009: 删除失败，数据不存在或已被他人修改
     */
    public static final String E000009 = "ORDR.E000009";
    /**
     * E000010: 插入历史数据失败
     */
    public static final String E000010 = "ORDR.E000010";
    /**
     * E000011: 未知排序字段{0}
     */
    public static final String E000011 = "ORDR.E000011";
    /**
     * E000012: 排序字段所在的层级不能比分页层级深
     */
    public static final String E000012 = "ORDR.E000012";
    /**
     * E010101: 买家不能替他人创建订单
     */
    public static final String E010101 = "ORDR.E010101";
    /**
     * E010102: 管家只能代下自己管理的买家的订单
     */
    public static final String E010102 = "ORDR.E010102";
    /**
     * E010103: 非账期买家不能使用账期
     */
    public static final String E010103 = "ORDR.E010103";
    /**
     * E010104: 下单员没有下单的权限
     */
    public static final String E010104 = "ORDR.E010104";
    /**
     * E010105: 无法查询到商品(ID={0})
     */
    public static final String E010105 = "ORDR.E010105";
    /**
     * E010107: 商品：{0}价盘不存在
     */
    public static final String E010107 = "ORDR.E010107";
    /**
     * E010106: 买家ID为{0}的买家不存在
     */
    public static final String E010106 = "ORDR.E010106";
    /**
     * E010108: 参考号重复，请查验
     */
    public static final String E010108 = "ORDR.E010108";
    /**
     * E010201: 无法修改是否开具发票、是否使用账期、定金应付金额、 预付应付金额
     */
    public static final String E010201 = "ORDR.E010201";
    /**
     * E010202: 该买家订单信息不存在
     */
    public static final String E010202 = "ORDR.E010202";
    /**
     * E010203: 配送通知单已经生成，不能修改，请先取消配送通知单，再进行修改
     */
    public static final String E010203 = "ORDR.E010203";
    /**
     * E010204: 该订单不属于您
     */
    public static final String E010204 = "ORDR.E010204";
    /**
     * E010205: 新增分批，分批明细不能为空
     */
    public static final String E010205 = "ORDR.E010205";
    /**
     * E010401: 买家订单Id不存在或已经删除 id：{0}
     */
    public static final String E010401 = "ORDR.E010401";
    /**
     * E010402: 买家订单状态不是确认中 id：{0}
     */
    public static final String E010402 = "ORDR.E010402";
    /**
     * E010403: 库存不足，买家订单确认失败 id：{0}
     */
    public static final String E010403 = "ORDR.E010403";
    /**
     * E020101: 拆分数量必须等于该分批订单明细的产品数量
     */
    public static final String E020101 = "ORDR.E020101";
    /**
     * E020102: 订单款项未结清不能分拆
     */
    public static final String E020102 = "ORDR.E020102";
    /**
     * E020103: 已经分拆完成不能再次拆分
     */
    public static final String E020103 = "ORDR.E020103";
    /**
     * E020104: 拆分数量不能小于等于0
     */
    public static final String E020104 = "ORDR.E020104";
    /**
     * E020105: 供货主体类型 不对
     */
    public static final String E020105 = "ORDR.E020105";
    /**
     * E020106: 分批订单明细的id 在系统内不存在
     */
    public static final String E020106 = "ORDR.E020106";
    /**
     * E020107: 分批订单的id 在系统内不存在
     */
    public static final String E020107 = "ORDR.E020107";
    /**
     * E020108: 分批订单状态不是【待分拆】或【分拆待确认】 不能拆分该分批订单
     */
    public static final String E020108 = "ORDR.E020108";
    /**
     * E020109: 平台id 不对
     */
    public static final String E020109 = "ORDR.E020109";
    /**
     * E030301: 买家只能查询买家为自己的订单
     */
    public static final String E030301 = "ORDR.E030301";
    /**
     * E030302: 冻品管家只能查询自己管理的订单
     */
    public static final String E030302 = "ORDR.E030302";
    /**
     * E030401: 无法查询到配送通知单
     */
    public static final String E030401 = "ORDR.E030401";
    /**
     * E030402: 只有状态为“取消中”的配送通知单才能进行取消确认
     */
    public static final String E030402 = "ORDR.E030402";
    /**
     * E030403: 无法查询到配送通知单对应的配送取消通知单
     */
    public static final String E030403 = "ORDR.E030403";
    /**
     * E040201: 操作者权限不够
     */
    public static final String E040201 = "ORDR.E040201";
    /**
     * E040202: 查询价盘通道不能为空
     */
    public static final String E040202 = "ORDR.E040202";
    /**
     * E040203: 分批订单不能为空
     */
    public static final String E040203 = "ORDR.E040203";
    /**
     * E040204: 分批订单明细不能为空
     */
    public static final String E040204 = "ORDR.E040204";
    /**
     * E040205: 配送通知单明细不能为空
     */
    public static final String E040205 = "ORDR.E040205";
    /**
     * E050101: 操作者权限不够
     */
    public static final String E050101 = "ORDR.E050101";
    /**
     * E050102: 付款金额小于应付金额
     */
    public static final String E050102 = "ORDR.E050102";
    /**
     * E050103: 配送单状态不可收货
     */
    public static final String E050103 = "ORDR.E050103";
    /**
     * E050104: 买家分批订单明细不能为空
     */
    public static final String E050104 = "ORDR.E050104";
    /**
     * E050105: 数量不能同时为空
     */
    public static final String E050105 = "ORDR.E050105";
    /**
     * E050106: 有迟收数量，迟收再配送日不能为空
     */
    public static final String E050106 = "ORDR.E050106";
    /**
     * E050107: 配送单明细不能为空
     */
    public static final String E050107 = "ORDR.E050107";
    /**
     * E050108: 分批订单明细数据不能为空
     */
    public static final String E050108 = "ORDR.E050108";
    /**
     * E050109: 价格表中产品价格不能为空
     */
    public static final String E050109 = "ORDR.E050109";
    /**
     * E050110: 这个配送单还没有发货
     */
    public static final String E050110 = "ORDR.E050110";
    /**
     * E050111: 发货单号：{0}不属于这个配送单
     */
    public static final String E050111 = "ORDR.E050111";
    /**
     * E050112: 这个配送单的配送单明细不能为空
     */
    public static final String E050112 = "ORDR.E050112";
    /**
     * E050113: 收货数量没有收全
     */
    public static final String E050113 = "ORDR.E050113";
    /**
     * E050114: 发货明细不能为空
     */
    public static final String E050114 = "ORDR.E050114";
    /**
     * E050115: 这个发货通知单没有进行收货
     */
    public static final String E050115 = "ORDR.E050115";
    /**
     * E050116: 收货数量不对
     */
    public static final String E050116 = "ORDR.E050116";
    /**
     * E050117: 没有全部发货，不能进行收货操作
     */
    public static final String E050117 = "ORDR.E050117";
    /**
     * E050118: 发货数量不对，不能进行收货操作
     */
    public static final String E050118 = "ORDR.E050118";
    /**
     * E060101: 没有权限创建买手订单
     */
    public static final String E060101 = "ORDR.E060101";
    /**
     * E060102: {0}类型的下单员没有下单权限
     */
    public static final String E060102 = "ORDR.E060102";
    /**
     * E060103: 买手只能有囤实物权限
     */
    public static final String E060103 = "ORDR.E060103";
    /**
     * E060104: 买手只能有囤货权权限
     */
    public static final String E060104 = "ORDR.E060104";
    /**
     * E060105: 优惠金额要小于订单金额
     */
    public static final String E060105 = "ORDR.E060105";
    /**
     * E060106: 商品{0}不存在
     */
    public static final String E060106 = "ORDR.E060106";
    /**
     * E060107: 买手id：{0}不存在
     */
    public static final String E060107 = "ORDR.E060107";
    /**
     * E060108: 买手区域信息不存在
     */
    public static final String E060108 = "ORDR.E060108";
    /**
     * E060109: 商品：{0}价盘不存在
     */
    public static final String E060109 = "ORDR.E060109";
    /**
     * E060501: 冻品管家只能查询自己管理的买手的买手订单
     */
    public static final String E060501 = "ORDR.E060501";
    /**
     * E060502: 买手仅能查询购买者为自己的买手订单
     */
    public static final String E060502 = "ORDR.E060502";
    /**
     * E060503: 下单时间字段，查询开始日期应小于等于结束日期
     */
    public static final String E060503 = "ORDR.E060503";
    /**
     * E060201: 买手订单不存在
     */
    public static final String E060201 = "ORDR.E060201";
    /**
     * E060202: 买手订单详情不存在
     */
    public static final String E060202 = "ORDR.E060202";
    /**
     * E060203: 买手订单状态不正确，无法修改
     */
    public static final String E060203 = "ORDR.E060203";
    /**
     * E060204: 买手订单状态不是确认中，定金应付金额或预付应付金额无法修改
     */
    public static final String E060204 = "ORDR.E060204";
    /**
     * E060205: 产品接口查询失败
     */
    public static final String E060205 = "ORDR.E060205";
    /**
     * E060206: 商品不存在
     */
    public static final String E060206 = "ORDR.E060206";
    /**
     * E060207: 买手囤货失败
     */
    public static final String E060207 = "ORDR.E060207";
    /**
     * E060208: 修改失败，若要删除所有买手订单明细，请取消订单
     */
    public static final String E060208 = "ORDR.E060208";
    /**
     * E060701: 买手订单已收金额不存在，无法囤货
     */
    public static final String E060701 = "ORDR.E060701";
    /**
     * E060702: 买手订单预付应付不存在，无法囤货
     */
    public static final String E060702 = "ORDR.E060702";
    /**
     * E060703: 买手订单定金应付不存在，无法囤货
     */
    public static final String E060703 = "ORDR.E060703";
    /**
     * E060704: 买手订单支付金额不足，无法囤货
     */
    public static final String E060704 = "ORDR.E060704";
    /**
     * E080301: returnMode 值不对！
     */
    public static final String E080301 = "ORDR.E080301";
    /**
     * E080302: 该配送通知单不存在
     */
    public static final String E080302 = "ORDR.E080302";
    /**
     * E080303: 该配送通知单状态不是配送中或是部分收货，所以不能迟收
     */
    public static final String E080303 = "ORDR.E080303";
    /**
     * E080304: 参数中的buyerId与数据库中不同
     */
    public static final String E080304 = "ORDR.E080304";
    /**
     * E080305: 参数中的buyerCode与数据库中不同！
     */
    public static final String E080305 = "ORDR.E080305";
    /**
     * E080306: 找不到对应的发货单明细信息，发货单明细id:{0}
     */
    public static final String E080306 = "ORDR.E080306";
    /**
     * E080307: 根据发货单找不到对应的diverCode在数据库中！
     */
    public static final String E080307 = "ORDR.E080307";
    /**
     * E080308: 找不到预配送明细！
     */
    public static final String E080308 = "ORDR.E080308";
    /**
     * E080309: 迟收数量大于可迟收数量！
     */
    public static final String E080309 = "ORDR.E080309";
    /**
     * E080310: sku与预配送明细中的sku不相同！
     */
    public static final String E080310 = "ORDR.E080310";
    /**
     * E080311: 退货原因不存在
     */
    public static final String E080311 = "ORDR.E080311";
    /**
     * E080312: 退货原因不匹配
     */
    public static final String E080312 = "ORDR.E080312";
    /**
     * E080313: shipList 存在重复的diverCode，shipDetailId
     */
    public static final String E080313 = "ORDR.E080313";

    /**
     * E080314: 操作者类型不对
     */
    public static final String E080314 = "ORDR.E080314";
    /**
     * E080315: 迟收之前需要付全款！
     */
    public static final String E080315 = "ORDR.E080315";

    /**
     * E080401: returnMode 值不对！
     */
    public static final String E080401 = "ORDR.E080401";
    /**
     * E080402: 该配送通知单不存在
     */
    public static final String E080402 = "ORDR.E080402";
    /**
     * E080403: 该配送通知单状态不是配送中或是部分收货，所以不能迟收！
     */
    public static final String E080403 = "ORDR.E080403";
    /**
     * E080404: 参数中的buyerId与数据库中不同！
     */
    public static final String E080404 = "ORDR.E080404";
    /**
     * E080405: 参数中的buyerCode与数据库中不同！
     */
    public static final String E080405 = "ORDR.E080405";
    /**
     * E080406: 找不到对应的发货单明细信息，发货单明细id:{0}
     */
    public static final String E080406 = "ORDR.E080406";
    /**
     * E080407: 根据发货单找不到对应的diverCode在数据库中！
     */
    public static final String E080407 = "ORDR.E080407";
    /**
     * E080408: 找不到预配送明细！
     */
    public static final String E080408 = "ORDR.E080408";
    /**
     * E080409: 拒收数量大于可拒收数量！
     */
    public static final String E080409 = "ORDR.E080409";
    /**
     * E080410: sku与预配送明细中的sku不相同
     */
    public static final String E080410 = "ORDR.E080410";
    /**
     * E080411: 退货原因不存在
     */
    public static final String E080411 = "ORDR.E080411";
    /**
     * E080412: 退货原因不匹配
     */
    public static final String E080412 = "ORDR.E080412";

    /**
     * E080413: 操作者类型不对
     */
    public static final String E080413 = "ORDR.E080413";


    /**
     * E080101: 订单ID为{0}的买家订单不存在
     */
    public static final String E080101 = "ORDR.E080101";
    /**
     * E080102: 退货原因ID为{0}的退货原因不存在
     */
    public static final String E080102 = "ORDR.E080102";
    /**
     * E080103: 退货明细退货原因ID为{0}的退货原因不存在
     */
    public static final String E080103 = "ORDR.E080103";
    /**
     * E080104: 无法查询到相应的收货明细，请确认收货明细ID
     */
    public static final String E080104 = "ORDR.E080104";
    /**
     * E080105: 收货明细ID为{0}的收货明细数据不存在
     */
    public static final String E080105 = "ORDR.E080105";
    /**
     * E080106: 买家ID为{0}与订单ID为{1}的买家订单不匹配
     */
    public static final String E080106 = "ORDR.E080106";
    /**
     * E080107: 申请人类型为买家,申请人ID为{0}与买家ID不一致
     */
    public static final String E080107 = "ORDR.E080107";
    /**
     * E080108: 申请人类型为买家,申请人名称为{0}与买家名称不一致
     */
    public static final String E080108 = "ORDR.E080108";
    /**
     * E080109: 申请人类型为管家,申请人ID为{0}与买家订单下单人ID不一致
     */
    public static final String E080109 = "ORDR.E080109";
    /**
     * E080110: 申请人类型为管家,申请人名称为{0}与买家订单下单人名称不一致
     */
    public static final String E080110 = "ORDR.E080110";
    /**
     * E080111: 收货明细ID为{0}的收货信息不存在
     */
    public static final String E080111 = "ORDR.E080111";
    /**
     * E080112: 商品ID为{0}的收货信息不存在
     */
    public static final String E080112 = "ORDR.E080112";
    /**
     * E080113: 收货明细ID为{0}的产品超出退货时间范围
     */
    public static final String E080113 = "ORDR.E080113";
    /**
     * E080114: 收货明细ID为{0}的退货数量超出可退货数量范围
     */
    public static final String E080114 = "ORDR.E080114";
    /**
     * E080115: 买家ID与申请人ID不一致
     */
    public static final String E080115 = "ORDR.E080115";
    /**
     * E080116: 申请人类型与OperatorType不一致
     */
    public static final String E080116 = "ORDR.E080116";
    /**
     * E080117: 配送单明细ID为{0}的数据不存在
     */
    public static final String E080117 = "ORDR.E080117";
    /**
     * E080118: 配送单明细ID为{0}的预配送明细数据不存在
     */
    public static final String E080118 = "ORDR.E080118";
    /**
     * E080201: 退货单ID为{0}的退货单信息不存在
     */
    public static final String E080201 = "ORDR.E080201";
    /**
     * E080202: 退货单ID为{0}的版本号与数据库不一致
     */
    public static final String E080202 = "ORDR.E080202";
    /**
     * E080203: 退货单ID为{0}的退货单状态不是待确认，无法做执行确认操作
     */
    public static final String E080203 = "ORDR.E080203";
    /**
     * E080204: 退货单ID为{0}对应的订单信息不存在
     */
    public static final String E080204 = "ORDR.E080204";
    /**
     * E080205: 退货单ID为{0}对应的分批订单信息不存在
     */
    public static final String E080205 = "ORDR.E080205";
    /**
     * E080206: 退货单ID为{0}对应的预配送明细信息不存在
     */
    public static final String E080206 = "ORDR.E080206";
    /**
     * E080207: 先为订单ID为{0}的订单创建问题订单，方可确认退货
     */
    public static final String E080207 = "ORDR.E080207";
    /**
     * E080601: 适用类型不正确
     */
    public static final String E080601 = "ORDR.E080601";
    /**
     * E080801: 退货单ID为{0}的退货单信息不存在
     */
    public static final String E080801 = "ORDR.E080801";
    /**
     * E080802: 退货单ID为{0}的版本号与数据库不一致
     */
    public static final String E080802 = "ORDR.E080802";
    /**
     * E080803: 退货单ID为{0}的退货单状态不是待确认，无法做执行确认操作
     */
    public static final String E080803 = "ORDR.E080803";
    /**
     * E080804: 退货单ID为{0}的退货的退货明细信息不存在
     */
    public static final String E080804 = "ORDR.E080804";
    /**
     * E080805: 退货单ID为{0}的收货明细信息不存在
     */
    public static final String E080805 = "ORDR.E080805";
    /**
     * E080806: 退货单ID为{0}的配送明细信息不存在
     */
    public static final String E080806 = "ORDR.E080806";
    /**
     * E080807: 退货单ID为{0}的预配送明细信息不存在
     */
    public static final String E080807 = "ORDR.E080807";
    /**
     * E090101: 买手ID与申请人ID不一致
     */
    public static final String E090101 = "ORDR.E090101";
    /**
     * E090102: 申请人类型与OperatorType不一致
     */
    public static final String E090102 = "ORDR.E090102";
    /**
     * E090103: 该囤货订单不存在
     */
    public static final String E090103 = "ORDR.E090103";
    /**
     * E090104: 申请人名称与买手信息不一致
     */
    public static final String E090104 = "ORDR.E090104";
    /**
     * E090105: 买手囤货订单状态不是囤货完成，不能进行退货操作
     */
    public static final String E090105 = "ORDR.E090105";
    /**
     * E090106: 买手退货原因ID不存在
     */
    public static final String E090106 = "ORDR.E090106";
    /**
     * E090107: 买手分拆囤货明细不存在
     */
    public static final String E090107 = "ORDR.E090107";
    /**
     * E090108: 买手退货明细退货原因ID不存在
     */
    public static final String E090108 = "ORDR.E090108";
    /**
     * E090109: 申请退货数量大于可退货数量
     */
    public static final String E090109 = "ORDR.E090109";
    /**
     * E090201: 该退货单不存在！
     */
    public static final String E090201 = "ORDR.E090201";
    /**
     * E090202: 该退货单版本号错误！
     */
    public static final String E090202 = "ORDR.E090202";
    /**
     * E090203: 退货单状态不是待确认！
     */
    public static final String E090203 = "ORDR.E090203";
    /**
     * E090204: 退货单找不到对应的买手订单
     */
    public static final String E090204 = "ORDR.E090204";
    /**
     * E090205: 退货单对应的买手订单类型不对！
     */
    public static final String E090205 = "ORDR.E090205";
    /**
     * E090206: 库存释放异常！
     */
    public static final String E090206 = "ORDR.E090206";

    /**
     * E090301: 适用类型不正确
     */
    public static final String E090301 = "ORDR.E090301";
    /**
     * E090501: 该退货单不存在！
     */
    public static final String E090501 = "ORDR.E090501";
    /**
     * E090502: 该退货单版本号错误！
     */
    public static final String E090502 = "ORDR.E090502";
    /**
     * E090503: 退货单状态不是待确认！
     */
    public static final String E090503 = "ORDR.E090503";

    /**
     * E090504: 在该退货单中找不到对应的买手囤货分拆单明细 ,买手囤货分拆单明细id:{0}
     */
    public static final String E090504 = "ORDR.E090504";

    /**
     * E060301: 买手订单ID为{0}的订单不存在
     */
    public static final String E060301 = "ORDR.E060301";
    /**
     * E060302: 买手订单ID为{0}的版本号与数据库不一致，请确认
     */
    public static final String E060302 = "ORDR.E060302";
    /**
     * E060303: 你没有操作买手订单ID为{0}的数据权限
     */
    public static final String E060303 = "ORDR.E060303";
    /**
     * E060304: 买手订单ID为{0}已取消过，无法再次取消
     */
    public static final String E060304 = "ORDR.E060304";
    /**
     * E060305: 买手订单ID为{0}的状态无法取消
     */
    public static final String E060305 = "ORDR.E060305";
    /**
     * E060306: 操作人权限错误
     */
    public static final String E060306 = "ORDR.E060306";


    /**
     * E010301: 买家订单ID为{0}的订单不存在
     */
    public static final String E010301 = "ORDR.E010301";
    /**
     * E010302: 买家订单ID为{0}的版本号与数据库不一致，请确认
     */
    public static final String E010302 = "ORDR.E010302";
    /**
     * E010303: 你没有操作买家订单ID为{0}的数据的权限
     */
    public static final String E010303 = "ORDR.E010303";
    /**
     * E010304: 买家订单ID为{0}的订单已经发生过收货或已取消，无法再次取消
     */
    public static final String E010304 = "ORDR.E010304";
    /**
     * E010305: 买家订单ID为{0}已生成配送通知单，请先取消对应的配送通知单
     */
    public static final String E010305 = "ORDR.E010305";
    /**
     * E010306: 操作人权限错误
     */
    public static final String E010306 = "ORDR.E010306";

    /**
     * E070101: 订单ID为{0}的买家订单不存在
     */
    public static final String E070101 = "ORDR.E070101";
    /**
     * E070102: 订单ID为{0}的买家订单已经发过货，无法支付
     */
    public static final String E070102 = "ORDR.E070102";
    /**
     * E070103: 订单ID为{0}的买手订单不存在
     */
    public static final String E070103 = "ORDR.E070103";
    /**
     * E070104: 订单ID为{0}的买手订单状态不是已确认，无法支付
     */
    public static final String E070104 = "ORDR.E070104";
    /**
     * E070105: 支付金额必须大于0
     */
    public static final String E070105 = "ORDR.E070105";
    /**
     * E070106: 操作人权限错误
     */
    public static final String E070106 = "ORDR.E070106";

    /**
     * E040101: 配送单号为{0},发货单号为{1}的发货通知单已经存在
     */
    public static final String E040101 = "ORDR.E040101";
    /**
     * E040102: 配送单号为{0}的配送通知单不存在
     */
    public static final String E040102 = "ORDR.E040102";
    /**
     * E040103: 配送明细ID为{0}的实际发货数量必须大于0
     */
    public static final String E040103 = "ORDR.E040103";
    /**
     * E040104: 配送单号为{0}的配送明细不存在
     */
    public static final String E040104 = "ORDR.E040104";
    /**
     * E040105: 配送明细ID为{0}不属于配送单号为{1}的配送单
     */
    public static final String E040105 = "ORDR.E040105";
    /**
     * E040106: 配送明细ID为{0}的商品ID与配送明细表中数据不一致
     */
    public static final String E040106 = "ORDR.E040106";
    /**
     * E040107: 配送明细ID为{0}的SKU与配送明细表中数据不一致
     */
    public static final String E040107 = "ORDR.E040107";
    /**
     * E040108: 配送明细ID为{0}的商品批次与配送明细表中数据不一致
     */
    public static final String E040108 = "ORDR.E040108";
    /**
     * E040109: 预配送明细ID为{0}的实际发货数量大于计划发货数量
     */
    public static final String E040109 = "ORDR.E040109";

    /**
     * E040110: 操作人权限错误
     */
    public static final String E040110 = "ORDR.E040110";
    /**
     * E040111: 该配送单已经存在发货记录，不可再次发货
     */
    public static final String E040111 = "ORDR.E040111";
    /**
     * E030201: 配送通知单ID为{0}的配送通知单不存在
     */
    public static final String E030201 = "ORDR.E030201";
    /**
     * E030202: 配送通知单ID为{0}的配送通知单已被取消，无法再次取消
     */
    public static final String E030202 = "ORDR.E030202";
    /**
     * E030203: 配送通知单ID为{0}的配送通知单正在取消中，取消失败
     */
    public static final String E030203 = "ORDR.E030203";
    /**
     * E030204: 配送通知单ID为{0}的配送通知单无法取消
     */
    public static final String E030204 = "ORDR.E030204";
    /**
     * E030205: 操作人权限错误
     */
    public static final String E030205 = "ORDR.E030205";

    /**
     * E020501: 分批订单明细ID为{0}的分批订单明细不存在
     */
    public static final String E020501 = "ORDR.E020501";
    /**
     * E020502: 操作人权限错误
     */
    public static final String E020502 = "ORDR.E020502";

    /**
     * E060401: 买手订单ID为{0}的买手订单不存在
     */
    public static final String E060401 = "ORDR.E060401";
    /**
     * E060402: 买手订单ID为{0}的买手订单订单不是确认中，无法进行确认操作
     */
    public static final String E060402 = "ORDR.E060402";
    /**
     * E060403: 操作人权限错误
     */
    public static final String E060403 = "ORDR.E060403";
    /**
     * E060404: 该商品{0}不存在有效的货主信息
     */
    public static final String E060404 = "ORDR.E060404";
    /**
     * E060405: 根据卖家编码{0}查询不到有效卖家信息
     */
    public static final String E060405 = "ORDR.E060405";
    /**
     * E030101: 买家订单ID为{0}的买家订单不存在
     */
    public static final String E030101 = "ORDR.E030101";
    /**
     * E030102: 买家订单ID为{0}的状态不是未完成状态，无法生成配送通知单
     */
    public static final String E030102 = "ORDR.E030102";
    /**
     * E030103: 预配送明细ID为{0}的明细信息不存在
     */
    public static final String E030103 = "ORDR.E030103";
    /**
     * E030104: 预配送明细ID为{0}已生成配送通知单，无法再次生成
     */
    public static final String E030104 = "ORDR.E030104";
    /**
     * E030105: 买家订单ID为{0}的订单尾款未付清，无法生成配送通知单
     */
    public static final String E030105 = "ORDR.E030105";
    /**
     * E030106: 买家订单ID为{0}的订单后续批次尾款未付清，无法生成配送通知单
     */
    public static final String E030106 = "ORDR.E030106";
    /**
     * E030107: 操作人权限错误
     */
    public static final String E030107 = "ORDR.E030107";

    /**
     * E010501: 买家只能查询买家为自己的订单
     */
    public static final String E010501 = "ORDR.E010501";
    /**
     * E010502: 冻品管家只能查询自己管理的订单
     */
    public static final String E010502 = "ORDR.E010502";
    /**
     * E010503: 暂未开放查询买手销售订单功能
     */
    public static final String E010503 = "ORDR.E010503";
    /**
     * E010504: {0}没有权限执行操作
     */
    public static final String E010504 = "ORDR.E010504";
    /**
     * E010505: 订购日期字段，查询开始日期应小于等于结束日期
     */
    public static final String E010505 = "ORDR.E010505";
    /**
     * E010506: 期望配送日字段，查询开始日期应小于等于结束日期
     */
    public static final String E010506 = "ORDR.E010506";
    /**
     * E020201: {0}没有取消订单分拆结果的权限
     */
    public static final String E020201 = "ORDR.E020201";
    /**
     * E020202: 分批订单明细不存在
     */
    public static final String E020202 = "ORDR.E020202";
    /**
     * E020203: 分批订单明细没有分拆
     */
    public static final String E020203 = "ORDR.E020203";
    /**
     * E020204: 分批订单明细没有生成预配送明细
     */
    public static final String E020204 = "ORDR.E020204";
    /**
     * E020205: 配送通知单正在取消中，请等待美迪福取消结果回传
     */
    public static final String E020205 = "ORDR.E020205";
    /**
     * E020206: 配送通知单已生成，请先取消配送通知单，再继续操作
     */
    public static final String E020206 = "ORDR.E020206";
    /**
     * E020207: 该商品已发货，不能进行取消操作
     */
    public static final String E020207 = "ORDR.E020207";
    /**
     * E020208: 配送通知单缺失
     */
    public static final String E020208 = "ORDR.E020208";


    /**
     * E020301: {0}没有取消订单分拆结果的权限
     */
    public static final String E020301 = "ORDR.E020301";
    /**
     * E020302: 分批订单不存在
     */
    public static final String E020302 = "ORDR.E020302";
    /**
     * E020303: 该分批订单已经被确认
     */
    public static final String E020303 = "ORDR.E020303";
    /**
     * E020304: 无法确认状态为{0}的分批订单分拆结果
     */
    public static final String E020304 = "ORDR.E020304";
    /**
     * E020305: 该分批订单没有明细
     */
    public static final String E020305 = "ORDR.E020305";
    /**
     * E020306: 请先将订单分拆完毕再确认
     */
    public static final String E020306 = "ORDR.E020306";
    /**
     * E020307: 买家分批订单明细必须生成预配送明细后才能确认
     */
    public static final String E020307 = "ORDR.E020307";
    /**
     * E020308: 订单明细未完全分拆
     */
    public static final String E020308 = "ORDR.E020308";
    /**
     * E080501: 退货订单Id不存在或已经删除 id：{0}
     */
    public static final String E080501 = "ORDR.E080501";
    /**
     * E080502: 退货订单状态不是待入库
     */
    public static final String E080502 = "ORDR.E080502";
    /**
     * E080503: 退货订单Sku和配送明细Sku不匹配 sku：{0}
     */
    public static final String E080503 = "ORDR.E080503";
    /**
     * E080504: 溯源接口未查询到源信息
     */
    public static final String E080504 = "ORDR.E080504";
    /**
     * E030501: 无法对状态为待分配仓库、待传递WMS以外的配送通知单修改预配送仓库信息
     */
    public static final String E030501 = "ORDR.E030501";
}
