package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBreed;
import com.bms.slpd.bean.entity.SlpdBreedStdRelation;
import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.entity.SlpdMachining;
import com.bms.slpd.bean.param.SLPD0104IParam;
import com.bms.slpd.bean.param.SLPD0202IParam;
import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import com.bms.slpd.bean.result.SLPD0202IResult;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0202IDao;
import com.bms.slpd.services.SLPD0104IService;
import com.bms.slpd.services.SLPD0202IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SLPD0202IServiceImpl extends BaseServiceImpl implements SLPD0202IService {

    private static final Logger logger = LoggerFactory.getLogger(SLPD0202IServiceImpl.class);

    private Date crtTime = DateUtils.getCurrent();

    @Autowired
    private SLPD0104IService slpd0104IService;

    @Autowired
    private SLPD0202IDao slpd0202IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0202IDao;
    }

    /**
     * 新增一级分类
     */
    private SLPD0202IResult saveClasses(SLPD0202IParam requestParam) {
        String userId = super.getLoginUserId();
        List<SlpdBreedParam> breedParams = requestParam.getBreedList();
        String checkStr = this.checkClassesCodeNames(breedParams);
        if (StringUtils.isNotEmpty(checkStr)) {
            SLPD0202IResult result = new SLPD0202IResult();
            result.setMessage(new String[]{checkStr});
            return result;
        }
        List<Long> classesIds = new ArrayList<>();
        List<SlpdClasses> classesList = new ArrayList<>();
        SlpdClasses classes = null;
        for (SlpdBreedParam param : breedParams) {
            classes = BeanUtils.toBean(param, SlpdClasses.class);
            classes.setClassesId(this.maxId(TableConstant.Name.SLPD_CLASSES));
            classes.setAuditStu(false); //审核状态默认待审核
            classes.setCrtTime(crtTime);
            classes.setUpdTime(crtTime);
            classes.setUpdId(userId);
            classes.setCrtId(userId);
            classesList.add(classes);
            classesIds.add(classes.getClassesId());
        }
        int count = slpd0202IDao.saveClasses(classesList);

        SLPD0202IResult result = new SLPD0202IResult();
        result.setCount(count);
        result.setClassesIds(classesIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    /**
     * 一级分类排他(name+code)
     */
    private String checkClassesCodeNames(List<SlpdBreedParam> breedParams) {
        String classesCode = null;
        for (SlpdBreedParam param : breedParams) {
            classesCode = param.getClassesCode();
            param.setClassesCode(String.format("%03d",Long.valueOf(classesCode)));
        }
        //新增排他(classesName)
        List<SlpdClasses> classesNames = slpd0202IDao.checkClassesNames(breedParams);
        StringBuilder builder = new StringBuilder("一级分类名称:");
        if (CollectionUtils.isNotEmpty(classesNames)) {
            for (SlpdClasses classes : classesNames) {
                builder.append(classes.getClassesName()).append(",");
            }
            builder.append("已经存在,请重新填写!");
            return builder.toString();
        }
        //新增排他(classesCode)
        List<SlpdClasses> classesCodes = slpd0202IDao.checkClassesCodes(breedParams);
        StringBuilder classesCodeStr = new StringBuilder("一级分类编码:");
        if (CollectionUtils.isNotEmpty(classesCodes)) {
            for (SlpdClasses classes : classesCodes) {
                classesCodeStr.append(classes.getClassesCode()).append(",");
            }
            classesCodeStr.append("已经存在,请重新填写!");
            return classesCodeStr.toString();
        }
        return null;
    }

    /**
     * 新增二级分类
     */
    public SLPD0202IResult saveMachinings(SLPD0202IParam slpd0202IParam) {
        String userId = super.getLoginUserId();
        List<SlpdBreedParam> breedParams = slpd0202IParam.getBreedList();

        String checkStr = this.checkMachiningCodeNames(breedParams);
        if (StringUtils.isNotEmpty(checkStr)) {
            SLPD0202IResult result = new SLPD0202IResult();
            result.setMessage(new String[]{checkStr});
            return result;
        }
        List<Long> machiningIds = new ArrayList<>();
        List<SlpdMachining> machiningList = new ArrayList<>();

        SlpdMachining machining = null;
        for (SlpdBreedParam param : breedParams) {
            machining = BeanUtils.toBean(param, SlpdMachining.class);
            machining.setMachiningId(this.maxId(TableConstant.Name.SLPD_MACHINING));
//            machining.setMachiningCode(getMachiningCode(breedParams,param.getClassesId()));
            machining.setAuditStu(false);   //审核状态默认待审核
            machining.setCrtTime(crtTime);
            machining.setUpdTime(crtTime);
            machining.setUpdId(userId);
            machining.setCrtId(userId);
            machiningList.add(machining);
            machiningIds.add(machining.getMachiningId());
        }
        int count = slpd0202IDao.saveMachinings(machiningList);

        SLPD0202IResult result = new SLPD0202IResult();
        result.setCount(count);
        result.setMachiningIds(machiningIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    /**
     * 二级分类排他(name+code)
     */
    private String checkMachiningCodeNames(List<SlpdBreedParam> breedParams) {
        //code设置
        String machiningCode = null;
        for (SlpdBreedParam param : breedParams) {
            machiningCode = param.getMachiningCode();
            param.setMachiningCode(String.format("%03d",Long.valueOf(machiningCode)));
        }
        //新增排他(name)
        List<SlpdMachining> machiningNames = slpd0202IDao.checkMachiningNames(breedParams);
        StringBuilder builder = new StringBuilder("二级分类名称:");
        if (CollectionUtils.isNotEmpty(machiningNames)) {
            for (SlpdMachining machining : machiningNames) {
                builder.append(machining.getMachiningName()).append(",");
            }
            builder.append("已经存在,请重新填写!");
            return builder.toString();
        }
        //新增排他(code)
        List<SlpdMachining> machiningCodes = slpd0202IDao.checkMachiningCodes(breedParams);
        StringBuilder machiningCodeStr = new StringBuilder("二级分类编码:");
        if (CollectionUtils.isNotEmpty(machiningCodes)) {
            for (SlpdMachining machining : machiningCodes) {
                machiningCodeStr.append(machining.getMachiningCode()).append(",");
            }
            machiningCodeStr.append("已经存在,请重新填写!");
            return machiningCodeStr.toString();
        }
        return null;
    }

    /**
     * 新增品种
     */
    public SLPD0202IResult saveBreeds(SLPD0202IParam slpd0202IParam) {
        String userId = super.getLoginUserId();
        List<SlpdBreedParam> breedParams = slpd0202IParam.getBreedList();
        String checkStr = this.checkBreedCodeNames(breedParams);
        if (StringUtils.isNotEmpty(checkStr)) {
            SLPD0202IResult result = new SLPD0202IResult();
            result.setMessage(new String[]{checkStr});
            return result;
        }
        //获取classesCode+machiningCode
        Map<Long, String> machiningSkuMap = getMachiningSku(slpd0202IParam);

        List<Long> breedIds = new ArrayList<>();
        List<SlpdBreed> breedList = new ArrayList<>();
        List<SlpdBreedParam> stdRelationParamList = new ArrayList<>();

        SlpdBreed breed = null;
        SlpdBreedParam stdRelationParam = null;
        for (SlpdBreedParam param : breedParams) {
            breed = BeanUtils.toBean(param, SlpdBreed.class);
            breed.setBreedId(this.maxId(TableConstant.Name.SLPD_BREED));
//            breed.setBreedCode(getBreedCode(breedParams,param.getClassesId(),param.getMachiningId()));
            String machiningSku = machiningSkuMap.get(param.getMachiningId());
            if (StringUtils.isNotEmpty(machiningSku)) {
                breed.setBreedSku(machiningSku + breed.getBreedCode());
            } else {
                throw new BusinessException("SLPD", "无法获取对应的品种SKU");
            }
            breed.setAuditStu(false);   //审核状态默认待审核
            breed.setCrtTime(crtTime);
            breed.setUpdTime(crtTime);
            breed.setUpdId(userId);
            breed.setCrtId(userId);
            breedList.add(breed);
            breedIds.add(breed.getBreedId());

            stdRelationParam = BeanUtils.toBean(param, SlpdBreedParam.class);
            stdRelationParam.setBreedId(breed.getBreedId());
            stdRelationParamList.add(stdRelationParam);
        }
        //设置品种档案卡关系信息
        saveStdBreedRelation(stdRelationParamList);

        int count = slpd0202IDao.saveBreeds(breedList);
        SLPD0202IResult result = new SLPD0202IResult();
        result.setCount(count);
        result.setBreedIds(breedIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    /**
     * 品种排他(name+code)
     */
    private String checkBreedCodeNames(List<SlpdBreedParam> breedParams) {
        String breedCode = null;
        for (SlpdBreedParam param : breedParams) {
            breedCode = param.getBreedCode();
            param.setBreedCode(String.format("%03d",Long.valueOf(breedCode)));
        }
        //新增排他(name)
        List<SlpdBreed> breedNames = slpd0202IDao.checkBreedNames(breedParams);
        StringBuilder builder = new StringBuilder("品种销售名:");
        if (CollectionUtils.isNotEmpty(breedNames)) {
            for (SlpdBreed breed : breedNames) {
                builder.append(breed.getBreedSalesName()).append(",");
            }
            builder.append("已存在或已使用,请重新填写!");
            return builder.toString();
        }
        //新增排他(code)
        List<SlpdBreed> breedCodes = slpd0202IDao.checkBreedCodes(breedParams);
        StringBuilder breedCodeStr = new StringBuilder("品种编码:");
        if (CollectionUtils.isNotEmpty(breedCodes)) {
            for (SlpdBreed breed : breedCodes) {
                breedCodeStr.append(breed.getBreedCode()).append(",");
            }
            breedCodeStr.append("已经存在,请重新填写!");
            return breedCodeStr.toString();
        }
        return null;
    }

    /**
     * 快速录入
     */
    public SLPD0202IResult quickInsert(SLPD0202IParam slpd0202IParam) {
        String userId = super.getLoginUserId();
        List<SlpdClasses> classesLists = new ArrayList<>();
        List<SlpdMachining> machiningLists = new ArrayList<>();
        List<SlpdBreed> breedLists = new ArrayList<>();
        List<Long> breedIds = new ArrayList<>();
        List<SlpdBreedParam> stdRelationParamList = new ArrayList<>();

        SlpdClasses classes = null;
        SlpdMachining machining = null;
        SlpdBreed breed = null;
        SlpdBreedParam stdRelationParam = null;

        List<SlpdBreedParam> breedParams = slpd0202IParam.getBreedList();
        String checkClassesCodeStr = this.checkMachiningCodeNames(breedParams);
        String checkMachiningCodeStr = this.checkMachiningCodeNames(breedParams);
        String checkBreedCodeStr = this.checkMachiningCodeNames(breedParams);
        SLPD0202IResult result = new SLPD0202IResult();
        if (StringUtils.isNotEmpty(checkClassesCodeStr)) {
            result.setMessage(new String[]{checkClassesCodeStr});
            return result;
        } else if (StringUtils.isNotEmpty(checkMachiningCodeStr)) {
            result.setMessage(new String[]{checkMachiningCodeStr});
            return result;
        } else if (StringUtils.isNotEmpty(checkBreedCodeStr)) {
            result.setMessage(new String[]{checkBreedCodeStr});
            return result;
        }

        for (SlpdBreedParam param : breedParams) {
            //设置一级分类
            classes = BeanUtils.toBean(param, SlpdClasses.class);
            classes.setClassesId(this.maxId(TableConstant.Name.SLPD_CLASSES));
            classes.setAuditStu(false);     //审核状态默认待审核
            classes.setCrtTime(crtTime);
            classes.setUpdTime(crtTime);
            classes.setUpdId(userId);
            classes.setCrtId(userId);
            classesLists.add(classes);

            //设置二级分类
            machining = BeanUtils.toBean(param, SlpdMachining.class);
            machining.setClassesId(classes.getClassesId());
            machining.setMachiningId(this.maxId(TableConstant.Name.SLPD_MACHINING));
//            machining.setMachiningCode(getMachiningCode(slpd0202IParam.getBreedList(), param.getClassesId()));
            machining.setAuditStu(false);       //审核状态默认待审核
            machining.setCrtTime(crtTime);
            machining.setUpdTime(crtTime);
            machining.setUpdId(userId);
            machining.setCrtId(userId);
            machiningLists.add(machining);

            //设置品种
            breed = BeanUtils.toBean(param, SlpdBreed.class);
            breed.setClassesId(classes.getClassesId());
            breed.setMachiningId(machining.getMachiningId());
            breed.setBreedId(this.maxId(TableConstant.Name.SLPD_BREED));
//            breed.setBreedCode(getBreedCode(slpd0202IParam.getBreedList(),param.getClassesId(),param.getMachiningId()));
            breed.setBreedSku(classes.getClassesCode() + machining.getMachiningCode() + breed.getBreedCode());
            breed.setAuditStu(false);       //审核状态默认待审核
            breed.setCrtTime(crtTime);
            breed.setUpdTime(crtTime);
            breed.setUpdId(userId);
            breed.setCrtId(userId);
            breedLists.add(breed);
            breedIds.add(breed.getBreedId());

            //设置品种与档案卡关系
            stdRelationParam = BeanUtils.toBean(param, SlpdBreedParam.class);
            stdRelationParam.setBreedId(breed.getBreedId());
            stdRelationParamList.add(stdRelationParam);
        }

        saveStdBreedRelation(stdRelationParamList);
        slpd0202IDao.saveClasses(classesLists);
        slpd0202IDao.saveMachinings(machiningLists);
        int count = slpd0202IDao.saveBreeds(breedLists);

        result.setBreedIds(breedIds);
        result.setCount(count);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    /**
     * 新增品种与档案卡关系
     */
    public void saveStdBreedRelation(List<SlpdBreedParam> breedList) {
        String userId = super.getLoginUserId();
        List<SlpdBreedStdRelation> relationList = new ArrayList<>();
        SlpdBreedStdRelation slpdBreedStdRelation = null;

        for (SlpdBreedParam param : breedList) {
            if (param.isOrgStdFlg() || param.isFedStdFlg() || param.isMctStdFlg() || param.isTncStdFlg()
                    || param.isGnqStdFlg() || param.isSftStdFlg() || param.isTspStdFlg()) {
                slpdBreedStdRelation = BeanUtils.toBean(param, SlpdBreedStdRelation.class);
                slpdBreedStdRelation.setBreedId(param.getBreedId());
                slpdBreedStdRelation.setBreedStdId(this.maxId(TableConstant.Name.SLPD_BREED_STD_RELATION));
                slpdBreedStdRelation.setCrtTime(crtTime);
                slpdBreedStdRelation.setCrtId(userId);
                slpdBreedStdRelation.setUpdId(userId);
                slpdBreedStdRelation.setUpdTime(crtTime);
                relationList.add(slpdBreedStdRelation);
            }
        }

        if (CollectionUtils.isNotEmpty(relationList)) {
            int relationCount = slpd0202IDao.saveBreedStdRelations(relationList);
            logger.info("品种档案卡关系表新增数量: " + relationCount);
        }
    }

    /***
     * 获取classesCode+machiningCode
     */
    public Map<Long, String> getMachiningSku(SLPD0202IParam param) {
        List<Long> classesCodeList = new ArrayList<>();
        List<Long> machiningCodeList = new ArrayList<>();
        for (SlpdBreedParam breedParam : param.getBreedList()) {
            if (!classesCodeList.contains(breedParam.getClassesId())) {
                classesCodeList.add(breedParam.getClassesId());
            }
            if (!machiningCodeList.contains(breedParam.getMachiningId())) {
                machiningCodeList.add(breedParam.getMachiningId());
            }
        }

        SLPD0104IParam machiningCodeParam = new SLPD0104IParam();
        machiningCodeParam.setClassesIds(classesCodeList);
        machiningCodeParam.setMachiningIds(machiningCodeList);

        List<SlpdMachiningResult> machiningResults = slpd0104IService.findMachinings(machiningCodeParam);
        Map<Long, String> machiningCodeMap = new HashMap<>();
        String classesMachiningCode = null;
        for (SlpdMachiningResult result : machiningResults) {
            classesMachiningCode = result.getClassesCode() + result.getMachiningCode();
            machiningCodeMap.put(result.getMachiningId(), classesMachiningCode);
        }

        return machiningCodeMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0202IResult saveBreedsByFlg(SLPD0202IParam requestParam) {
        SLPD0202IResult result = null;
        switch (requestParam.getInsertFlg()) {
            case "1":
                result = saveClasses(requestParam);
                break;
            case "2":
                result = saveMachinings(requestParam);
                break;
            case "3":
                result = saveBreeds(requestParam);
                break;
            case "4":
                result = quickInsert(requestParam);
                break;
            default:
                break;
        }
        return result;
    }

}
