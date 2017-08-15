package com.bms.order.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.bms.order.archive.Linkable;
import com.framework.exception.BusinessException;

/**
 * 关联助手。
 * <p>
 * 关联字段的源字段与目标字段存在空值时，可以关联（对应新增数据）； 源字段与目标字段在非空的情况下一致时，源对象与目标对象才可以关联。
 * <p>
 * 当两个对象可以关联，但检查字段的源字段与目标字段不一致时，将会在日志中记录警告。
 * 
 * @author li_huiqian
 *
 */
public class LinkHelper {

    /**
     * 源对象
     */
    private Linkable source;

    /**
     * 目标对象
     */
    private Linkable target;

    /**
     * 关联字段
     */
    private List<LinkedField> linkedFields;

    /**
     * 检查字段
     */
    private List<LinkedField> matchFields;

    /**
     * 关联两个对象，关联的关系是<code>source.linkedField=target.linkedField</code>
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param linkedField
     *            关联字段
     */
    public static void link(Linkable source, Linkable target, String linkedField) {
        LinkHelper helper = new LinkHelper(source, target, linkedField);
        helper.link();
    }

    /**
     * 关联两个对象，关联的关系是<code>source.sourceField=target.targetField</code>
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param sourceField
     *            源关联字段
     * @param targetField
     *            目标关联字段
     */
    public static void link(Linkable source, Linkable target, String sourceField, String targetField) {
        LinkHelper helper = new LinkHelper(source, target, sourceField, targetField);
        helper.link();
    }

    /**
     * 关联两个对象，并检查对应字段是否一致
     * 
     * @param source
     * @param target
     * @param linkedFields
     * @param checkedFields
     */
    public static void link(Linkable source, Linkable target, List<LinkedField> linkedFields,
            List<LinkedField> checkedFields) {

    }

    public static void link(Linkable source, List<?> targets, String linkedField) {
        for (Object target : targets) {
            link((Linkable) source, (Linkable) target, linkedField);
        }
    }

    public static void link(List<?> sources, List<?> targets, String linkedField) {
        for (Object source : sources) {
            for (Object target : targets) {
                link((Linkable) source, (Linkable) target, linkedField);
            }
        }
    }

    public static void link(List<?> sources, Linkable target, String linkedField) {
        for (Object source : sources) {
            link((Linkable) source, target, linkedField);
        }
    }

    /**
     * 构造函数
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param sourceField
     *            源对象关联字段 目标对象关联字段
     */
    private LinkHelper(Linkable source, Linkable target, String linkedField) {
        this.source = source;
        this.target = target;
        this.linkedFields = new ArrayList<>();
        this.linkedFields.add(new LinkedField(linkedField));
    }

    /**
     * 构造函数
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param sourceField
     *            源对象关联字段
     * @param targetField
     *            目标字段关联对象
     */
    private LinkHelper(Linkable source, Linkable target, String sourceField, String targetField) {
        this.source = source;
        this.target = target;
        this.linkedFields = new ArrayList<>();
        this.linkedFields.add(new LinkedField(sourceField, targetField));
    }

    /**
     * 构造函数
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param linkedFields
     *            关联字段
     */
    private LinkHelper(Linkable source, Linkable target, List<LinkedField> linkedFields) {
        this.source = source;
        this.target = target;
        this.linkedFields = linkedFields;
    }

    /**
     * 构造函数
     * 
     * @param source
     *            源对象
     * @param target
     *            目标对象
     * @param linkedFields
     *            关联字段
     * @param checkedFields
     *            检查字段
     */
    private LinkHelper(Linkable source, Linkable target, List<LinkedField> linkedFields,
            List<LinkedField> checkedFields) {
        this.source = source;
        this.target = target;
        this.linkedFields = linkedFields;
        this.matchFields = checkedFields;
    }

    /**
     * 关联
     */
    private void link() {
        // 不可关联的情况
        if (source == null || target == null)
            return;
        if (linkedFields == null || linkedFields.size() == 0)
            return;
        for (LinkedField linkedField : linkedFields) {
            if (!linkedField.valid())
                return;
        }

        // 检查是否可以关联
        for (LinkedField linkedField : linkedFields) {
            String sourceField = linkedField.getSourceField();
            String targetField = linkedField.getTargetField();
            Object sourceValue = getValue(source, sourceField);
            Object targetValue = getValue(target, targetField);

            if (!(sourceValue == null && targetValue == null)
                    && !(sourceValue != null && sourceValue.equals(targetValue))) {
                return;
            }
        }

        // 关联
        boolean l1 = link(source, target);
        boolean l2 = link(target, source);
        if (!l1 && !l2)
            return;

        // 检验
        if (matchFields == null)
            return;
        for (LinkedField linkedField : matchFields) {
            String sourceField = linkedField.getSourceField();
            String targetField = linkedField.getTargetField();
            Object sourceValue = getValue(source, sourceField);
            Object targetValue = getValue(target, targetField);

            boolean match = (sourceValue == null && targetField == null)
                    || (sourceValue != null && sourceValue.equals(targetValue));
            if (!match) {
                System.err.println(this.source.getClass().getName() + "." + sourceField + " = " + sourceValue);
                System.err.println(this.target.getClass().getName() + "." + targetField + " = " + targetValue);
                throw new BusinessException("", "");// TODO 国际化
            }
        }
    }

    /**
     * 通过反射，获取字段值
     * 
     * @param object
     * @param field
     * @return
     */
    private Object getValue(Object object, String fieldName) {
        if (object == null || fieldName == null)
            return null;

        String[] split = fieldName.split("\\.");
        try {
            Field field = object.getClass().getDeclaredField(split[0]);
            field.setAccessible(true);
            Object value = field.get(object);
            if (split.length > 1)
                return getValue(value, fieldName.substring(fieldName.indexOf(".") + 1));
            else
                return value;
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            return null;
        }
    }

    /**
     * 关联两个对象 source <- target
     * 
     * @return
     */
    private boolean link(Linkable source, Linkable target) {
        // Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field targetInSource = null;
        Field targetListInSource = null;

        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field sourceField : sourceFields) {
            if (sourceField.getType() == targetClass) {
                targetInSource = sourceField;
                break;
            }
            if (sourceField.getType() == List.class || sourceField.getType() == ArrayList.class) {
                if (((ParameterizedType) sourceField.getGenericType()).getActualTypeArguments()[0] == targetClass) {
                    targetListInSource = sourceField;
                    break;
                }
            }
        }

        if (targetInSource != null) {
            try {
                targetInSource.setAccessible(true);
                Object value = targetInSource.get(source);
                if (value == null) {
                    value = target;
                    targetInSource.set(source, value);
                    return true;
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else if (targetListInSource != null) {
            try {
                targetListInSource.setAccessible(true);
                @SuppressWarnings("unchecked")
                List<Linkable> list = (List<Linkable>) targetListInSource.get(source);
                if (list == null) {
                    list = new ArrayList<>();
                }
                if (!list.contains(target)) {
                    list.add(target);
                    targetListInSource.set(source, list);
                    return true;
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 关联字段组
     * 
     * @author li_huiqian
     *
     */
    public static class LinkedField {

        /**
         * 源字段
         */
        private String sourceField;

        /**
         * 目标字段
         */
        private String targetField;

        /**
         * 构造函数。
         * 
         * @param sourceField
         *            源字段
         * @param targetField
         *            目标字段
         */
        public LinkedField(String sourceField, String targetField) {
            this.sourceField = sourceField;
            this.targetField = targetField;
        }

        /**
         * 检验是否合法（sourceField与targetField非空）
         * 
         * @return
         */
        public boolean valid() {
            if (this.sourceField == null || this.sourceField.trim().equals(""))
                return false;
            if (this.targetField == null || this.targetField.trim().equals(""))
                return false;
            return true;
        }

        /**
         * 构造函数，源字段与目标字段同名
         * 
         * @param field
         *            源字段、目标字段字段名
         */
        public LinkedField(String field) {
            this.sourceField = field;
            this.targetField = field;
        }

        public String getSourceField() {
            return sourceField;
        }

        public void setSourceField(String sourceField) {
            this.sourceField = sourceField;
        }

        public String getTargetField() {
            return targetField;
        }

        public void setTargetField(String targetField) {
            this.targetField = targetField;
        }

    }

}
