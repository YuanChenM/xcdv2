package com.zuul.repository;

import com.zuul.bean.result.UserAuthResult;
import com.zuul.entity.UserAuthorityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mao_yejun on 2017/3/1.
 */
public interface UserAuthorityRepository extends PagingAndSortingRepository<UserAuthorityEntity, Long> {
    Page<UserAuthorityEntity> findAllByUserIdAndDelFlg(Long userId, boolean delFlg, Pageable pageable);
    @Modifying
    @Query("update UserAuthorityEntity auth set auth.delFlg = ?1  where auth.interfaceDetailId in ?2")
    int deleteAuth(boolean flag, List<Long> id);

    @Query(value = "SELECT interface.interface_detail_id as interfaceDetailId, " +
            "interface.interface_name as interfaceName ," +
            "interface.interface_url as interfaceUrl, " +
            "module.interface_module_name as moduleName, " +
            "module.interface_module_code as moduleCode " +
            "FROM interface_detail interface , interface_module module,interface_user_authority authority " +
            "WHERE " +
            " module.interface_module_id = interface.interface_module_id " +
            " and interface.del_flg = '0' " +
            " and authority.del_flg = '0'" +
            " and authority.interface_detail_id = interface.interface_detail_id " +
            " and authority.interface_user_id = ?1" +
            " limit ?2,?3", nativeQuery = true)
    List<Object[]> findAllByUserIdAndDelFlg(Long userId, int start, int end);
    @Query(value = "SELECT interface.interface_detail_id as interfaceDetailId, " +
            "interface.interface_name as interfaceName ," +
            "interface.interface_url as interfaceUrl, " +
            "module.interface_module_name as moduleName, " +
            "module.interface_module_code as moduleCode " +
            "FROM interface_detail interface , interface_module module,interface_user_authority authority " +
            "WHERE " +
            " module.interface_module_id = interface.interface_module_id " +
            " and interface.del_flg = '0' " +
            " and interface.interface_url like %?2%" +
            " and authority.del_flg = '0'" +
            " and authority.interface_detail_id = interface.interface_detail_id " +
            " and authority.interface_user_id = ?1" +
            " limit ?3,?4", nativeQuery = true)
    List<Object[]> findAllByUserIdAndUri(Long userId,String uri, int start, int end);
}
