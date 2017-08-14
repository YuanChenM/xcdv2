package com.zuul.repository;

import com.zuul.entity.ModuleEntity;
import com.zuul.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@Repository("moduleRepository")
public interface ModuleRepository extends PagingAndSortingRepository<ModuleEntity, Long> {
    @Modifying
    @Query("update ModuleEntity module set module.delFlg = ?1  where module.moduleId in ?2")
    int deleteModule(boolean flag, List<Long> id);
    Page<ModuleEntity> findAllByDelFlg(boolean delFlg, Pageable pageable);
    Page<ModuleEntity> findAllByDelFlgAndModuleNameLike(boolean delFlg, String moduleName,Pageable pageable);
    ModuleEntity findModuleByModuleIdAndDelFlg(long moduleId, boolean delFlg);
}
