package com.bms.slpd.services.impl;

import com.alibaba.fastjson.JSON;
import com.bms.slpd.bean.entity.SlpdSellerCommodity;
import com.bms.slpd.bean.param.SLPD0804IParam;
import com.bms.slpd.bean.param.field.SLPD0804ISellerCommodityParam;
import com.bms.slpd.constant.CodeMasterConstant;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0804IDao;
import com.bms.slpd.services.SLPD0804IService;
import com.bms.slpd.utils.CodeMasterUtils;
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

import java.util.*;

@Service
public class SLPD0804IServiceImpl extends BaseServiceImpl implements SLPD0804IService {
	private static final Logger logger = LoggerFactory.getLogger(SLPD0804IServiceImpl.class);

	@Autowired
	private CodeMasterUtils codeMasterUtils;
	@Autowired
	private SLPD0804IDao slpd0804IDao;

	@Override
	public BaseDao getBaseDao() {
		return this.slpd0804IDao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int auditSellerCommodities(SLPD0804IParam slpd0804iParam) {
		List<SlpdSellerCommodity> sellerCommodities = this.handleParameter(slpd0804iParam);
		return this.updateSellerCommodityAuditStus(sellerCommodities);
	}

	/**
	 * 将参数转换成卖家单品品牌(规格)生产商的实体类
	 */
	private List<SlpdSellerCommodity> handleParameter(SLPD0804IParam slpd0804iParam) {
		List<SlpdSellerCommodity> sellerCommodities = new LinkedList<>();
		SlpdSellerCommodity sellerCommodity = null;
		String auditStu = null;

		final String userId = super.getLoginUserId();
		final Date current = DateUtils.getCurrent();

		List<SLPD0804ISellerCommodityParam> sellerCommodityParams = slpd0804iParam.getSellerCommodityParams();
		for (SLPD0804ISellerCommodityParam sellerCommodityParam : sellerCommodityParams) {
			auditStu = sellerCommodityParam.getAuditStu();

			sellerCommodity = new SlpdSellerCommodity();
			sellerCommodity.setSellerCommodityId(sellerCommodityParam.getSellerCommodityId());
			sellerCommodity.setAuditStu(auditStu);
			sellerCommodity.setAuditRemark(sellerCommodityParam.getAuditRemark());
			sellerCommodity.setAuditHistory("auditHistory");
			sellerCommodity.setUpdId(userId);
			sellerCommodity.setUpdTime(current);
			sellerCommodity.setVersion(sellerCommodityParam.getVersion());
			sellerCommodities.add(sellerCommodity);
		}
		return sellerCommodities;
	}

	/**
	 * 获得卖家单品品牌(规格)生产商的审核履历，格式：0,未注册,admin,2017-01-25;...;
	 */
	private String getAuditHistory(String auditStu) {
		final String userId = super.getLoginUserId();
		final String today = DateUtils.fmtToday();

		Map<String, String> auditStuMap = this.codeMasterUtils.getCodeMaster(CodeMasterConstant.SellerCommodityAuditStu.NODE);
		String auditStuStr = auditStuMap.get(auditStu);
		auditStuStr = StringUtils.isBlank(auditStuStr) ? "" : auditStuStr;

		return new StringBuilder()
				.append(auditStu)
				.append(",")
				.append(auditStuStr)
				.append(",")
				.append(userId)
				.append(",")
				.append(today)
				.append(";")
				.toString();
	}

	/**
	 * 批量修改卖家单品品牌(规格)生产商的审核状态
	 */
	private int updateSellerCommodityAuditStus(List<SlpdSellerCommodity> sellerCommodities) {
		Set<Long> sellerCommodityIdSet = new HashSet<>();
		for (SlpdSellerCommodity sellerCommodity : sellerCommodities) {
			sellerCommodityIdSet.add(sellerCommodity.getSellerCommodityId());
		}

		int entitySize = sellerCommodities.size();
		if (sellerCommodityIdSet.size() != entitySize) {
			String builder = new StringBuilder()
					.append("审核卖家产品生产商失败，sellerCommodityId参数值")
					.append(JSON.toJSONString(sellerCommodityIdSet))
					.append("，有重复数据。")
					.toString();
			logger.info(builder);
			throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核卖家产品生产商失败，sellerCommodityId参数值有重复数据。");
		}

		int matched = NumberConst.IntDef.INT_ZERO;
		for (SlpdSellerCommodity sellerCommodity : sellerCommodities) {
			matched = super.modify(sellerCommodity);
			if (matched != NumberConst.IntDef.INT_ONE) {
				String builder = new StringBuilder()
						.append("审核卖家产品生产商失败，sellerCommodityId参数值")
						.append(sellerCommodity.getSellerCommodityId())
						.append("，version参数值")
						.append(sellerCommodity.getVersion())
						.append("。")
						.toString();
				logger.info(builder);
				throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "审核卖家产品生产商失败，请刷新页面重试。");
			}
		}
		return entitySize;
	}

}
