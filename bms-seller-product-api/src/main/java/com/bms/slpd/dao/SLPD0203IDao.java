package com.bms.slpd.dao;

import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdBreedStdRelation;
import com.framework.boot.base.BaseDao;

import java.util.List;

public interface SLPD0203IDao extends BaseDao {
    /**
     * 修改一级分类
     */
    int updateClasses(UpdateEntity classes);

    /**
     * 修改二级分类
     */
    int updateMachinings(UpdateEntity machinings);

    /**
     * 修改品种
     */
    int updateBreeds(UpdateEntity breeds);

    /**
     * 删除品种与档案卡关系
     */
    int deleteBreedStdRelation(List<Long> breedIds);

    /**
     * 新增品种与档案卡关系
     */
    int saveBreedStdRelations(List<SlpdBreedStdRelation> slpdBreedStdRelations);

    /**
     * 修改产品表的一级分类
     */
    int updateProductForClasses(UpdateEntity entity);

    /**
     * 修改产品表的二级分类
     */
    int updateProductForMachining(UpdateEntity entity);

    /**
     * 修改产品表的品种
     */
    int updateProductForBreed(UpdateEntity entity);
}
