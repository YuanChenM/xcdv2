package com.bms.slpd.constant;

/**
 * CodeMater常量类
 */
public interface CodeMasterConstant {

	/**
	 * 品牌审核状态
	 */
	interface BrandAuditStu {
		/** 常量节点 */
		String NODE = "SLPD_BrandAuditStu";

		/** 待审核 */
		String PENDING = "0";

		/** 正式 */
		String APPROVED = "1";
	}

	/**
	 * 品牌类型
	 */
	interface BrandType {
		/** 常量节点 */
		String NODE = "SLPD_BrandType";

		/** 一线品牌 */
		String FIRST_LINE = "1";

		/** 二线品牌 */
		String SECOND_LINE = "2";

		/** 一二线外品牌 */
		String THIRD_LINE = "3";
	}

	/**
	 * 品牌所有人类型
	 */
	interface BrandOwnerType {
		/** 常量节点 */
		String NODE = "SLPD_BrandOwnerType";

		/** 生产商 */
		String PRODUCER = "1";

		/** 制造商 */
		String MANUFACTURER = "2";
	}

	/**
	 * 产品审核状态
	 */
	interface ProductAuditStu {
		/** 常量节点 */
		String NODE = "SLPD_ProductAuditStu";

		/** 未注册 */
		String UNREGISTERED = "0";

		/** 审核中 */
		String AUDITING = "1";

		/** 试销 */
		String TRIAL_SALE = "2";

		/** 正式 */
		String APPROVED = "3";

		/** 禁止准入 */
		String REJECTED = "4";

		/** 黑名单 */
		String BLACKLIST = "5";
	}

	/**
	 * 产品质量等级
	 */
	interface QualityGradeType {
		/** 常量节点 */
		String NODE = "SLPD_QualityGradeType";

		/** A1 */
		String A1 = "1";

		/** A2 */
		String A2 = "2";

		/** A3 */
		String A3 = "3";
	}

	/**
	 * 产品货源
	 */
	interface ProductSourceType {
		/** 常量节点 */
		String NODE = "SLPD_ProductSourceType";

		/** 国产 */
		String DOMESTIC = "1";

		/** 进口 */
		String IMPORT = "2";
	}

	/**
	 * 单品品牌生产商审核状态
	 */
	interface ProducerProductAuditStu {
		/** 常量节点 */
		String NODE = "SLPD_ProducerProductAuditStu";

		/** 未注册 */
		String UNREGISTERED = "0";

		/** 审核中 */
		String AUDITING = "1";

		/** 准入 */
		String APPROVED = "2";

		/** 禁止准入 */
		String REJECTED = "3";

		/** 黑名单 */
		String BLACKLIST = "4";
	}

	/**
	 * 单品品牌生产商审核状态
	 */
	interface SellerCommodityAuditStu {
		/** 常量节点 */
		String NODE = "SLPD_SellerCommodityAuditStu";

		/** 未注册 */
		String UNREGISTERED = "0";

		/** 审核中 */
		String AUDITING = "1";

		/** 准入 */
		String APPROVED = "2";

		/** 禁止准入 */
		String REJECTED = "3";

		/** 黑名单 */
		String BLACKLIST = "4";
	}

	/**
	 * 销售类型
	 */
	interface SaleType {
		/** 常量节点 */
		String NODE = "SLPD_SaleType";

		/** 集中定价 */
		String CENTRALIZED_PRICING = "1";

		/** 独立定价 */
		String INDEPENDENT_PRICING = "2";
	}

	/**
	 * 论证类型
	 */
	interface DiscussType {
		/** 常量节点 */
		String NODE = "SLPD_DiscussType";

		/** 市场 */
		String MARKET = "0";

		/** 生产商 */
		String PRODUCER = "1";
	}

	/**
	 * 档案卡类型
	 */
	interface StandardType {
		/** 常量节点 */
		String NODE = "SLPD_StandardType";

		/** 加工技术标准 */
		String MCT = "0";

		/** 加工质量标准 */
		String TNC = "1";
	}

	/**
	 * 原种种源标准指标类型
	 */
	interface OrgStdType {
		/** 常量节点 */
		String NODE = "SLPD_OrgStdType";

		/** 皮肤、肉质、脂肪标准指标 */
		String SKIN_MEAT_FAT = "1";

		/** 肌肉颜色标准指标 */
		String MUSCLE_COLOR = "2";

		/** 肌肉系水率标准指标 */
		String MUSCLE_WATER_HOLD_RATE = "3";

		/** 肌肉失水率标准指标 */
		String MUSCLE_WATER_LOSS_RATE = "4";

		/** 肌肉嫩度标准指标 */
		String MEAT_TENDERNESS = "5";

		/** 熟肉率指标 */
		String COOKED_MEAT_RATE = "6";

		/** 适合烹调方式 */
		String SUITABLE_COOKING_MODE = "7";
	}

	/**
	 * 饲养标准指标类型
	 */
	interface FedStdType {
		/** 常量节点 */
		String NODE = "SLPD_FedStdType";

		/** 幼苗季节性标准指标 */
		String SEASONAL_SEEDLING = "1";

		/** 饲养方式标准指标 */
		String FEEDING_MODE = "2";

		/** 饲养地点、温湿度标准指标 */
		String FEEDING_LOCATION_TEMPERATURE_HUMIDITY = "3";

		/** 饲料种类、喂药情况标准指标 */
		String FEED_TYPE_MEDICINE = "4";

		/** 生长周期标准指标 */
		String GROWTH_CYCLE = "5";
	}

	/**
	 * 加工技术标准指标类型
	 */
	interface MctStdType {
		/** 常量节点 */
		String NODE = "SLPD_MctStdType";

		/** 冷冻工艺指标 */
		String FREEZING_TECHNOLOGY = "1";

		/** 工艺流程关键点指标 */
		String TECHNOLOGICAL_PROCESS_POINT = "2";

		/** 配方指标 */
		String FORMULA = "3";
	}

	/**
	 * 加工质量标准指标类型
	 */
	interface TncStdType {
		/** 常量节点 */
		String NODE = "SLPD_TncStdType";

		/** 产品解冻失水率指标(包冰率指标) */
		String THAWING_LOSS_RATE = "1";

		/** 产品均匀度指标 */
		String UNIFORMITY = "2";

		/** 产品感官指标 */
		String SENSE = "3";

		/** 加工净度指标 */
		String PROCESSING_CLEANLINESS = "4";
	}

	/**
	 * 通用质量标准指标类型
	 */
	interface GnqStdType {
		/** 常量节点 */
		String NODE = "SLPD_GnqStdType";

		/** 理化指标 */
		String PHYSICAL_CHEMICAL = "A";

		/** 水分含量指标 */
		String WATER_CONTENT = "A1";

		/** 其它理化指标 */
		String OTHER_PHYSICAL_CHEMICAL = "A2";

		/** 新鲜度指标 */
		String FRESHNESS = "B";

		/** 挥发性盐基氮 */
		String T_VBN = "B1";

		/** PH值 */
		String PH = "B2";

		/** 解冻后感官指标 */
		String POST_THAW_SENSE = "C";

		/** 解冻后感官指标 */
		String POST_THAW_SENSE_C1 = "C1";

		/** 煮后滋气味指标 */
		String SMELL_AFTER_COOKING = "D";

		/** 煮后滋气味指标 */
		String SMELL_AFTER_COOKING_D1 = "D1";

		/** 异物指标 */
		String FOREIGN_MATTER = "E";

		/** 异物指标 */
		String FOREIGN_MATTER_E1 = "E1";
	}

	/**
	 * 安全标准指标类型
	 */
	interface SftStdType {
		/** 常量节点 */
		String NODE = "SLPD_SftStdType";

		/** 一类安全标准指标 */
		String A_CLASS_SECURITY = "A";

		/** 微生物指标 */
		String MICROORGANISM = "A1";

		/** 二类安全标准指标 */
		String B_CLASS_SECURITY = "B";

		/** 农药残留指标 */
		String PESTICIDE_RESIDUE = "B1";

		/** 兽药残留指标 */
		String VETERINARY_DRUG_RESIDUE = "B2";

		/** 三类安全标准指标 */
		String C_CLASS_SECURITY = "C";

		/** 重金属指标 */
		String HEAVY_METAL = "C1";
	}

	/**
	 * 安全标准指标类型
	 */
	interface TspStdType {
		/** 常量节点 */
		String NODE = "SLPD_TspStdType";

		/** 储存指标 */
		String STORAGE = "A";

		/** 冷库温度指标 */
		String COLD_STORAGE_TEMPERATURE = "A1";

		/** 冷库湿度指标 */
		String COLD_STORAGE_HUMIDITY = "A2";

		/** 制冷方式指标 */
		String REFRIGERATION_MODE = "A3";

		/** 储存状况指标 */
		String STORAGE_CONDITION = "A4";

		/** 运输指标 */
		String TRANSPORT = "B";

		/** 运输前处置指标 */
		String PRE_TRANSPORTATION_DISPOSAL = "B1";

		/** 运输工具指标 */
		String CONVEYANCE = "B2";

		/** 运输过程管控指标 */
		String TRANSPORTATION_PROCESS_CONTROL = "B3";
	}

	/**
	 * 物流区商品上下架状态
	 */
	interface ShelfStu {
		/** 常量节点 */
		String NODE = "SLPD_ShelfStu";

		/** 上架 */
		String ON_SHELF = "1";

		/** 下架 */
		String OFF_SHELF = "2";
	}

	/**
	 * 卖家角色类型
	 */
	interface SellerRoleType {
		/**
		 * 常量节点
		 */
		String NODE = "SLIM_SellerRoleType";

		/**
		 * 生产商
		 */
		String PRODUCER = "1";

		/**
		 * 制造商
		 */
		String MANUFACTURER = "2";

		/**
		 * 代理商
		 */
		String AGENT = "3";

		/**
		 * 卖家
		 */
		String SELLER = "4";

	}

	/**
	 * 产品需求等级
	 */
	interface ProductDemandGrade {
		/** 常量节点 */
		String NODE = "SLPD_ProductDemandGrade";

		/** 主力单品 */
		String MAINPRODUCT = "1";

		/** 畅销单品 */
		String SELLINGPRODUCT = "2";

		/** 标准单品 */
		String STANDARDPRODUCT = "3";

		/** 量少单品 */
		String LESSPRODUCT = "4";
	}

	/**
	 * 审核状态
	 */
	interface AuditStu {
		/** 常量节点 */
		String NODE = "SLPD_AuditStu";

		/** 未审核 */
		String UNAUDITING = "0";

		/** 准入 */
		String APPROVED = "1";

		/** 禁止准入 */
		String REJECTED = "2";
	}


}
