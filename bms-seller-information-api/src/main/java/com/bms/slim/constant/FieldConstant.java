package com.bms.slim.constant;

/**
 * <p>数据库表字段常量类。</p>
 */
public interface FieldConstant {

    /**
     * <p>表公共字段名。</p>
     */
    interface Common {
        String DEL_FLG = "delFlg";
        String CRT_ID = "crtId";
        String CRT_TIME = "crtTime";
        String UPD_ID = "updId";
        String UPD_TIME = "updTime";
        String VERSION = "version";
    }

    /**
     * <p>SLIM_ENTITY_SELLER表字段名。</p>
     */
    interface SlimEntitySeller {
        String ENTITY_SELLER_ID = "entitySellerId";
        String FULL_NAME = "fullName";
        String SHORT_NAME = "shortName";
        String ACCOUNT = "account";
        String PASSWORD = "password";
        String COUNTRY_CODE = "countryCode";
        String COUNTRY_NAME = "countryName";
        String PROVINCE_CODE = "provinceCode";
        String PROVINCE_NAME = "provinceName";
        String CITY_CODE = "cityCode";
        String CITY_NAME = "cityName";
        String TEL = "tel";
        String FAX = "fax";
        String MEDIA_PLATFORM = "mediaPlatform";
        String ADDRESS = "address";
//        String BRAND_REQUIRED_FLG = "brandRequiredFlg";
//        String BRAND_REG_FLG = "brandRedFlg";
//        String PRODUCER_REQUIRED_FLG = "PRODUCER_REQUIRED_FLG";
//        String PRODUCER_REG_FLG = "PRODUCER_REG_FLG";
//        String BIZ_QUAL_REQUIRED_FLG = "BIZ_QUAL_REQUIRED_FLG";
//        String BIZ_QUAL_REG_FLG = "BIZ_QUAL_REG_FLG";
//        String SUP_QUAL_REQUIRED_FLG = "SUP_QUAL_REQUIRED_FLG";
//        String SUP_QUAL_REG_FLG = "SUP_QUAL_REG_FLG";
//        String BIZ_TEAM_REQUIRED_FLG = "BIZ_TEAM_REQUIRED_FLG";
//        String BIZ_TEAM_REG_FLG = "BIZ_TEAM_REG_FLG";
//        String MGT_TEAM_REQUIRED_FLG = "MGT_TEAM_REQUIRED_FLG";
//        String MGT_TEAM_REG_FLG = "MGT_TEAM_REG_FLG";
//        String CONTRACT_REQUIRED_FLG = "CONTRACT_REQUIRED_FLG";
//        String CONTRACT_REG_FLG = "CONTRACT_REG_FLG";
        String AUDIT_STU = "auditStu";
        String AUDIT_REMARK = "auditRemark";
        String AUDIT_HISTORY = "auditHistory";
    }

    /**
     * <p>SLIM_SELLER表字段名。</p>
     */
    interface SlimSeller {
        String SELLER_ID = "sellerId";
        String SELLER_CODE = "sellerCode";
        String SALE_TYPE = "saleType";
        String ENTITY_SELLER_ID = "entitySellerId";
        String DEL_FLG = "delFlg";
    }

    /**
     * <p>SLIM_CONTACT表字段名。</p>
     */
    interface SlimContact {
        String CONTACT_ID = "contactId";
        String CONTACT_TYPE = "contactType";
        String CONTACT_NAME = "contactName";
        String WORKUNIT_ID = "workunitId";
        String WORKUNIT_TYPE = "workunitType";
        String MOBILE = "mobile";
        String WECHAT = "wechat";
        String QQ = "qq";
        String EMAIL = "email";
    }

    /**
     * <p>SLIM_SELLER_BRAND表字段名。</p>
     */
    interface SlimSellerBrand {
        String SELLER_BRAND_ID = "sellerBrandId";
        String ENTITY_SELLER_ID = "entitySellerId";
        String BRAND_ID = "brandId";
        String COPYRIGHT_TYPE = "copyrightType";
        String AGCY_DIST_AUZ_CONT_NO = "agcyDistAuzContNo";
        String AGCY_DIST_AUZ_CONT_URL = "agcyDistAuzContUrl";
        String START_AUZ_DATE = "startAuzDate";
        String END_AUZ_DATE = "endAuzDate";
    }

    /**
     * <p>SLIM_SELLER_PRODUCER表字段名。</p>
     */
    interface SlimSellerProducer {
        String SELLER_PRODUCER_ID = "sellerProducerId";
        String ENTITY_SELLER_ID = "entitySellerId";
        String PRODUCER_ID = "producerId";
    }

    /**
     * <p>SLIM_SELLER_BUSINESS_QUALIFICATION表字段名</p>
     */
    interface SlimSellerBusinessQualification {
        String ENTITY_SELLER_ID = "entitySellerId";
        String THREE_IN_ONE_FLG = "threeInOneFlg";
        String THREE_IN_ONE_NO = "threeInOneNo";
        String THREE_IN_ONE_URL = "threeInOneUrl";
        String ORGANIZATION_CODE = "organizationCode";
        String ORG_CODE_CERT_URL = "orgCodeCertUrl";
        String TAX_REG_CERT_NO = "taxRegCertNo";
        String TAX_REG_CERT_URL = "taxRegCertUrl";
        String VAT_TAXPAYER_QUAL_URL = "vatTaxpayerQualUrl";
        String BUSINESS_LICENSE_NO = "businessLicenseNo";
        String BUSINESS_LICENSE_URL = "businessLicenseUrl";
        String COMPANY_NAME = "companyName";
        String COMPANY_NATURE = "companyNature";
        String COMPANY_ADDRESS = "companyAddress";
        String LEGAL_PERSON = "legalPerson";
        String REGISTERED_CAPITAL = "registeredCapital";
        String PAID_IN_CAPITAL = "paidInCapital";
        String FOUNDING_DATE = "foundingDate";
        String OPERATION_PERIOD = "operationPeriod";
        String BUSINESS_SCOPE = "businessScope";
        String DEPOSIT_BANK = "depositBank";
        String BANK_ACCOUNT = "bankAccount";
        String BANK_LEGAL_PERSON = "bankLegalPerson";
        String ACC_PERMIT_CERT_URL = "accPermitCertUrl";
    }
    /**
     * <p>SLIM_SELLER_CONTRACT_PERMISSION 表字段</p>
     */
    interface SlimSellerContractPermission {
        String SCP_ID = "scpId";
        String ENTITY_SELLER_ID = "entitySellerId";
        String SELLER_FULL_NAME = "sellerFullName";
        String COUNTRY_CODE = "countryCode";
        String COUNTRY_NAME = "countryName";
        String PROVINCE_CODE = "provinceCode";
        String PROVINCE_NAME = "provinceName";
        String CITY_CODE = "cityCode";
        String CITY_NAME = "cityName";
        String BUSINESS_ADDRESS = "businessAddress";
        String PAYEE_NAME = "payeeName";
        String PAYEE_BANK = "payeeBank";
        String BANK_ACCOUNT = "bankAccount";
        String EXPRESS_ADDRESS = "expressAddress";
    }
	/**
	 * <p>SLIM_SELLER_BUSINESS_TEAM表字段名。</p>
	 */
	interface SlimSellerBusinessTeam {
		String ENTITY_SELLER_ID = "entitySellerId";
		String POSITION_TYPE = "positionType";
		String NAME = "name";
		String AGE = "age";
		String EDUCATIONAL_LEVEL = "educationalLevel";
		String CONTACT_WAY = "contactWay";
		String AVATAR_URL = "avatarUrl";
	}

	/**
	 * <p>SLIM_SELLER_MANAGEMENT_TEAM表字段名。</p>
	 */
	interface SlimSellerManagementTeam {
		String ENTITY_SELLER_ID = "entitySellerId";
		String POSITION_TYPE = "positionType";
		String NAME = "name";
		String AGE = "age";
		String EDUCATIONAL_LEVEL = "educationalLevel";
		String CONTACT_WAY = "contactWay";
		String AVATAR_URL = "avatarUrl";
	}

	/**
	 * <p>SLIM_PRODUCER_STORAGE_CAPACITY表字段名。</p>
	 */
	interface SlimProducerStorageCapacity {
		String SELLER_ROLE_ID = "sellerRoleId";
		String MATERIAL_CAPACITY = "materialCapacity";
		String PRODUCT_CAPACITY = "productCapacity";
		String WAREHOUSE_PIC_URL = "warehousePicUrl";
	}

	/**
	 * <p>SLIM_PRODUCER_WORKSHOP表字段名。</p>
	 */
	interface SlimProducerWorkshop {
		String SELLER_ROLE_ID = "sellerRoleId";
		String WORKSHOP_NAME = "workshopName";
		String PRODUCTION_PRODUCT = "productionProduct";
		String PROCCESS_FLOW_CHARACTER = "proccessFlowCharacter";
		String WORKSHOP_PIC_URL = "workshopPicUrl";
	}

    /**
     * <p>SLIM_PRODUCER_LABORATORY表字段名。</p>
     */
    interface SlimProducerLaboratory {
        String SELLER_ROLE_ID = "sellerRoleId";
        String ACREAGE = "acreage";
        String FUNCTION = "effect";
        String INVERSTNENT = "inverstnent";
        String MEMBER = "member";
        String LAB_PIC_URL = "labPicUrl";
        String ORG_FRAME_IMG_URL = "orgFrameImgUrl";
        String QUALITY_CTRL_IMG_URL = "qualityCtrlImgUrl";
    }

    /**
     * <p>SLIM_PRODUCER_TEST_EQUIPMENT表字段名。</p>
     */
    interface SlimProducerTestEquipment {
        String SELLER_ROLE_ID = "sellerRoleId";
        String TEST_EQP_NAME = "testEqpName";
        String TEST_EQP_USE = "testEqpUse";
        String TEST_EQP_PIC_URL = "testEqpPicUrl";
    }

    /**
     * <p>SLIM_PRODUCER_HONOR_CERTIFICATE表字段名。</p>
     */
    interface SlimProducerHonorCertificate {
        String SELLER_ROLE_ID = "sellerRoleId";
        String ISSUE_AUTHORITY = "issueAuthority";
        String ISSUE_DATE = "issueDate";
        String HONOR_CERT_URL = "honorCertUrl";
    }

    /**
     * <p>SLIM_PRODUCER_FACTORY表字段名。</p>
     */
    interface SlimProducerFactory {
        String SELLER_ROLE_ID = "sellerRoleId";
        String TOTAL_ASSET = "totalAsset";
        String REGISTERED_CAPITAL = "registeredCapital";
        String COVERED_AREA = "coveredArea";
        String WORKSHOP_AREA = "workshopArea";
        String MAJOR_EQUIPMENT = "majorEquipment";
        String DESIGN_CAPACITY = "designCapacity";
        String EXPORT_SALE_PERCENT = "exportSalePercent";
        String SELF_SALE_PERCENT = "selfSalePercent";
        String AGENT_SALE_PERCENT = "agentSalePercent";
        String FACTORY_PIC_URL = "factoryPicUrl";
    }

    /**
     * <p>SLIM_ANIMAL_EPIDEMIC_PREVENTION_CONDITION_CERTIFICATE表字段名。</p>
     */
    interface SlimAnimalEpidemicPreventionConditionCertificate {
        String SELLER_ROLE_ID = "sellerRoleId";
        String CERT_NO = "certNo";
        String VALID_PERIOD = "validPeriod";
        String ANI_EPI_PREV_CONT_CERT_URL = "aniEpiPrevContCertUrl";
    }

    /**
     * <p>SLIM_DESIGNAT_SLAUGHTER_PERMIT表字段名。</p>
     */
    interface SlimDesignatSlaughterPermit {
        String SELLER_ROLE_ID = "sellerRoleId";
        String APPROVAL_NO = "approvalNo";
        String DSGT_SLGT_PRMT_CODE = "dsgtSlgtPrmtCode";
        String DSGT_SLGT_PRMT_URL = "dsgtSlgtPrmtUrl";
    }

    /**
     * <p>SLIM_HALAL_FOOD_PRODUCTION_OPERATION_LICENSE表字段名。</p>
     */
    interface SlimHalalFoodProductionOperationLicense {
        String SELLER_ROLE_ID = "sellerRoleId";
        String CERT_NO = "certNo";
        String COMM_INSP_CERT_NO = "commInspCertNo";
        String ISSUE_DATE_BEGIN = "issueDateBegin";
        String ISSUE_DATE_END = "issueDateEnd";
        String ISSUE_AUTHORITY = "issueAuthority";
        String HALAL_FOOD_PROD_OPT_LIC_URL = "halalFoodProdOptLicUrl";
    }

    /**
     * <p>SLIM_SH_BJ_TJ_REGISTRATION表字段名。</p>
     */
    interface SlimShBjTjRegistration {
        String SELLER_ROLE_ID = "sellerRoleId";
        String WORKUNIT_NAME = "workunitName";
        String PRODUCT_CATEGORY_NAME = "productCategoryName";
        String REG_DATE = "regDate";
        String SBT_REG_URL = "sbtRegUrl";
    }

    /**
     * <p>SLIM_FOOD_PRODUCTION_LICENSE表字段名。</p>
     */
    interface SlimFoodProductionLicense {
        String SELLER_ROLE_ID = "sellerRoleId";
        String CERT_NO = "certNo";
        String CATEGORY_RANGE = "categoryRange";
        String VALID_PERIOD = "validPeriod";
        String FOOD_PROD_LIC_URL = "foodProdLicUrl";
    }

    /**
     * <p>SLIM_ISO_MANAGEMENT_SYSTEM_CERTIFICATION表字段名。</p>
     */
    interface SlimIsoManagementSystemCertification {
        String SELLER_ROLE_ID = "sellerRoleId";
        String CERT_TYPE = "certType";
        String ISO_TYPE = "isoType";
        String CERT_NO = "certNo";
        String CERTIFICATION_STANDARD = "certificationStandard";
        String CERTIFICATION_SCOPE = "certificationScope";
        String ISSUE_DATE_VALID_PERIOD = "issueDateValidPeriod";
        String CERTIFICATION_AUTHORITY = "certificationAuthority";
        String CERT_URL = "certUrl";
    }

    /**
     * <p>SLIM_AGENT_SUPPLY_QUALIFICATION表字段名。</p>
     */
    interface SlimAgentSupplyQualification {
        String ENTITY_SELLER_ID = "entitySellerId";
        String AGENT_NAME = "agentName";
        String AGENT_AREA = "agentArea";
        String AGENT_PRODUCT_RANGE = "agentProductRange";
        String ASA_VALID_PERIOD = "asaValidPeriod";
        String ASA_URL = "asaUrl";
        String AUTHORIZER_NAME = "authorizerName";
        String AUTHORIZEE_NAME = "authorizeeName";
        String AUTHORIZED_PRODUCT_RANGE = "authorizedProductRange";
        String AUTHORIZED_BUSINESS_AREA = "authorizedBusinessArea";
        String AUTHORIZED_VALID_PERIOD = "authorizedValidPeriod";
        String AUTH_CERT_URL = "authCertUrl";
        String FOOD_BIZ_LIC_NO = "foodBizLicNo";
        String FBL_VALID_PERIOD = "fblValidPeriod";
        String FOOD_BIZ_LIC_URL = "foodBizLicUrl";
        String DEL_FLG = "delFlg";
    }

    /**
     * <p>SLIM_MANUFACTURER_SUPPLY_QUALIFICATION表字段名。</p>
     */
    interface SlimManufacturerSupplyQualification {
        String ENTITY_SELLER_ID = "entitySellerId";
        String ENTRUSTED_PRODUCER_NAME = "entrustedProducerName";
        String OEM_PRODUCER_NAME = "oemProducerName";
        String OEM_VALID_PERIOD = "oemValidPeriod";
        String OEM_PROTOCOL_URL = "oemProtocolUrl";
        String FOOD_BIZ_LIC_NO = "foodBizLicNo";
        String FBL_VALID_PERIOD = "fblValidPeriod";
        String FOOD_BIZ_LIC_URL = "foodBizLicUrl";
        String DEL_FLG = "delFlg";
    }

    /**
     * <p>SLIM_SELLER_ROLE表字段名。</p>
     */
    interface SlimSellerRole {
        String ENTITY_SELLER_ID = "entitySellerId";
        String ROLE_ID = "roleId";
        String ROLE_NAME = "roleName";
    }
}
