package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.*;
import com.bms.slpd.bean.result.field.SLPD0507IProductResult;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0507IDao extends BaseDao {

	/**
	 * 计数产品，该产品必须满足未删除，非指定产品ID，审核状态正式，指定单品品牌规格ID
	 */
	int countValidBrandItemProperties(SlpdProduct product);

	/**
	 * 根据产品ID，批量查询产品
	 */
	List<SlpdProduct> findProductsByProductIds(List<String> productIds);

	/**
	 * 修改一级分类的审核状态
	 */
	int updateClassesAuditStu(SlpdClasses classes);

	/**
	 * 修改二级分类的审核状态
	 */
	int updateMachiningAuditStu(SlpdMachining machining);

	/**
	 * 修改品种的审核状态
	 */
	int updateBreedAuditStu(SlpdBreed breed);

	/**
	 * 修改单品的审核状态
	 */
	int updateItemAuditStu(SlpdItem item);

	/**
	 * 修改品牌的审核状态
	 */
	int updateBrandAuditStu(SlpdBrand brand);

	/**
	 * 修改单品品牌的审核状态
	 */
	int updateBrandItemAuditStu(SlpdBrandItem brandItem);

	/**
	 * 修改单品品牌规格的审核状态
	 */
	int updateBrandItemPropertyAuditStu(SlpdItemProperty brandItemProperty);

	/**
	 * 修改产品的审核状态
	 */
	int updateProductAuditStu(SlpdProduct product);

	/**
	 * 根据产品ID，批量查询生产商产品
	 */
	List<SlpdProducerProduct> findProducerProductsByProductIds(List<String> productIds);

	/**
	 * 根据产品ID，批量查询产品(包含规格信息)
	 */
	List<SLPD0507IProductResult> findProductsByIds(List<String> productIds);

}
