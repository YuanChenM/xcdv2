package com.zuul.logic;

import com.zuul.bean.PageResult;
import com.zuul.bean.RestResponse;
import com.zuul.bean.param.*;
import com.zuul.bean.result.UserAuthResult;
import com.zuul.bean.result.UserLoginResult;
import com.zuul.bean.result.UserSearchResult;
import com.zuul.entity.*;
import com.zuul.repository.SecurityKeyRepository;
import com.zuul.repository.UserAuthorityRepository;
import com.zuul.repository.UserEntityRepository;
import com.zuul.util.DbUtils;
import com.zuul.util.Md5Digest;
import com.zuul.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mao_yejun on 2017/2/22.
 */
@Service
public class UserLogic extends BaseLogic {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private UserAuthorityRepository userAuthorityRepository;
    @Autowired
    SecurityKeyRepository securityKeyRepository;

    /**
     * 登陆后返回apiKey和securityKey
     *
     * @param param
     * @return
     */
    public RestResponse<UserLoginResult> userLogin(UserLoginParam param) {
        RestResponse<UserLoginResult> response = new RestResponse<>();
        UserLoginResult userLoginResult = new UserLoginResult();
        UserEntity user = userEntityRepository.findUserByLoginIdAndDelFlg(param.getLoginId(), false);
        //生成时效性的SECURITYKEY
        if (null != user) {
            boolean checkPass = param.getPassword().equals(Md5Digest.digest(user.getPassword()));
            if (checkPass) {
                String securityKey = Md5Digest.digest(UUIDUtil.getRandom());
                SecurityKeyEntity securityKeyEntity = user.getSecurityKeyEntity();
                securityKeyEntity.setSecurityKey(securityKey);
                user.setSecurityKeyEntity(securityKeyEntity);
                userEntityRepository.save(user);
                userLoginResult.setSecurityKey(securityKey);
                userLoginResult.setApiKey(securityKeyEntity.getApiKey());
                response.setResult(userLoginResult);
                response.setMessage("获取成功");
                response.setReturnCode("S");
            } else {
                response.setMessage("获取失败,用户名或密码不正确");
                response.setReturnCode("F");
            }
        } else {
            response.setMessage("获取失败用户名或密码不正确");
            response.setReturnCode("F");
        }
        return response;
    }

    /**
     * 新增用户
     *
     * @param param
     */
    @Transactional
    public void userRegister(UserRegisterParam param) {
        UserEntity user = new UserEntity();
        String userId = this.getLoginUserId();
        Date now = new Date();
        user.setLoginId(param.getLoginId());
        user.setPassword(param.getPassword());
        user.setDelFlg(false);
        user.setCrtTime(now);
        user.setCrtId(userId);
        user.setCompanyName(param.getCompanyName());
        user.setCompanyWebAdd(param.getCompanyWebAdd());
        user.setContacts(param.getContacts());
        user.setPhone(param.getContactsPhone());
        user.setQq(param.getQq());
        user.setMail(param.getContactsMail());
        user.setWeChat(param.getWeChat());
        user.setDelFlg(false);
        user.setCrtTime(now);
        user = userEntityRepository.save(user);
        SecurityKeyEntity securityKeyEntity = new SecurityKeyEntity();
        securityKeyEntity.setUserId(user.getUserId());
        securityKeyEntity.setCrtId(userId);
        securityKeyEntity.setTimeliness(Integer.valueOf(-1));
        securityKeyEntity.setTimelinessType(Integer.valueOf(-1));
        securityKeyEntity.setCrtTime(now);
        securityKeyEntity.setDelFlg(false);
        securityKeyEntity.setApiKey(Md5Digest.digest(UUIDUtil.getRandom()));
        securityKeyRepository.save(securityKeyEntity);
    }

    /**
     * 查询所有人员
     *
     * @return
     */
    public PageResult<UserSearchResult> searchUser(UserSearchParam param) {
        Pageable pageable = new PageRequest(getStartPos(param.getPagination()), param.getPagination().getPageSize());
        Page<UserEntity> page;
        String companyName = param.getCompanyName();
        if (!StringUtils.isEmpty(companyName)) {
            companyName = DbUtils.buildLikeCondition(companyName, DbUtils.LikeMode.PARTIAL);
            page = userEntityRepository.findAllByDelFlgAndCompanyNameLike(false, companyName, pageable);
        } else {
            page = userEntityRepository.findAllByDelFlg(false, pageable);
        }
        List<UserSearchResult> data = new ArrayList<>();
        PageResult<UserSearchResult> pageResult = new PageResult<>();
        pageResult.setTotal(page.getTotalElements());
        for (UserEntity u : page.getContent()) {
            UserSearchResult userSearchResult = new UserSearchResult();
            userSearchResult.setUserId(u.getUserId());
            userSearchResult.setLoginId(u.getLoginId());
            userSearchResult.setPassword(u.getPassword());
            userSearchResult.setCompanyName(u.getCompanyName());
            userSearchResult.setPhone(u.getPhone());
            userSearchResult.setCompanyName(u.getCompanyName());
            userSearchResult.setCompanyWebAdd(u.getCompanyWebAdd());
            userSearchResult.setContacts(u.getContacts());
            userSearchResult.setQq(u.getQq());
            userSearchResult.setMail(u.getMail());
            userSearchResult.setWeChat(u.getWeChat());
            userSearchResult.setAllFlg(u.getAllFlg());
            data.add(userSearchResult);
        }
        pageResult.setData(data);
        return pageResult;

    }

    /**
     * 根据userId查询用户
     *
     * @param userId
     * @return
     */
    public UserSearchResult searchUserDetail(Long userId) {
        UserSearchResult userSearchResult = new UserSearchResult();
        UserEntity userEntity = userEntityRepository.findUserByUserIdAndDelFlg(userId, false);
        userSearchResult.setUserId(userEntity.getUserId());
        userSearchResult.setLoginId(userEntity.getLoginId());
        userSearchResult.setPassword(userEntity.getPassword());
        userSearchResult.setCompanyName(userEntity.getCompanyName());
        userSearchResult.setPhone(userEntity.getPhone());
        userSearchResult.setCompanyName(userEntity.getCompanyName());
        userSearchResult.setCompanyWebAdd(userEntity.getCompanyWebAdd());
        userSearchResult.setContacts(userEntity.getContacts());
        userSearchResult.setQq(userEntity.getQq());
        userSearchResult.setMail(userEntity.getMail());
        userSearchResult.setWeChat(userEntity.getWeChat());
        userSearchResult.setAllFlg(userEntity.getAllFlg());
        return userSearchResult;
    }

    @Transactional
    public boolean deleteUser(List<Long> ids) {
        userEntityRepository.deleteUser(true, ids);
        return true;
    }

    /**
     *
     */
    public boolean updateUserDetail(UserUpdateParam param) {
        String updId = this.getLoginUserId();
        Date now = new Date();
        Long userId = param.getUserId();
        UserEntity userEntity = userEntityRepository.findUserByUserIdAndDelFlg(userId, false);
        userEntity.setUserId(userId);
        userEntity.setLoginId(param.getLoginId());
        userEntity.setPassword(param.getPassword());
        userEntity.setCompanyName(param.getCompanyName());
        userEntity.setCompanyWebAdd(param.getCompanyWebAdd());
        userEntity.setContacts(param.getContacts());
        userEntity.setPhone(param.getContactsPhone());
        userEntity.setQq(param.getQq());
        userEntity.setMail(param.getContactsMail());
        userEntity.setWeChat(param.getWeChat());
        userEntity.setAllFlg(param.getAllFlg());
        userEntity.setDelFlg(false);
        userEntity.setUpdTime(now);
        userEntity.setUpdId(updId);
        userEntityRepository.save(userEntity);
        return true;
    }


    public PageResult<UserAuthResult> searchAuthByUser(UserAuthSearchParam param) {
        List<Object[]> rs;
        if (StringUtils.isEmpty(param.getInterfaceUrl())) {
            rs = userAuthorityRepository.findAllByUserIdAndDelFlg(param.getUserId(), getStartPos(param.getPagination()), param.getPagination().getPageSize());
        } else {
            rs = userAuthorityRepository.findAllByUserIdAndUri(param.getUserId(), param.getInterfaceUrl(), getStartPos(param.getPagination()), param.getPagination().getPageSize());
        }
        PageResult<UserAuthResult> pageResult = new PageResult<>();
        ArrayList<UserAuthResult> list = new ArrayList();
        for (Object[] o : rs) {
            UserAuthResult userAuthResult = new UserAuthResult();
            userAuthResult.setInterfaceDetailId(String.valueOf(o[0]));
            userAuthResult.setInterfaceName((String) o[1]);
            userAuthResult.setInterfaceUrl((String) o[2]);
            userAuthResult.setModuleName((String) o[3]);
            userAuthResult.setModuleCode((String) o[4]);
            list.add(userAuthResult);
        }
        pageResult.setTotal(1);
        pageResult.setData(list);
        return pageResult;

    }

    @Transactional
    public boolean deleteAuthByIds(List<Long> ids) {
        userAuthorityRepository.deleteAuth(true, ids);
        return true;
    }

    public boolean saveAuthByUser(AuthSaveParam param) {
        List<Long> interfaceList = param.getInterfaceList();
        for (Long id : interfaceList) {
            UserAuthorityEntity userAuthorityEntity = new UserAuthorityEntity();
            userAuthorityEntity.setCrtId(super.getLoginUserId());
            userAuthorityEntity.setUpdTime(new Date());
            userAuthorityEntity.setInterfaceDetailId(id);
            userAuthorityEntity.setUserId(param.getUserId());
            userAuthorityEntity.setDelFlg(false);
            userAuthorityRepository.save(userAuthorityEntity);
        }
        return true;
    }
}
