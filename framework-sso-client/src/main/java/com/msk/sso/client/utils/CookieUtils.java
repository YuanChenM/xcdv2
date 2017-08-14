package com.msk.sso.client.utils;

import com.msk.sso.client.excption.SystemException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Cookie Utils.
 * 
 * @author jiang_nan
 * @version 1.0
 **/
public class CookieUtils {
    /**
     * 设置Cookie Value
     * 
     * @param response Response
     * @param key Cookie Key
     * @param value Cookie Value.
     */
    public static void setCookieValue(HttpServletResponse response, String key, String value) throws UnsupportedEncodingException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
        cookie.setMaxAge(30 * 24 * 60 * 60); // TODO 暂时cookie有效期为1个月
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获得Cookie对应的Value
     * 
     * @param request Http Servlet Request
     * @param key Cookie Key
     * @return Value
     */
    public static String getCookieValue(HttpServletRequest request, String key) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(key)) {
            throw new SystemException("Cookie对应的Key不能为空");
        }
        Cookie[] cookies = request.getCookies();// 这样便可以获取一个cookie数组
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (key.equals(name)) {
                    return URLDecoder.decode(cookie.getValue(),"UTF-8");
                }
            }
        }
        // throw new SystemException("没有找到cookie对于的Value");
        return null;
    }

    /**
     * 清除cookie
     * 
     * @param req
     * @param res
     * @param name
     */
    public static void removeCookie(HttpServletRequest req, HttpServletResponse res, String name) {
        Cookie cookie = get(req, name);
        if (null != cookie) {
            // 对应chrome，删除cookie要将request中的cookie也设空
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            res.addCookie(cookie);
        } else {
            cookie = new Cookie(name, null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            res.addCookie(cookie);
        }
    }

    // /**
    // * 获取cookie的值
    // *
    // * @param req
    // * @param name
    // * @return
    // */
    // private static String getName(HttpServletRequest req, String name) {
    // Cookie cookie = get(req, name);
    // String cookieVal = (null == cookie) ? null : cookie.getValue();
    // return cookieVal;
    // }

    /**
     *
     * @param req
     * @param name
     * @return
     */
    private static Cookie get(HttpServletRequest req, String name) {
        Map<String, Cookie> cookieMap = _readCookieMap(req);
        if (cookieMap.containsKey(name)) {
            return cookieMap.get(name);
        } else {
            return null;
        }
    }

    /**
     * 
     * @param req
     * @return
     */
    private static Map<String, Cookie> _readCookieMap(HttpServletRequest req) {
        Map<String, Cookie> cookieMap = new HashMap<>();
        Cookie[] cookies = req.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

}
