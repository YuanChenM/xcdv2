package com.bms.slpd.services.impl;


import com.bms.slpd.bean.BaseTarget;
import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdBreed;
import com.bms.slpd.bean.entity.SlpdBreedStdRelation;
import com.bms.slpd.bean.entity.SlpdClasses;
import com.bms.slpd.bean.entity.SlpdMachining;
import com.bms.slpd.bean.entity.target.SlpdBreedTarget;
import com.bms.slpd.bean.entity.target.SlpdClassesTarget;
import com.bms.slpd.bean.entity.target.SlpdMachiningTarget;
import com.bms.slpd.bean.param.*;
import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import com.bms.slpd.bean.result.SLPD0203IResult;
import com.bms.slpd.bean.result.field.SLPD0201IBreedResult;
import com.bms.slpd.bean.result.field.SLPD0301IBreedResult;
import com.bms.slpd.bean.result.field.SLPD0301IItemResult;
import com.bms.slpd.bean.result.wrapper.SlpdMachiningResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0203IDao;
import com.bms.slpd.services.*;
import com.framework.base.consts.NumberConst;
import com.framework.base.rest.result.BaseRestPaginationResult;
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
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD0203IServiceImpl extends BaseServiceImpl implements SLPD0203IService {

    private static Logger logger = LoggerFactory.getLogger(SLPD0203IServiceImpl.class);

    private Date updTime = DateUtils.getCurrent();

    @Autowired
    private SLPD0101IService slpd0101IService;
    @Autowired
    private SLPD0104IService slpd0104IService;
    @Autowired
    private SLPD0201IService slpd0201IService;
    @Autowired
    private SLPD0203IDao slpd0203IDao;
    @Autowired
    private SLPD0301IService slpd0301IService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0203IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0203IResult updateBreedByFlg(SLPD0203IParam requestParam) {
        List<SlpdBreedParam> updateParamList = requestParam.getBreedList();
        BaseTarget baseTarget = setTarget(requestParam);    //设置target
        SLPD0203IResult result = null;

        switch (requestParam.getUpdateFlg()) {
            case "1":
                result = updateClasses(updateParamList, baseTarget);
                break;
            case "2":
                result = updateMachinings(updateParamList, baseTarget);
                break;
            case "3":
                result = updateBreeds(updateParamList, baseTarget);
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 设置target
     */
    public BaseTarget setTarget(SLPD0203IParam requestParam) {
        BaseTarget baseTarget = null;
        String[] targets = requestParam.getTargets();
        StringBuilder builder = new StringBuilder();

        switch (requestParam.getUpdateFlg()) {
            case "1":
                SlpdClassesTarget slpdClassesTarget = new SlpdClassesTarget();
                for (String str : targets) {
                    if ("classesCode".equals(str)) {
                        slpdClassesTarget.setClassesCodeFlg(true);
                    } else if ("classesName".equals(str)) {
                        slpdClassesTarget.setClassesNameFlg(true);
                    } else if ("delFlg".equals(str)) {
                        slpdClassesTarget.setDelFlgFlg(true);
                    } else {
                        builder.append(str).append(",");
                    }
                }
                baseTarget = slpdClassesTarget;
                break;
            case "2":
                SlpdMachiningTarget slpdMachiningTarget = new SlpdMachiningTarget();
                for (String str : targets) {
                    if ("machiningName".equals(str)) {
                        slpdMachiningTarget.setMachiningNameFlg(true);
                    } else if ("machiningCode".equals(str)) {
                        slpdMachiningTarget.setMachiningCodeFlg(true);
                    } else if ("delFlg".equals(str)) {
                        slpdMachiningTarget.setDelFlgFlg(true);
                    } else {
                        builder.append(str).append(",");
                    }
                }
                baseTarget = slpdMachiningTarget;
                break;
            case "3":
                SlpdBreedTarget slpdBreedTarget = new SlpdBreedTarget();
                for (String str : targets) {
                    if ("breedSalesName".equals(str)) {
                        slpdBreedTarget.setBreedSalesNameFlg(true);
                    } else if ("breedCode".equals(str)) {
                        slpdBreedTarget.setBreedCodeFlg(true);
                    }else if ("breedScientificName".equals(str)) {
                        slpdBreedTarget.setBreedScientificNameFlg(true);
                    } else if ("breedLocalName".equals(str)) {
                        slpdBreedTarget.setBreedLocalNameFlg(true);
                    } else if ("delFlg".equals(str)) {
                        slpdBreedTarget.setDelFlgFlg(true);
                    } else {
                        builder.append(str).append(",");
                    }
                }
                baseTarget = slpdBreedTarget;
                break;
            default:
                break;
        }

        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("target有误请重新填写").toString());
        }
        return baseTarget;
    }

    /**
     * 修改一级分类
     */
    public SLPD0203IResult updateClasses(List<SlpdBreedParam> list, BaseTarget target) {
        String userId = super.getLoginUserId();
        SLPD0203IResult result = new SLPD0203IResult();
        //修改排他(名称唯一性)
        StringBuilder classesNameStr = this.checkClassesNames(list);
        if (!ObjectUtils.isEmpty(classesNameStr)) {
            result.setMessage(new String[]{classesNameStr.append("已存在或已被使用,请重新修改!").toString()});
            return result;
        }

        List<UpdateEntity<SlpdClasses, BaseTarget>> updateList = new ArrayList<>();
        SlpdClasses slpdClasses = null;
        for (SlpdBreedParam param : list) {
            slpdClasses = BeanUtils.toBean(param, SlpdClasses.class);
            slpdClasses.setUpdTime(updTime);
            slpdClasses.setUpdId(userId);
            UpdateEntity<SlpdClasses, BaseTarget> updateClasses = new UpdateEntity<>();
            updateClasses.setEntity(slpdClasses);
            updateClasses.setTarget(target);
            updateList.add(updateClasses);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> classesIds = new ArrayList<>();
        SlpdClassesTarget updateTarget = null;
        for (UpdateEntity<SlpdClasses, BaseTarget> updateEntity : updateList) {
            int eachCount = slpd0203IDao.updateClasses(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                classesIds.add(updateEntity.getEntity().getClassesId());
                //判断是否修改product
                updateTarget = (SlpdClassesTarget) updateEntity.getTarget();
                if (!updateTarget.isDelFlgFlg() && updateTarget.isClassesNameFlg()) {
                    this.slpd0203IDao.updateProductForClasses(updateEntity);
                }
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "一级分类修改失败,请刷新页面重试");
            }
        }
        result.setCount(count);
        result.setClassesIds(classesIds);
        return result;
    }

    /**
     * 修改一级分类排他
     */
    private StringBuilder checkClassesNames(List<SlpdBreedParam> paramList) {
        List<Long> updClassesIds = new ArrayList<>();   //查询被使用的一级分类参数
        //code不足补0
        String classesCode = null;
        for (SlpdBreedParam param : paramList) {
            updClassesIds.add(param.getClassesId());
            classesCode = param.getClassesCode();
            if (StringUtils.isNotEmpty(classesCode)) {
                param.setClassesCode(String.format("%03d",Long.valueOf(classesCode)));
            }
        }
        //获取已存在的一级分类名称
        SLPD0101IParam classesParam = new SLPD0101IParam();
        classesParam.setDelFlg(false);
        List<SlpdClasses> classesResults = slpd0101IService.findClasses(classesParam);
        if (CollectionUtils.isEmpty(classesResults)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的classesId不存在!");
        }

        //制作已存在的一级分类名称map&list
        Map<Long, SlpdClasses> sourceClassesMap = new HashMap<>();
        List<String> sourceClassesNames = new ArrayList<>();
        List<String> sourceClassesCodes = new ArrayList<>();
        for (SlpdClasses classes : classesResults) {
            sourceClassesMap.put(classes.getClassesId(), classes);
            sourceClassesNames.add(classes.getClassesName());
            sourceClassesCodes.add(classes.getClassesCode());
        }

        //查询已经被使用的一级分类code,用于判断是否可以修改该code
        SLPD0104IParam machiningParam = new SLPD0104IParam();
        machiningParam.setDelFlg(false);
        machiningParam.setClassesIds(updClassesIds);
        List<SlpdMachiningResult> machiningResults = slpd0104IService.findMachinings(machiningParam);
        //制作已被使用的一级分类map&list
        List<String> usedClassesCodes = new ArrayList<>();
        for (SlpdMachiningResult machiningResult : machiningResults) {
            if (!usedClassesCodes.contains(machiningResult.getClassesCode()))
                usedClassesCodes.add(machiningResult.getClassesCode());
        }

        String sourceCode = null;
        String sourceName = null;
        String updName = null;
        String updCode = null;
        Long updClassesId = null;
        StringBuilder classesNameStr = new StringBuilder();
        for (SlpdBreedParam breedParam : paramList) {
            updClassesId = breedParam.getClassesId();
            if (null == sourceClassesMap.get(updClassesId)) {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的一级分类不存在");
            }
            updName = breedParam.getClassesName();
            sourceName = sourceClassesMap.get(updClassesId).getClassesName();
            updCode = breedParam.getClassesCode();
            sourceCode = sourceClassesMap.get(updClassesId).getClassesCode();
            if (!sourceCode.equals(updCode) && usedClassesCodes.contains(sourceCode)) {    //修改了该code,但该code已经被使用过
                classesNameStr.append("一级分类编码:").append(sourceCode).append(",");
            }
            if (!sourceCode.equals(updCode) && sourceClassesCodes.contains(updCode)) {      //修改了该code,但要修改code已经重复
                classesNameStr.append("一级分类编码:").append(updCode).append(",");
            }
            if (!sourceName.equals(updName) && sourceClassesNames.contains(updName)) {      //修改了该name,但该name重复
                classesNameStr.append("一级分类名称:").append(updName).append(",");
            }
        }
        return classesNameStr;
    }

    /**
     * 修改二级分类
     */
    public SLPD0203IResult updateMachinings(List<SlpdBreedParam> list, BaseTarget target) {
        String userId = super.getLoginUserId();
        SLPD0203IResult result = new SLPD0203IResult();
        //修改排他
        StringBuilder machiningNameStr = this.checkMachiningNames(list);
        if (!ObjectUtils.isEmpty(machiningNameStr)) {
            result.setMessage(new String[]{machiningNameStr.append("已存在或已使用,请重新修改!").toString()});
            return result;
        }

        SlpdMachining slpdMachining = null;
        List<UpdateEntity<SlpdMachining, BaseTarget>> updateList = new ArrayList<>();
        for (SlpdBreedParam param : list) {
            UpdateEntity<SlpdMachining, BaseTarget> updateMachining = new UpdateEntity<>();
            slpdMachining = BeanUtils.toBean(param, SlpdMachining.class);
            slpdMachining.setUpdTime(updTime);
            slpdMachining.setUpdId(userId);
            updateMachining.setEntity(slpdMachining);
            updateMachining.setTarget(target);
            updateList.add(updateMachining);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> machiningIds = new ArrayList<>();
        SlpdMachiningTarget updateTarget = null;
        for (UpdateEntity<SlpdMachining, BaseTarget> updateEntity : updateList) {
            int eachCount = slpd0203IDao.updateMachinings(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                machiningIds.add(updateEntity.getEntity().getMachiningId());

                //判断是否修改product
                updateTarget = (SlpdMachiningTarget) updateEntity.getTarget();
                if (!updateTarget.isDelFlgFlg() && updateTarget.isMachiningNameFlg()) {
                    this.slpd0203IDao.updateProductForMachining(updateEntity);
                }
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "二级分类修改失败,请刷新页面重试");
            }
        }

        result.setCount(count);
        result.setMachiningIds(machiningIds);
        return result;
    }

    /**
     * 修改二级分类排他
     */
    private StringBuilder checkMachiningNames(List<SlpdBreedParam> paramList) {
        //code不足补0
        //根据machiningIds获取二级分类
        SLPD0104IParam machiningParam = new SLPD0104IParam();
        List<Long> machiningIds = new ArrayList<>();
        String machiningCode = null;
        for (SlpdBreedParam breedParam : paramList) {
            machiningIds.add(breedParam.getMachiningId());
            machiningCode = breedParam.getMachiningCode();
            if (StringUtils.isNotEmpty(machiningCode)) {
                breedParam.setMachiningCode(String.format("%03d",Long.valueOf(machiningCode)));
            }
        }
        machiningParam.setMachiningIds(machiningIds);
        machiningParam.setDelFlg(false);
        List<SlpdMachiningResult> machiningResults = slpd0104IService.findMachinings(machiningParam);
        if (CollectionUtils.isEmpty(machiningResults)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的machiningId不存在!");
        }
        Map<Long, SlpdMachiningResult> sourceMachiningMap = new HashMap<>();        //原始二级分类
        List<Long> classesIds = new ArrayList<>();      //制作查询参数
        Long classesId = null;
        for (SlpdMachiningResult machiningResult : machiningResults) {
            sourceMachiningMap.put(machiningResult.getMachiningId(), machiningResult);
            classesId = machiningResult.getClassesId();
            if (!classesIds.contains(classesId)) {
                classesIds.add(classesId);
            }
        }

        //根据machiningIds查询被使用的二级分类(修改code时判断)
        SLPD0201IParam machiningIdParam = new SLPD0201IParam();
        machiningIdParam.setDelFlg(false);
        machiningIdParam.setPagination(null);
        machiningIdParam.setMachiningIds(machiningIds);
        BaseRestPaginationResult<SLPD0201IBreedResult> breedRestResult = slpd0201IService.findBreeds(machiningIdParam);
        List<SLPD0201IBreedResult> breedResults = breedRestResult.getData();
        List<String> usedMachiningCodes = new ArrayList<>();
        for (SLPD0201IBreedResult result : breedResults) {
            if (!usedMachiningCodes.contains(result.getMachiningCode()))
                usedMachiningCodes.add(result.getMachiningCode());
        }

        //根据classesIds查询对应的二级分类名称,制作classesId-List<machiningName>的map
        SLPD0104IParam classesIdParams = new SLPD0104IParam();
        classesIdParams.setClassesIds(classesIds);
        classesIdParams.setDelFlg(false);
        List<SlpdMachiningResult> machiningResultsInClasses = slpd0104IService.findMachinings(classesIdParams);
        Map<Long, List<String>> machiningNameInClassesMap = new HashMap<>();        //一级分类对应machiningNames Map
        Map<Long, List<String>> machiningCodeInClassesMap = new HashMap<>();        //一级分类对应machiningCodes Map
        List<String> machiningNameInClassesList = null;
        List<String> machiningCodeInClassesList = null;
        if (CollectionUtils.isNotEmpty(machiningResultsInClasses)) {
            Long classesIdInResult = null;  //一级分类Id
            for (SlpdMachiningResult machiningResult : machiningResultsInClasses) {
                classesIdInResult = machiningResult.getClassesId();
                if (!machiningNameInClassesMap.containsKey(classesIdInResult)) {
                    machiningNameInClassesList = new ArrayList<>();
                    machiningNameInClassesList.add(machiningResult.getMachiningName());
                    machiningNameInClassesMap.put(classesIdInResult, machiningNameInClassesList);
                } else {
                    machiningNameInClassesMap.get(classesIdInResult).add(machiningResult.getMachiningName());
                }
                if (!machiningCodeInClassesMap.containsKey(classesIdInResult)) {
                    machiningCodeInClassesList = new ArrayList<>();
                    machiningCodeInClassesList.add(machiningResult.getMachiningCode());
                    machiningCodeInClassesMap.put(classesIdInResult, machiningCodeInClassesList);
                } else {
                    machiningCodeInClassesMap.get(classesIdInResult).add(machiningResult.getMachiningCode());
                }
            }
        }

        //处理排他
        String sourceMachiningCode = null;
        String updMachiningName = null;
        SlpdMachiningResult sourceMachining = null;
        List<String> machiningNameInClasses = null;     //一级分类对应的machiningName集合
        String updMachiningCode = null;
        List<String> machiningCodeInClasses = null;     //一级分类对应的machiningCode集合
        StringBuilder machiningNameStr = new StringBuilder();
        for (SlpdBreedParam breedParam : paramList) {
            updMachiningCode = breedParam.getMachiningCode();
            updMachiningName = breedParam.getMachiningName();
            sourceMachining = sourceMachiningMap.get(breedParam.getMachiningId());
            if (null == sourceMachining) {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的二级分类不存在!");
            }
            sourceMachiningCode = sourceMachining.getMachiningCode();
            machiningNameInClasses = machiningNameInClassesMap.get(sourceMachining.getClassesId());
            machiningCodeInClasses = machiningCodeInClassesMap.get(sourceMachining.getClassesId());
            if (!sourceMachiningCode.equals(updMachiningCode) && usedMachiningCodes.contains(sourceMachiningCode)) {
                machiningNameStr.append("二级分类编码:").append(sourceMachiningCode).append(",");
            }
            if (!sourceMachiningCode.equals(updMachiningCode) && machiningCodeInClasses.contains(updMachiningCode)) {
                machiningNameStr.append("二级分类编码:").append(updMachiningCode).append(",");
            }
            if (!sourceMachining.getMachiningName().equals(updMachiningName) && machiningNameInClasses.contains(updMachiningName)) {
                machiningNameStr.append("二级分类名称:").append(updMachiningName).append(",");
            }
        }
        return machiningNameStr;
    }

    /**
     * 修改品种
     */
    public SLPD0203IResult updateBreeds(List<SlpdBreedParam> list, BaseTarget target) {
        String userId = super.getLoginUserId();
        SLPD0203IResult result = new SLPD0203IResult();
        //修改排他
        StringBuilder breedNameStr = this.checkBreedNames(list);
        if (!ObjectUtils.isEmpty(breedNameStr)) {
            result.setMessage(new String[]{breedNameStr.append("已经存在,请重新修改!").toString()});
            return result;
        }

        List<SlpdBreedStdRelation> stdRelationList = new ArrayList<>();
        List<UpdateEntity<SlpdBreed, BaseTarget>> updateList = new ArrayList<>();
        SlpdBreed slpdBreed = null;
        SlpdBreedStdRelation slpdBreedStdRelation = null;

        //设置更新entity
        for (SlpdBreedParam param : list) {
            UpdateEntity<SlpdBreed, BaseTarget> updateBreed = new UpdateEntity<>();
            slpdBreed = BeanUtils.toBean(param, SlpdBreed.class);
            slpdBreed.setUpdTime(updTime);
            slpdBreed.setUpdId(userId);
            updateBreed.setEntity(slpdBreed);
            updateBreed.setTarget(target);
            updateList.add(updateBreed);
            //判断是否新增档案卡关系表
            if (param.isOrgStdFlg() || param.isFedStdFlg() || param.isMctStdFlg() || param.isTncStdFlg()
                    || param.isGnqStdFlg() || param.isSftStdFlg() || param.isTspStdFlg()) {
                slpdBreedStdRelation = BeanUtils.toBean(param, SlpdBreedStdRelation.class);
                slpdBreedStdRelation.setBreedId(param.getBreedId());
                slpdBreedStdRelation.setBreedStdId(this.maxId(TableConstant.Name.SLPD_BREED_STD_RELATION));
                slpdBreedStdRelation.setCrtTime(updTime);
                slpdBreedStdRelation.setCrtId(super.getLoginUserId());
                slpdBreedStdRelation.setUpdTime(updTime);
                slpdBreedStdRelation.setUpdId(super.getLoginUserId());
                stdRelationList.add(slpdBreedStdRelation);
            }
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> breedIds = new ArrayList<>();
        SlpdBreedTarget updateTarget = null;
        for (UpdateEntity<SlpdBreed, BaseTarget> updateEntity : updateList) {
            int eachCount = slpd0203IDao.updateBreeds(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                breedIds.add(updateEntity.getEntity().getBreedId());

                //判断是否修改product
                updateTarget = (SlpdBreedTarget) updateEntity.getTarget();
                if ((updateTarget.isBreedLocalNameFlg() || updateTarget.isBreedSalesNameFlg()
                        || updateTarget.isBreedScientificNameFlg()) && !updateTarget.isDelFlgFlg()) {
                    this.slpd0203IDao.updateProductForBreed(updateEntity);
                }
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "品种修改失败,请刷新页面重试");
            }
        }

        if (CollectionUtils.isNotEmpty(breedIds)) {
            int deleteCount = slpd0203IDao.deleteBreedStdRelation(breedIds);        //物理删除
            logger.info("删除档案卡关系表的数量:" + deleteCount);
        }
        if (CollectionUtils.isNotEmpty(stdRelationList) && !target.isDelFlgFlg()) {
            int insertCount = slpd0203IDao.saveBreedStdRelations(stdRelationList);
            logger.info("新增档案卡关系表的数量:" + insertCount);
        }
        result.setCount(count);
        result.setBreedIds(breedIds);
        return result;
    }

    /**
     * 修改品种排他
     */
    private StringBuilder checkBreedNames(List<SlpdBreedParam> paramList) {
        String breedCode = null;
        for (SlpdBreedParam param : paramList) {
            breedCode = param.getBreedCode();
            if (StringUtils.isNotEmpty(breedCode)) {
                param.setBreedCode(String.format("%03d",Long.valueOf(breedCode)));
            }
        }
        //根据breeedIds获取品种
        List<Long> breedIds = new ArrayList<>();
        for (SlpdBreedParam slpdBreedParam : paramList) {
            breedIds.add(slpdBreedParam.getBreedId());
        }
        SLPD0201IParam breedParam = new SLPD0201IParam();
        breedParam.setBreedIds(breedIds);
        breedParam.setDelFlg(false);
        breedParam.setPagination(null);
        BaseRestPaginationResult<SLPD0201IBreedResult> breedResults = slpd0201IService.findBreeds(breedParam);
        List<SLPD0201IBreedResult> breedResultList = breedResults.getData();
        if (CollectionUtils.isEmpty(breedResultList)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的breedId不存在!");
        }
        Map<Long, SLPD0201IBreedResult> sourceBreedMap = new HashMap<>();        //原始品种
        List<Long> machiningIds = new ArrayList<>();      //制作查询参数
        Long machiningId = null;
        for (SLPD0201IBreedResult breedResult : breedResultList) {
            sourceBreedMap.put(breedResult.getBreedId(), breedResult);
            machiningId = breedResult.getMachiningId();
            if (!machiningIds.contains(machiningId)) {
                machiningIds.add(machiningId);
            }
        }

        //根据machiningIds查询对应的二级分类名称,制作machiningId-List<breedName>的map
        SLPD0201IParam machiningIdParams = new SLPD0201IParam();
        machiningIdParams.setMachiningIds(machiningIds);
        machiningIdParams.setDelFlg(false);
        machiningIdParams.setPagination(null);
        BaseRestPaginationResult<SLPD0201IBreedResult> breedInMachiningResults = slpd0201IService.findBreeds(machiningIdParams);
        List<SLPD0201IBreedResult> breedResultsInMachining = breedInMachiningResults.getData();
        Map<Long, List<String>> breedNameInMachiningMap = new HashMap<>();        //二级分类对应breedNames Map
        List<String> breedNameInMachiningList = null;
        Map<Long, List<String>> breedCodeInMachiningMap = new HashMap<>();        //二级分类对应breedNames Map
        List<String> breedCodeInMachiningList = null;
        if (CollectionUtils.isNotEmpty(breedResultsInMachining)) {
            Long machiningIdInResult = null;  //二级分类Id
            for (SLPD0201IBreedResult breedResult : breedResultsInMachining) {
                machiningIdInResult = breedResult.getMachiningId();
                if (!breedNameInMachiningMap.containsKey(machiningIdInResult)) {
                    breedNameInMachiningList = new ArrayList<>();
                    breedNameInMachiningList.add(breedResult.getBreedSalesName());
                    breedNameInMachiningMap.put(machiningIdInResult, breedNameInMachiningList);
                } else {
                    breedNameInMachiningMap.get(machiningIdInResult).add(breedResult.getBreedSalesName());
                }
                if (!breedCodeInMachiningMap.containsKey(machiningIdInResult)) {
                    breedCodeInMachiningList = new ArrayList<>();
                    breedCodeInMachiningList.add(breedResult.getBreedCode());
                    breedCodeInMachiningMap.put(machiningIdInResult, breedCodeInMachiningList);
                } else {
                    breedCodeInMachiningMap.get(machiningIdInResult).add(breedResult.getBreedCode());
                }
            }
        }

        //根据breedIds查询已使用的breedCode(修改code判断)
        SLPD0301IParam itemParam = new SLPD0301IParam();
        itemParam.setBreedIds(breedIds);
        itemParam.setDelFlg(false);
        itemParam.setPagination(null);
        BaseRestPaginationResult<SLPD0301IItemResult> itemRestResults = slpd0301IService.findItems(itemParam);
        List<SLPD0301IItemResult> itemResults = itemRestResults.getData();
        List<String> usedBreedCodes = new ArrayList<>();
        SLPD0301IBreedResult breed = null;
        for (SLPD0301IItemResult result : itemResults) {
            breed = result.getBreed();
            if (null == breed)
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, "单品Id:" + result.getItemId() +"对应的品种的不存在,请联系管理员");
            if (!usedBreedCodes.contains(breed.getBreedCode()))
                usedBreedCodes.add(breed.getBreedCode());
        }
        //处理排他
        String sourceBreedCode = null;
        String updBreedName = null;
        String updBreedCode = null;
        SLPD0201IBreedResult sourceBreed = null;
        List<String> breedNameInMachining = null;     //二级分类对应的breeedName集合
        StringBuilder breedNameStr = new StringBuilder();
        List<String> breedCodeInMachining = null;     //二级分类对应的breeedName集合
        for (SlpdBreedParam slpdBreedParam : paramList) {
            updBreedCode = slpdBreedParam.getBreedCode();
            updBreedName = slpdBreedParam.getBreedSalesName();
            sourceBreed = sourceBreedMap.get(slpdBreedParam.getBreedId());
            if (null == sourceBreed) {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的品种不存在!");
            }
            sourceBreedCode = sourceBreed.getBreedCode();
            breedNameInMachining = breedNameInMachiningMap.get(sourceBreed.getMachiningId());
            breedCodeInMachining = breedCodeInMachiningMap.get(sourceBreed.getMachiningId());
            if (!sourceBreedCode.equals(updBreedCode) && usedBreedCodes.contains(sourceBreedCode)) {
                breedNameStr.append("品种编码:").append(sourceBreedCode).append(",");
            }
            if (!sourceBreedCode.equals(updBreedCode) && breedCodeInMachining.contains(updBreedCode)) {
                breedNameStr.append("品种编码:").append(updBreedCode).append(",");
            }
            if (!sourceBreed.getBreedSalesName().equals(updBreedName) && breedNameInMachining.contains(updBreedName)) {
                breedNameStr.append("品种名称:").append(updBreedName).append(",");
            }
        }
        return breedNameStr;
    }

}
