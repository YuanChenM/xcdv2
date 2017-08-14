package com.framework.resource.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhang_jian3 on 2016/11/18.
 */
public class EntityUtil {

    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static Map<String, Object> entityToMap(Object entity) {
        Map<String, Object> map = new HashMap<>();
        if (null != entity) {
            try {
                Class c1 = entity.getClass();
                Method[] methods = c1.getMethods();
                Object[] args = new Object[] {};
                Object o1;
                for (Method method : methods) {
                    if ((method.getName().startsWith("get") || method.getName().startsWith("is"))
                            && !"getClass".equals(method.getName()) && !"getShowField".equals(method.getName())
                            && !"getSort".equals(method.getName()) && !"getPagination".equals(method.getName())) {
                        o1 = method.invoke(entity, args);
                        if (o1 != null && !"".equals(o1))
                            map.put(toLowerCaseFirstOne(method.getName().replaceFirst("get", "")), o1);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}
