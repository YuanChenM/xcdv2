package com.zuul.resource;//package com.authentication.resource;
//
//import com.authentication.entity.UserEntity;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//import java.util.List;
//
//
///**
// * Created by mao_yejun on 2016/12/20.
// */
//@RepositoryRestResource(collectionResourceRel = "user",path = "user")
//public interface UserEntityRepository extends PagingAndSortingRepository<UserEntity, Long> {
//    List<UserEntity> findByLastName(@Param("name") String name);
//}
