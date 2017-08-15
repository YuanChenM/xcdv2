package com.bms.slpd.dao;

import com.bms.slpd.bean.entity.SlpdBreed;
import com.bms.slpd.bean.entity.SlpdBreedStdRelation;
import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.entity.SlpdMachining;
import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import com.framework.boot.base.BaseDao;

import java.util.List;
import java.util.Map;

public interface SLPD0202IDao extends BaseDao {

    /**
     * 获取一级分类最大编码
     */
    String getMaxClassesCode();

    /**
     * 新增一级分类
     */
    int saveClasses(List<SlpdClasses> classes);

    /**
     * 获取二级分类最大编码
     */
    List<Map<String,Long>> getMaxMachiningCode(List<Long> classeIds);

    /**
     * 新增二级分类
     */
    int saveMachinings(List<SlpdMachining> machinings);

    /**
     * 获取品种最大编码
     */
    List<Map<String,Long>> getMaxBreedCode(SLPD0104IParam slpd0104IParam);

    /**
     * 新增品种
     */
    int saveBreeds(List<SlpdBreed> breeds);

    /**
     * 新增品种与档案卡关系
     */
    int saveBreedStdRelations(List<SlpdBreedStdRelation> slpdBreedStdRelations);

    /**
     * 新增一级分类排他
     */
    List<SlpdClasses> checkClassesNames(List<SlpdBreedParam> classes);

    /**
     * 新增二级分类排他
     */
    List<SlpdMachining> checkMachiningNames(List<SlpdBreedParam> machinings);

    /**
     * 新增品种排他
     */
    List<SlpdBreed> checkBreedNames(List<SlpdBreedParam> breeds);

    /**
     * 新增一级分类Code排他
     */
    List<SlpdClasses> checkClassesCodes(List<SlpdBreedParam> classes);

    /**
     * 新增二级分类Code排他
     */
    List<SlpdMachining> checkMachiningCodes(List<SlpdBreedParam> machinings);

    /**
     * 新增品种Code排他
     */
    List<SlpdBreed> checkBreedCodes(List<SlpdBreedParam> breeds);

}
