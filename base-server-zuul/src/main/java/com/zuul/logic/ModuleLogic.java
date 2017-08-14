package com.zuul.logic;

import com.zuul.bean.PageResult;
import com.zuul.bean.Pagination;
import com.zuul.bean.param.ModuleCreateParam;
import com.zuul.bean.param.ModuleInterFaceSearchParam;
import com.zuul.bean.param.ModuleSearchParam;
import com.zuul.bean.param.ModuleUpdateParam;
import com.zuul.bean.result.ModuleSearchResult;
import com.zuul.entity.InterfaceEntity;
import com.zuul.entity.ModuleEntity;
import com.zuul.repository.InterfaceRepository;
import com.zuul.repository.ModuleRepository;
import com.zuul.util.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@Service
public class ModuleLogic extends BaseLogic {
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private InterfaceRepository interfaceRepository;

    /**
     * 创建新的模块
     */
    public void createModule(ModuleCreateParam param) {
        ModuleEntity moduleEntity = new ModuleEntity();
        moduleEntity.setCrtId(this.getLoginUserId());
        moduleEntity.setCrtTime(new Date());
        moduleEntity.setDelFlg(false);
        moduleEntity.setModuleCode(param.getModuleCode());
        moduleEntity.setModuleName(param.getModuleName());
        moduleRepository.save(moduleEntity);
    }

    @Transactional
    public boolean deleteModule(ArrayList<Long> param) {
        int rs = moduleRepository.deleteModule(true, param);
        return rs != 0;
    }

    public PageResult<ModuleSearchResult> searchModule(ModuleSearchParam param) {
        Pagination pagination = param.getPagination();
        Pageable pageable = null;
        if (pagination != null) {
            pageable = new PageRequest(getStartPos(pagination), pagination.getPageSize());
        }
        Page<ModuleEntity> page;
        String moduleName = param.getModuleName();
        if (StringUtils.isEmpty(moduleName)) {
            page = moduleRepository.findAllByDelFlg(false, pageable);
        } else {
            moduleName = DbUtils.buildLikeCondition(moduleName, DbUtils.LikeMode.PARTIAL);
            page = moduleRepository.findAllByDelFlgAndModuleNameLike(false, moduleName, pageable);
        }
        List<ModuleSearchResult> data = new ArrayList<>();
        PageResult<ModuleSearchResult> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotalElements());
        for (ModuleEntity m : page.getContent()) {
            ModuleSearchResult userSearchResult = new ModuleSearchResult();
            userSearchResult.setModuleId(m.getModuleId());
            userSearchResult.setModuleCode(m.getModuleCode());
            userSearchResult.setModuleName(m.getModuleName());
            data.add(userSearchResult);
        }
        pageResult.setData(data);
        return pageResult;
    }

    public ModuleSearchResult searchModuleDetail(long moduleId) {
        ModuleSearchResult userSearchResult = new ModuleSearchResult();
        ModuleEntity moduleEntity = moduleRepository.findModuleByModuleIdAndDelFlg(moduleId, false);
        userSearchResult.setModuleCode(moduleEntity.getModuleCode());
        userSearchResult.setModuleId(moduleEntity.getModuleId());
        userSearchResult.setModuleName(moduleEntity.getModuleName());
        return userSearchResult;
    }

    public boolean updateModuleDetail(ModuleUpdateParam param) {
        ModuleEntity moduleEntity = moduleRepository.findModuleByModuleIdAndDelFlg(param.getModuleId(), false);
        moduleEntity.setModuleName(param.getModuleName());
        moduleEntity.setModuleId(param.getModuleId());
        moduleEntity.setModuleCode(param.getModuleCode());
        moduleEntity.setUpdId(this.getLoginUserId());
        moduleEntity.setUpdTime(new Date());
        moduleRepository.save(moduleEntity);
        return true;
    }

    public PageResult<InterfaceEntity> searchModuleInterface(ModuleInterFaceSearchParam param) {
        Pageable pageable = new PageRequest(getStartPos(param.getPagination()), param.getPagination().getPageSize());

        Page<InterfaceEntity> page;
        String interfaceUrl = param.getInterfaceUrl();
        if (StringUtils.isEmpty(interfaceUrl)) {
            page = interfaceRepository.findAllByModuleIdAndDelFlg(param.getModuleId(), false, pageable);
        } else {
            interfaceUrl = DbUtils.buildLikeCondition(interfaceUrl, DbUtils.LikeMode.PARTIAL);
            page = interfaceRepository.findAllByModuleIdAndDelFlgAndInterfaceUrlLike(param.getModuleId(), false, interfaceUrl, pageable);
        }
        interfaceRepository.findAllByModuleIdAndDelFlg(param.getModuleId(), false, pageable);
        PageResult<InterfaceEntity> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotalElements());
        pageResult.setData(page.getContent());
        return pageResult;
    }

    public ArrayList<ModuleSearchResult> searchAllModule(ModuleSearchParam param) {
        return null;
    }
}
