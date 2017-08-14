/*
 * 2016/12/06 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services.impl;

import com.bms.byim.bean.entity.ByimCategory;
import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.CategoryRsParam;
import com.bms.byim.constant.MessageDef;
import com.bms.byim.dao.ByimCategoryDao;
import com.bms.byim.services.ByimCategoryService;
import com.bms.byim.utils.RestCommUtil;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.i18n.util.MessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>ByimCategoryService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class ByimCategoryServiceImpl extends BaseServiceImpl implements ByimCategoryService {

    @Autowired
    private ByimCategoryDao ByimCategoryDao;

    @Override
    public BaseDao getBaseDao() {
        return ByimCategoryDao;
    }

    @Override
    public ByimCategory findByByimCategoryCode(ByimCategory rsParam) {
        return ByimCategoryDao.findByByimCategoryCode(rsParam);
    }

    @Override
    public int nameCount(CategoryRsParam param) {
        return ByimCategoryDao.nameCount(param);
    }

    @Override
    public Integer checkedCategoryId(CategoryRsParam param) {
        return ByimCategoryDao.checkedCategoryId(param);
    }

    @Override
    public Integer executeBatchSave(List<ByimCategory> paramList) {
        int beansSize = paramList.size();
        String[] args;
        List<ByimCategory> list = new ArrayList<>();
        String code = ByimCategoryDao.selectCode();

        for (int i = 0; i < beansSize; i++) {
            if(paramList.get(i).getParentId().equals(0L)){
                if(StringUtils.isNotEmpty(code)){
                    code = Integer.valueOf(code) + 1 + "";
                }else {
                    code = "1";
                }
                paramList.get(i).setCategoryCode(code);

            }
            ByimCategory byimCategory = BeanUtils.toBean(paramList.get(i), ByimCategory.class);
            Long maxId = maxId("BYIM_CATEGORY");
            Date current = DateUtils.getCurrent();
            byimCategory.setCategoryId(maxId);
            byimCategory.setCrtTime(current);
            byimCategory.setUpdTime(current);
            byimCategory.setUpdId(getLoginUserId());
            byimCategory.setCrtId(getLoginUserId());
            if (paramList.get(i).getParentId().equals(NumberUtils.LONG_ZERO)) {
                byimCategory.setNodePath(StringUtils.toString(maxId));
                list.add(byimCategory);
            } else {
                ByimCategory rsParam = new ByimCategory();
                rsParam.setCategoryId(paramList.get(i).getParentId());
                ByimCategory findNode = findOne(rsParam);
                if (findNode != null && !StringUtils.isEmpty(findNode.getNodePath())) {
                    byimCategory.setNodePath(findNode.getNodePath() + "," + maxId);
                    list.add(byimCategory);
                } else {
                    args = new String[]{StringUtils.toString(i + 1), MessageManager.getMessage(MessageDef.Label.L00002)};
                    throw new BusinessException("BY", MessageDef.Error.E00002, args);
                }
            }
        }

        List<List<ByimCategory>> splitList = RestCommUtil.insertRanking(list);
        int insertCount;
        int countAll = NumberUtils.INTEGER_ZERO;
        int splSize = splitList.size();
        for (int j = 0; j < splSize; j++) {
            insertCount = batchSave(splitList.get(j));
            countAll += insertCount;
        }
        return countAll;
    }


    @Override
    public List<CategoryRsParam> executeModify(List<BaseBean<ByimCategory, ByimCategory>> paramList) {
        List<CategoryRsParam> returnList = new ArrayList<>();
        int beansSize = paramList.size();
        CategoryRsParam categoryRsParam;
        for (int i = 0; i < beansSize; i++) {
            int uCount;
            int uCount1;
            int uCount2 = NumberConst.IntDef.INT_ZERO;
            categoryRsParam = new CategoryRsParam();
            Date currentDate = DateUtils.getCurrent();
            paramList.get(i).getTarget().setUpdTime(currentDate);
            paramList.get(i).getTarget().setUpdId(getLoginUserId());
            if(paramList.get(i).getTarget().getDelFlg()){
                ByimCategory byimParam= findOne(paramList.get(i).getFilter());
                paramList.get(i).getTarget().setNodePath(byimParam.getNodePath());
                CategoryRsParam target = BeanUtils.toBean(paramList.get(i).getTarget(),CategoryRsParam.class);
                uCount1 = ByimCategoryDao.modifyDelFag(target);
                target.setNodePathLike(DbUtils.buildLikeCondition(byimParam.getNodePath()+",", DbUtils.LikeMode.FRONT));
                uCount2 = ByimCategoryDao.modifyLikeDelFag(target);
            }else{
                uCount1 = modify(paramList.get(i));
            }
            categoryRsParam.setCategoryId(paramList.get(i).getFilter().getCategoryId());
            returnList.add(categoryRsParam);
            uCount = uCount2 + uCount1;
            if(uCount == NumberUtils.INTEGER_ZERO){
                return null;
            }
        }
        return returnList;
    }

    @Override
    public List<CategoryRsParam> findListInfo(CategoryRsParam param) {
        if(StringUtils.isEmpty(param.getCategoryCode())){
            param.setCategoryCode(DbUtils.buildLikeCondition(param.getCategoryCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isEmpty(param.getCategoryName())){
            param.setCategoryName(DbUtils.buildLikeCondition(param.getCategoryName(), DbUtils.LikeMode.PARTIAL));
        }
        List<CategoryRsParam> categoryRsParamList =  ByimCategoryDao.findListInfo(param);
        for(int i=0,sizes=categoryRsParamList.size();i<sizes;i++){
            if(categoryRsParamList.get(i).getChildCount() > NumberConst.IntDef.INT_ZERO){
                categoryRsParamList.get(i).setHasChild(true);
            }else {
                categoryRsParamList.get(i).setHasChild(false);
            }
        }

        return categoryRsParamList;
    }


}