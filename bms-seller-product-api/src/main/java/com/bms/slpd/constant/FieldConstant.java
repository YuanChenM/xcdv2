package com.bms.slpd.constant;

/**
 * <p>数据库表字段常量类。</p>
 */
public interface FieldConstant {

    /**
     * <p>表公共字段名。</p>
     */
    interface Common {
        String DEL_FLG = "DEL_FLG";
        String CRT_ID = "CRT_ID";
        String CRT_TIME = "CRT_TIME";
        String UPD_ID = "UPD_ID";
        String UPD_TIME = "UPD_TIME";
        String VERSION = "VERSION";
    }

	/**
	 * <p>SLPD_BRAND表字段名。</p>
	 */
	interface SlpdBrand {
		String BRAND_ID = "BRAND_ID";
		String BRAND_CODE = "BRAND_CODE";
		String BRAND_NAME = "BRAND_NAME";
		String BRAND_TYPE = "BRAND_TYPE";
		String TRADEMARK_REG_NO = "TRADEMARK_REG_NO";
		String START_VALID_DATE = "START_VALID_DATE";
		String END_VALID_DATE = "END_VALID_DATE";
		String BRAND_CERT_URL = "BRAND_CERT_URL";
		String PRODUCT_PACKAGE_URL = "PRODUCT_PACKAGE_URL";
		String HONOR_CERT_NO = "HONOR_CERT_NO";
		String HONOR_CERT_DATE = "HONOR_CERT_DATE";
		String HONOR_CERT_UNIT = "HONOR_CERT_UNIT";
		String HONOR_CERT_URL = "HONOR_CERT_URL";
		String AUDIT_STU = "AUDIT_STU";
		String AUDIT_REMARK = "AUDIT_REMARK";
		String AUDIT_HISTORY = "AUDIT_HISTORY";
	}

	/**
	 * <p>SLPD_BRAND_OWNER表字段名。</p>
	 */
	interface SlpdBrandOwner {
		String BRAND_OWNER_ID = "BRAND_OWNER_ID";
		String BRAND_OWNER_CODE = "BRAND_OWNER_CODE";
		String OWNER_NAME = "OWNER_NAME";
		String OWNER_TYPE = "OWNER_TYPE";
	}

	/**
	 * <p>SLPD_BRAND_OWNER_RELATION表字段名。</p>
	 */
	interface SlpdBrandOwnerRelation {
		String BO_RELATION_ID = "BO_RELATION_ID";
		String BRAND_ID = "BRAND_ID";
		String BRAND_OWNER_ID = "BRAND_OWNER_ID";
	}

	/**
	 * <p>SLPD_CLASSES表字段名。</p>
	 */
	interface SlpdClasses {
		String CLASSES_ID = "CLASSES_ID";
		String CLASSES_CODE = "CLASSES_CODE";
		String CLASSES_NAME = "CLASSES_NAME";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_MACHINING表字段名。</p>
	 */
	interface SlpdMachining {
		String MACHINING_ID = "MACHINING_ID";
		String CLASSES_ID = "CLASSES_ID";
		String MACHINING_CODE = "MACHINING_CODE";
		String MACHINING_NAME = "MACHINING_NAME";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_BREED表字段名。</p>
	 */
	interface SlpdBreed {
		String BREED_ID = "BREED_ID";
		String CLASSES_ID = "CLASSES_ID";
		String MACHINING_ID = "MACHINING_ID";
		String BREED_CODE = "BREED_CODE";
		String BREED_SKU = "BREED_SKU";
		String BREED_SALES_NAME = "BREED_SALES_NAME";
		String BREED_SCIENTIFIC_NAME = "BREED_SCIENTIFIC_NAME";
		String BREED_LOCAL_NAME = "BREED_LOCAL_NAME";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_ITEM表字段名。</p>
	 */
	interface SlpdItem {
		String ITEM_ID = "ITEM_ID";
		String CLASSES_ID = "CLASSES_ID";
		String MACHINING_ID = "MACHINING_ID";
		String BREED_ID = "BREED_ID";
		String FEATURE_CODE = "FEATURE_CODE";
		String ITEM_SKU = "ITEM_SKU";
		String ITEM_NAME = "ITEM_NAME";
		String SPECIFICATION = "SPECIFICATION";
		String PROCESSING_METHOD = "PROCESSING_METHOD";
		String TASTE = "TASTE";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_BRAND_ITEM表字段名。</p>
	 */
	interface SlpdBrandItem {
		String BRAND_ITEM_ID = "BRAND_ITEM_ID";
		String BRAND_ITEM_SKU = "BRAND_ITEM_SKU";
		String ITEM_ID = "ITEM_ID";
		String BRAND_ID = "BRAND_ID";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_BRAND_ITEM_PROPERTY表字段名。</p>
	 */
	interface SlpdBrandItemProperty {
		String BRAND_ITEM_PROPERTY_ID = "BRAND_ITEM_PROPERTY_ID";
		String BRAND_ITEM_ID = "BRAND_ITEM_ID";
		String SOURCE_TYPE = "SOURCE_TYPE";
		String GROSS_WEIGHT = "GROSS_WEIGHT";
		String NET_WEIGHT = "NET_WEIGHT";
		String PACKAGE_SPECIFICATION = "PACKAGE_SPECIFICATION";
		String PACKAGE_QUANTITY = "PACKAGE_QUANTITY";
		String CARTON_DIMENSION = "CARTON_DIMENSION";
		String PALLET_STACKING_LIMIT = "PALLET_STACKING_LIMIT";
		String AUDIT_STU = "AUDIT_STU";
	}

	/**
	 * <p>SLPD_PRODUCT表字段名。</p>
	 */
	interface SlpdProduct {
		String ID = "ID";
		String PRODUCT_ID = "PRODUCT_ID";
		String QUALITY_GRADE_TYPE = "QUALITY_GRADE_TYPE";
		String AUDIT_STU = "AUDIT_STU";
		String AUDIT_REMARK = "AUDIT_REMARK";
		String BRAND_ITEM_PROPERTY_ID = "BRAND_ITEM_PROPERTY_ID";
		String BRAND_ITEM_ID = "BRAND_ITEM_ID";
		String BRAND_ITEM_SKU = "BRAND_ITEM_SKU";
		String BRAND_ID = "BRAND_ID";
		String BRAND_CODE = "BRAND_CODE";
		String BRAND_NAME = "BRAND_NAME";
		String BRAND_TYPE = "BRAND_TYPE";
		String ITEM_ID = "ITEM_ID";
		String FEATURE_CODE = "FEATURE_CODE";
		String ITEM_SKU = "ITEM_SKU";
		String ITEM_NAME = "ITEM_NAME";
		String SPECIFICATION = "SPECIFICATION";
		String PROCESSING_METHOD = "PROCESSING_METHOD";
		String TASTE = "TASTE";
		String BREED_ID = "BREED_ID";
		String BREED_CODE = "BREED_CODE";
		String BREED_SKU = "BREED_SKU";
		String BREED_SALES_NAME = "BREED_SALES_NAME";
		String BREED_SCIENTIFIC_NAME = "BREED_SCIENTIFIC_NAME";
		String BREED_LOCAL_NAME = "BREED_LOCAL_NAME";
		String MACHINING_ID = "MACHINING_ID";
		String MACHINING_CODE = "MACHINING_CODE";
		String MACHINING_NAME = "MACHINING_NAME";
		String CLASSES_ID = "CLASSES_ID";
		String CLASSES_CODE = "CLASSES_CODE";
		String CLASSES_NAME = "CLASSES_NAME";
	}

	/**
	 * <p>SLPD_PRODUCER_PRODUCT表字段名。</p>
	 */
	interface SlpdProducerProduct {
		String PRODUCER_PRODUCT_ID = "PRODUCER_PRODUCT_ID";
		String PRODUCER_PRODUCT_SKU = "PRODUCER_PRODUCT_SKU";
		String PRODUCT_ID = "PRODUCT_ID";
		String PRODUCER_ID = "PRODUCER_ID";
		String PRODUCER_CODE = "PRODUCER_CODE";
		String PRODUCER_NAME = "PRODUCER_NAME";
		String AUDIT_STU = "AUDIT_STU";
		String AUDIT_REMARK = "AUDIT_REMARK";
		String AUDIT_HISTORY = "AUDIT_HISTORY";
	}

	/**
	 * <p>SLPD_COMMODITY表字段名。</p>
	 */
	interface SlpdCommodity {
		String ID = "ID";
		String COMMODITY_ID = "COMMODITY_ID";
		String PRODUCT_ID = "PRODUCT_ID";
		String SALE_TYPE = "SALE_TYPE";
	}

	/**
	 * <p>SLPD_SELLER_COMMODITY表字段名。</p>
	 */
	interface SlpdSellerCommodity {
		String SELLER_COMMODITY_ID = "SELLER_COMMODITY_ID";
		String SELLER_COMMODITY_CODE = "SELLER_COMMODITY_CODE";
		String SELLER_COMMODITY_SKU = "SELLER_COMMODITY_SKU";
		String SELLER_ID = "SELLER_ID";
		String SELLER_CODE = "SELLER_CODE";
		String SELLER_NAME = "SELLER_NAME";
		String PRODUCER_PRODUCT_ID = "PRODUCER_PRODUCT_ID";
		String PRODUCT_ID = "PRODUCT_ID";
		String ARTICLE_NO = "ARTICLE_NO";
		String SALE_TYPE = "SALE_TYPE";
		String COMMODITY_ID = "COMMODITY_ID";
		String SALE_TITLE = "SALE_TITLE";
		String AUDIT_STU = "AUDIT_STU";
		String AUDIT_REMARK = "AUDIT_REMARK";
		String AUDIT_HISTORY = "AUDIT_HISTORY";
	}

}
