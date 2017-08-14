package com.zuul.logic;

import com.zuul.bean.PageResult;
import com.zuul.bean.param.InterfaceCreateParam;
import com.zuul.bean.param.UpdateInterfaceParam;
import com.zuul.bean.param.UserNoneAuthSearchParam;
import com.zuul.bean.result.ModuleSearchResult;
import com.zuul.bean.result.UserAuthResult;
import com.zuul.entity.InterfaceEntity;
import com.zuul.entity.ModuleEntity;
import com.zuul.repository.InterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@Service
public class InterfaceLogic extends BaseLogic {
    @Autowired
    private InterfaceRepository interfaceRepository;

    /**
     * 新建接口
     *
     * @param param
     */
    public void createInterface(InterfaceCreateParam param) {
        InterfaceEntity interfaceEntity = new InterfaceEntity();
        interfaceEntity.setCrtId(this.getLoginUserId());
        interfaceEntity.setDelFlg(false);
        interfaceEntity.setCrtTime(new Date());
        interfaceEntity.setModuleId(param.getModuleId());
        interfaceEntity.setInterfaceCode(param.getInterfaceCode());
        interfaceEntity.setInterfaceUrl(param.getInterfaceUrl());
        interfaceEntity.setInterfaceName(param.getInterfaceName());
        interfaceRepository.save(interfaceEntity);

    }

    @Transactional
    public boolean deleteInterface(ArrayList<Long> param) {
        return interfaceRepository.deleteInterface(true, param) != 0;
    }

    public InterfaceEntity searchInterfaceDetail(long interfaceDetailId) {
        return interfaceRepository.findInterfaceByInterfaceDetailIdAndDelFlg(interfaceDetailId, false);
    }

    public boolean updateInterface(UpdateInterfaceParam param) {
        InterfaceEntity interfaceEntity = interfaceRepository.findInterfaceByInterfaceDetailIdAndDelFlg(param.getInterfaceDetailId(), false);
        interfaceEntity.setInterfaceName(param.getInterfaceName());
        interfaceEntity.setInterfaceUrl(param.getInterfaceUrl());
        interfaceEntity.setUpdTime(new Date());
        interfaceEntity.setUpdId(this.getLoginUserId());
        interfaceRepository.save(interfaceEntity);
        return true;
    }

    public PageResult<UserAuthResult> searchNoAuthInterface(UserNoneAuthSearchParam param) {
        PageResult<UserAuthResult> pageResult = new PageResult<>();
        ArrayList<Object[]> page;
        Long moduleId = param.getModuleId();
        if (moduleId == null) {
            page = interfaceRepository.searchNoAuthInterface(param.getUserId(), this.getStartPos(param.getPagination()), param.getPagination().getPageSize());

        }else {
            page = interfaceRepository.searchNoAuthInterfaceAndModuleId(param.getUserId(),moduleId, this.getStartPos(param.getPagination()), param.getPagination().getPageSize());

        }
        ArrayList<UserAuthResult> data = new ArrayList();
        for (Object[] o : page) {
            UserAuthResult userAuthResult = new UserAuthResult();
            userAuthResult.setInterfaceDetailId(String.valueOf(o[0]));
            userAuthResult.setInterfaceName((String) o[1]);
            userAuthResult.setInterfaceUrl((String) o[2]);
            userAuthResult.setModuleName((String) o[3]);
            userAuthResult.setModuleCode((String) o[4]);
            data.add(userAuthResult);
        }
        pageResult.setTotal(1);
        pageResult.setData(data);
        return pageResult;
    }
}
