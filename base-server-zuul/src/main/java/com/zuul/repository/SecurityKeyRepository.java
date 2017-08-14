package com.zuul.repository;

import com.zuul.entity.SecurityKeyEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mao_yejun on 2017/2/22.
 */
@Repository("securityKeyRepository")
public interface SecurityKeyRepository  extends PagingAndSortingRepository<SecurityKeyEntity, Long> {
    SecurityKeyEntity findSecurityKeyEntityByApiKeyAndDelFlg(String apiKey, Boolean delFlg);
}
