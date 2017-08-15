package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.SLPD0806IParam;
import com.bms.slpd.bean.param.field.SLPD0806ISellerCommodityParam;
import com.bms.slpd.bean.result.SLPD0806IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0806IDao;
import com.bms.slpd.services.SLPD0806IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class SLPD0806IServiceImpl extends BaseServiceImpl implements SLPD0806IService {
	private static final Logger logger = LoggerFactory.getLogger(SLPD0806IServiceImpl.class);

	@Autowired
	private SLPD0806IDao slpd0806IDao;
	@Override
	public BaseDao getBaseDao() {
		return this.slpd0806IDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SLPD0806IResult addArticleNosAndCommodityIds(SLPD0806IParam slpd0806iParam) {
		return this.operation(slpd0806iParam);
	}

	/**
	 * 批量添加卖家单品品牌(规格)生产商货号及商品ID
	 */
	private SLPD0806IResult operation(SLPD0806IParam slpd0806iParam) {
		List<SlpdSellerCommodity> sellerCommodities = new LinkedList<>();
		SlpdSellerCommodity sellerCommodity = null;
		final String userId = super.getLoginUserId();
		final Date current = DateUtils.getCurrent();

		List<SLPD0806ISellerCommodityParam> sellerCommodityParams = slpd0806iParam.getSellerCommodityParams();
		int matched = NumberConst.IntDef.INT_ZERO;
		int count = NumberConst.IntDef.INT_ZERO;
		List<String> commodityIds = new ArrayList<>();
		for (SLPD0806ISellerCommodityParam sellerCommodityParam : sellerCommodityParams) {
			sellerCommodity = new SlpdSellerCommodity();
			sellerCommodity.setSellerCommodityId(sellerCommodityParam.getSellerCommodityId());
			String articleNo = this.getArticleNo(sellerCommodityParam.getSellerCommodityId());
			sellerCommodity.setArticleNo(articleNo);
			SlpdSellerCommodity slpdSellerCommodity = slpd0806IDao.findSellerCommodityById(sellerCommodityParam.getSellerCommodityId());
			sellerCommodity.setSellerCommoditySku(this.getSellerCommoditySku(slpdSellerCommodity.getSellerCode(),articleNo));
			sellerCommodity.setCommodityId(this.getCommodityId(slpdSellerCommodity));
			sellerCommodity.setUpdId(userId);
			sellerCommodity.setUpdTime(current);
			sellerCommodity.setVersion(slpdSellerCommodity.getVersion());
			sellerCommodities.add(sellerCommodity);

			matched = super.modify(sellerCommodity);
			if (matched != NumberConst.IntDef.INT_ONE) {
				String builder = new StringBuilder()
						.append("添加卖家单品品牌(规格)生产商货号及商品ID失败，sellerCommodityId参数值")
						.append(sellerCommodity.getSellerCommodityId())
						.append("，version参数值")
						.append(sellerCommodity.getVersion())
						.append("。")
						.toString();
				logger.info(builder);
				throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "添加卖家单品品牌(规格)生产商货号及商品ID失败，请刷新页面重试。");
			} else {
				String commodityId = sellerCommodity.getCommodityId();
				if (!commodityIds.contains(commodityId))
					commodityIds.add(commodityId);
			}
			count += 1;
		}

		SLPD0806IResult result = new SLPD0806IResult();
		result.setCommodityIds(commodityIds);
		result.setCount(count);
		return result;
	}

	/**
	 * 获取货号
	 */
	private String getArticleNo(Long sellerCommodityId) {
		String articleNo = null;
		SlpdSellerCommodity sellerCommodity = slpd0806IDao.findSellerCommodityById(sellerCommodityId);
		SlpdSellerCommodity sellerCommodity1 = new SlpdSellerCommodity();
		sellerCommodity1.setEntitySellerId(sellerCommodity.getEntitySellerId());
		String maxArticleNo = slpd0806IDao.getMaxArticleNo(sellerCommodity1);
		if(StringUtils.isNotEmpty(maxArticleNo)){
			String maxArticleNo1 = slpd0806IDao.getMaxArticleNo(sellerCommodity);
			if(StringUtils.isEmpty(maxArticleNo1)){
				int intArticleNo = Integer.parseInt(maxArticleNo) + 100001;
				articleNo = String.valueOf(intArticleNo).substring(1);
			}else{
				articleNo = maxArticleNo1;
			}
		}else {
			articleNo = "00001";
		}

		return articleNo;
	}

	/**
	 * 获取卖家产品生产商Sku
	 */
	private String getSellerCommoditySku(String sellerCode,String articleNo) {
		String sellerCommoditySku = null;
		if (StringUtils.isEmpty(sellerCode) || StringUtils.isEmpty(articleNo)) {
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "生成卖家产品生产商Sku失败，请查看sellerCode是否为空。");
		}
		sellerCommoditySku = sellerCode + articleNo;
		return sellerCommoditySku;
	}

	/**
	 * 获取商品ID
	 */
	private String getCommodityId(SlpdSellerCommodity slpdSellerCommodity) {
		String commodityId = null;
		//查找对应productId的商品ID
		String productCommodityId = slpd0806IDao.getMaxCommodityId(slpdSellerCommodity);
		if(StringUtils.isNotEmpty(productCommodityId)){
			commodityId = productCommodityId;
		}else {
			//查找最大商品ID
			String maxCommodityId = slpd0806IDao.getMaxCommodityId(null);
			if(StringUtils.isNotEmpty(maxCommodityId)){
				int intCommodityId = Integer.parseInt(maxCommodityId.substring(1)) + 100000001;
				commodityId = "S" + String.valueOf(intCommodityId).substring(1);
			}else {
				commodityId = "S00000001";
			}
		}
		return commodityId;
	}

}
