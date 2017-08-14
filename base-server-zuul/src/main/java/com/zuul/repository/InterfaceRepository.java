package com.zuul.repository;

import com.zuul.bean.PageResult;
import com.zuul.bean.param.UserNoneAuthSearchParam;
import com.zuul.bean.result.UserAuthResult;
import com.zuul.entity.InterfaceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@Repository("interfaceRepository")
public interface InterfaceRepository extends PagingAndSortingRepository<InterfaceEntity, Long> {
    Page<InterfaceEntity> findAllByModuleIdAndDelFlg(long moduleId, boolean delFlg, Pageable pageable);

    Page<InterfaceEntity> findAllByModuleIdAndDelFlgAndInterfaceUrlLike(long moduleId, boolean delFlg, String interfaceUrl, Pageable pageable);

    @Modifying
    @Query("update InterfaceEntity interface set interface.delFlg = ?1  where interface.interfaceDetailId in ?2")
    int deleteInterface(boolean flag, List<Long> id);

    InterfaceEntity findInterfaceByInterfaceDetailIdAndDelFlg(long interfaceDetailId, boolean delFlg);

    @Query(value = "SELECT interface.interface_detail_id as interfaceDetailId, " +
            "interface.interface_name as interfaceName ," +
            "interface.interface_url as interfaceUrl, " +
            "module.interface_module_name as moduleName, " +
            "module.interface_module_code as moduleCode " +
            "FROM interface_detail interface , interface_module module " +
            "WHERE " +
            " module.interface_module_id = interface.interface_module_id " +
            "and interface.del_flg = '0' " +
            "and interface.interface_detail_id not in " +
            "(select ua.interface_detail_id from interface_user_authority ua where ua.interface_user_id = ?1 and ua.del_flg ='0') limit ?2,?3", nativeQuery = true)
    ArrayList<Object[]> searchNoAuthInterface(long userId, int start, int end);

    @Query(value = "SELECT interface.interface_detail_id as interfaceDetailId, " +
            "interface.interface_name as interfaceName ," +
            "interface.interface_url as interfaceUrl, " +
            "module.interface_module_name as moduleName, " +
            "module.interface_module_code as moduleCode " +
            "FROM interface_detail interface , interface_module module " +
            "WHERE " +
            " interface.interface_module_id=?2 " +
            "and  module.interface_module_id = interface.interface_module_id " +
            "and interface.del_flg = '0' " +
            "and interface.interface_detail_id not in " +
            "(select ua.interface_detail_id from interface_user_authority ua where ua.interface_user_id = ?1 and ua.del_flg ='0') limit ?3,?4", nativeQuery = true)
    ArrayList<Object[]> searchNoAuthInterfaceAndModuleId(long userId, long moduleId,int start, int end);

}
