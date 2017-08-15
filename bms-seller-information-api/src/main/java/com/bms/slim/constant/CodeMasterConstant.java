package com.bms.slim.constant;

/**
 * CodeMater常量类
 */
public interface CodeMasterConstant {

	/**
	 * 卖家审核状态
	 */
	interface SellerAuditStu {
		/** 常量节点 */
		String NODE = "SLIM_SellerAuditStu";

		/** 待审核 */
		String PENDING = "0";

		/** 正式 */
		String APPROVED = "1";
	}

    /**
     * 销售类型
     */
    interface SaleType {
	    /** 常量节点 */
	    String NODE = "SLIM_SaleType";

        /** 集中定价 */
        String CENTRALIZED_PRICING = "1";

        /** 独立定价 */
        String INDEPENDENT_PRICING = "2";
    }

    /**
     * 工作单位类型
     */
    interface WorkunitType {
	    /** 常量节点 */
	    String NODE = "SLIM_WorkunitType";

        /** 卖家 */
        String SELLER_UNIT = "1";

        /** 生产商 */
        String PRODUCER_UNIT = "2";

		/** 卖家合同 */
		String CONTRACT_UNIT = "3";
    }

	/**
	 * 生产商审核状态
	 */
	interface ProducerAuditStu {
		/** 常量节点 */
		String NODE = "SLIM_ProducerAuditStu";

		/** 待审核 */
		String PENDING = "0";

		/** 正式 */
		String APPROVED = "1";
	}

	/**
	 * 品牌版权类型
	 */
	interface BrandCopyrightType {
		/** 常量节点 */
		String NODE = "SLIM_BrandCopyrightType";

		/** 自有品牌 */
		String OWN = "1";

		/** 代理品牌 */
		String AGENT = "2";
	}

	/**
	 * 文化程度
	 */
	interface EducationDegreeType {
		/** 常量节点 */
		String NODE = "SLIM_EducationDegreeType";

		/** 博士 */
		String DOCTOR = "1";

		/** 硕士 */
		String MASTER = "2";

		/** 本科 */
		String UNDERGRADUATE = "3";

		/** 大专 */
		String JUNIOR_COLLEGE = "4";

		/** 中专和中技 */
		String SECONDARY_SPECIALIZED_SCHOOL = "5";

		/** 技工学校 */
		String TECHNICAL_SCHOOL = "6";

		/** 高中 */
		String HIGH_SCHOOL = "7";

		/** 初中 */
		String MIDDLE_SCHOOL = "8";

		/** 小学 */
		String PRIMARY_SCHOOL = "9";
	}

	/**
	 * 公司职务
	 */
	interface CompanyPositionType {
		/** 常量节点 */
		String NODE = "SLIM_CompanyPositionType";

		/** 公司董事长 */
		String CHAIRMAN = "1";

		/** 公司总经理 */
		String GENERAL_MANAGER = "2";

		/** 公司销售副总经理 */
		String VICE_GENERAL_SALES_MANAGER = "3";

		/** 销售部经理 */
		String SALES_MANAGER = "4";

		/** 生产部经理 */
		String PRODUCTION_MANAGER = "5";

		/** 品控部经理 */
		String QC_MANAGER = "6";

		/** 财务部经理 */
		String FINANCE_MANAGER = "7";
	}

	/**
	 * 联系人类型
	 */
	interface ContactType {
		/**
		 * 常量节点
		 */
		String NODE = "SLIM_ContactType";
		/**
		 * 签约联系人
		 */
		String SIGN_CONTACT = "1";
		/**
		 * 订单联系人
		 */
		String ORDER_CONTACT = "2";
		/**
		 * 收款联系人
		 */
		String COLLECTION_CONTACT = "3";
		/**
		 * 营销负责人
		 */
		String MARKETING_MANAGER = "4";
		/**
		 * 合同负责人
		 */
		String CONTRACT_MANAGER	 = "5";
		/**
		 * 生产负责人
		 */
		String PRODUCE_MANAGER = "6";
		/**
		 * 品控负责人
		 */
		String QUALITY_MANAGER = "7";
		/**
		 * 包材负责人
		 */
		String PACKAGE_MANAGER = "8";
		/**
		 * 运输负责人
		 */
		String TRANSPORT_MANAGER = "9";
		/**
		 * 合同快递收件人
		 */
		String CONTRACT_EXPRESS_RECIPIENT = "10";
	}

}
