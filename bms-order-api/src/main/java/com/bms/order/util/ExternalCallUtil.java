package com.bms.order.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.framework.exception.BusinessException;

/**
 * Created by zhang_qiang1 on 2017/1/7.
 */
public class ExternalCallUtil {
    /**
     * 外部调用 实体  设置参数使用
     *
     * @param childrenNum
     * @return
     */

    public static Serializable setEntityParam(Class entityClass, int childrenNum) {
        Serializable entity = null;
        try {
            throwException(entityClass, 1);
            entity = (Serializable) entityClass.newInstance();
            Method[] methods = entityClass.getMethods();
            int random = new Random().nextInt(100) + 1;
            for (Method method : methods) {
                String methodName = method.getName();
                String name = methodName.substring(3);
                if (!methodName.startsWith("set"))
                    continue;
                Class<?> paramType = method.getParameterTypes()[0];
                String packageName = paramType.getPackage().getName();
                if (paramType == String.class) {
                    String content = random + "";
                    if (!(methodName.endsWith("Type") || methodName.endsWith("Code"))) {
                        content = name + content;
                    }
                    if (methodName.endsWith("Level")) {
                        content = String.valueOf(new Random().nextInt(10) + 1);
                        if (content.length() > 1)
                            content = "9";
                    }
                    if (methodName.endsWith("Name")) {
                        content = methodName.substring(3, 6) + random;
                    }
                    method.invoke(entity, content);
                } else if (paramType == Long.class) {
                    method.invoke(entity, Long.valueOf(random));
                } else if (paramType == Integer.class) {
                    method.invoke(entity, random);
                } else if (paramType == BigDecimal.class) {
                    method.invoke(entity, new BigDecimal(random));
                } else if (packageName.contains("externalCall") && packageName.contains("entity")) {
                    Serializable singleEntity = setEntityParam(paramType, childrenNum);
                    method.invoke(entity, singleEntity);
                } else if (paramType == List.class) {
                    ArrayList arrayList = (ArrayList) Class.forName("java.util.ArrayList").newInstance();
                    String childClassName = getChildClassName(entityClass,name);
                    for (int index = 0; index < childrenNum; index++) {
                        Class childClass = Class.forName(childClassName);
                        throwException(childClass, 2);
                        Serializable serializable = setEntityParam(childClass, childrenNum);
                        arrayList.add(serializable);
                    }
                    method.invoke(entity, arrayList);
                } else if (paramType == Boolean.class) {
                    String value = (random % 2 == 0) ? "false" : "true";
                    method.invoke(entity, Boolean.getBoolean(value));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }


    /**
     *  获取List 集合中的泛型值类型
     *  paramType  参数
     * @param entityClass
     * @return
     */
    private static String getChildClassName(Class entityClass,String  name) {
        String childClassName = null;
      int index=  name.indexOf("List");
        name=name.substring(0,index);
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            Type t = field.getGenericType();
            if (field.getName().toLowerCase().contains(name.toLowerCase())
                    && ParameterizedType.class.isAssignableFrom(t.getClass())) {
                for (Type t1 : ((ParameterizedType) t).getActualTypeArguments()) {
                    childClassName = t1.toString().substring(6);
                    break;
                }
            }
        }
        return childClassName;
    }

    /**
     * 验证 实体 是否实现 Serializable
     *
     * @param cla
     * @param type
     */
    private static void throwException(Class cla, int type) {
        String msg = null;
        if (type == 1) {
            msg = "List中的类 没有实现Serializable 接口";
        } else if (type == 2) {
            msg = "该类没有实现Serializable 接口";
        }
        if (!Serializable.class.isAssignableFrom(cla)) {
            throw new BusinessException("ORDR", msg);
        }
    }
}
