package com.zuul.repository;

import com.zuul.bean.result.UserAuthResult;
import com.zuul.bean.result.UserSearchResult;
import com.zuul.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mao_yejun on 2016/12/21.
 */
@Repository("userRepository")
public interface UserEntityRepository extends PagingAndSortingRepository<UserEntity, Long> {
    List<UserEntity> findPageListByLoginIdAndPasswordAndDelFlg(String loginId, String password, boolean delFlg);

    UserEntity findUserByLoginIdAndPasswordAndDelFlg(String loginId, String password, boolean delFlg);
    UserEntity findUserByLoginIdAndDelFlg(String loginId, boolean delFlg);
    @Modifying
    @Query("update UserEntity user set user.delFlg = ?1  where user.userId in ?2")
    int deleteUser(boolean flag, List<Long> id);
    Page<UserEntity> findAllByDelFlgAndCompanyNameLike(boolean delFlg,String companyName, Pageable pageable);
    Page<UserEntity> findAllByDelFlg(boolean delFlg, Pageable pageable);
    UserEntity findUserByUserIdAndDelFlg(long userId, boolean delFlg);
}
