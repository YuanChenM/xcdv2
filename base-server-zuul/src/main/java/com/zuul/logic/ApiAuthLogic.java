package com.zuul.logic;

import com.zuul.config.ApiKeyConfig;
import com.zuul.constant.ConstantDef;
import com.zuul.entity.InterfaceEntity;
import com.zuul.entity.ModuleEntity;
import com.zuul.entity.SecurityKeyEntity;
import com.zuul.entity.UserAuthorityEntity;
import com.zuul.repository.SecurityKeyRepository;
import com.zuul.repository.UserEntityRepository;
import com.zuul.util.Md5Digest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mao_yejun on 2017/2/23.
 */
@Service
public class ApiAuthLogic {
    private static Logger logger = LoggerFactory.getLogger(ApiAuthLogic.class);

    @Autowired
    private SecurityKeyRepository securityKeyRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private ApiKeyConfig apiKeyConfig;

    /**
     * 进行鉴权操作
     *
     * @param request
     * @return
     */
    public boolean doAuth(HttpServletRequest request) {
        String sign = request.getHeader("sign");
        String apiKey = request.getHeader("api_key");

        String securityKey = request.getHeader("security_key");
        String timestamp = request.getHeader("timestamp");
        logger.info("sign:" +sign +" api_key:"+apiKey+" security_key:"+securityKey + " timestamp"+timestamp );
        String uri = request.getRequestURI();
        //判断参数是否都存在
        if (StringUtils.isEmpty(sign) || StringUtils.isEmpty(apiKey)
                || StringUtils.isEmpty(securityKey) || StringUtils.isEmpty(timestamp)
                || StringUtils.isEmpty(uri)) {
            return false;
        }
        //判断是否为内部系统
        String innerKey = apiKeyConfig.getApiKey();
        String orSecurityKey;
        if (apiKey.equals(innerKey)) {
            orSecurityKey = apiKeyConfig.getSecurityKey();
            logger.info("~内部系统调用~");
            return checkTampered(sign, securityKey, timestamp, orSecurityKey);
        } else {
            //根据apiKey查询获得相关权限
            SecurityKeyEntity securityKeyEntity = securityKeyRepository.findSecurityKeyEntityByApiKeyAndDelFlg(apiKey, false);
            if (null == securityKeyEntity) {
                return false;
            } else {
                orSecurityKey = securityKeyEntity.getSecurityKey();
                //是否被篡改
                boolean isTampered = checkTampered(sign, securityKey, timestamp, orSecurityKey);
                if (!isTampered) {
                    logger.info("校验不通过！");
                    return false;
                }
                // 是否在有效时间内
                boolean isEffective = checkEffective(securityKeyEntity);
                if (!isEffective) {
                    return false;
                }
                boolean isAll = securityKeyEntity.getUserEntity().getAllFlg();
                if (isAll) {
                    logger.info("包含所有权限！");
                    return true;
                }
                //模块url是否合法
                List<UserAuthorityEntity> userAuthorityEntityList = securityKeyEntity.getUserEntity().getUserAuthority();
                boolean isModuleUrl = false;
                for (UserAuthorityEntity userAuthorityEntity : userAuthorityEntityList) {
                    InterfaceEntity interfaceEntity = userAuthorityEntity.getInterfaceEntity();
                    ModuleEntity moduleEntity = interfaceEntity.getModuleEntity();
                    String compareUri = "/" + moduleEntity.getModuleCode() + "/" + interfaceEntity.getInterfaceUrl();
                    compareUri= compareUri.replaceAll("//","/");
                    if (uri.equals(compareUri)) {
                        isModuleUrl = true;
                        break;
                    }
                }
                logger.info("请求地址"+uri+"没有权限！");
                return isModuleUrl;
            }
        }

    }

    /**
     * 校验是否在时效范围内
     *
     * @param securityKeyEntity
     * @return
     */
    public boolean checkEffective(SecurityKeyEntity securityKeyEntity) {
        Integer timelinessType = securityKeyEntity.getTimelinessType();
        Integer timeliness = securityKeyEntity.getTimeliness();
        Date loginTime = securityKeyEntity.getLoginTime();
        Calendar nowDate = Calendar.getInstance();
        boolean rs = false;
        switch (timelinessType) {
            case ConstantDef.TIMELINESSTYPE.PERMANENT:
                rs = true;
                break;
            case ConstantDef.TIMELINESSTYPE.YEAR:
                nowDate.add(Calendar.YEAR, timeliness);
                rs = nowDate.after(loginTime);
                break;
            case ConstantDef.TIMELINESSTYPE.MONTH:
                nowDate.add(Calendar.MONTH, timeliness);
                rs = nowDate.after(loginTime);
                break;
            case ConstantDef.TIMELINESSTYPE.DAY:
                nowDate.add(Calendar.DAY_OF_YEAR, timeliness);
                rs = nowDate.after(loginTime);
                break;
            case ConstantDef.TIMELINESSTYPE.HOUR:
                nowDate.add(Calendar.HOUR, timeliness);
                rs = nowDate.after(loginTime);
                break;
            case ConstantDef.TIMELINESSTYPE.MINUTE:
                nowDate.add(Calendar.MINUTE, timeliness);
                rs = nowDate.after(loginTime);
                break;
        }

        return rs;
    }

    /**
     * 校验是否被篡改
     *
     * @param sign
     * @param securityKey
     * @param timestamp
     * @param orSecurityKey
     * @return
     */
    public boolean checkTampered(String sign, String securityKey, String timestamp, String orSecurityKey) {

        StringBuffer security = new StringBuffer();
        security.append(sign).append(timestamp).append(orSecurityKey);
        String digested = Md5Digest.digest(security.toString());
        return securityKey.equals(digested);
    }
}
