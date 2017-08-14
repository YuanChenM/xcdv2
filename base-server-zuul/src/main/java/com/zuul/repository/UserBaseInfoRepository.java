//package com.zuul.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by mao_yejun on 2017/2/27.
// */@Repository("userBaseInfoRepository")
//public interface UserBaseInfoRepository extends PagingAndSortingRepository<UserBaseInfoEntity, Long> {
//    Page<UserBaseInfoEntity> findAllByDelFlg(boolean delFlg,Pageable pageable);
//    @Modifying
//    @Query("update UserBaseInfoEntity user set user.delFlg = ?1  where user.userId in ?2")
//    int deleteUser(boolean flag, List<Long> id);
//    UserBaseInfoEntity findModuleByModuleIdAndDelFlg(long userId,boolean delFlg);
// }
