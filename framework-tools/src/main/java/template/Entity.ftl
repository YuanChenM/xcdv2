/*
 * ${date} 自动生成 新规作成
 *
 * (c) 江苏润和
 */
package ${package};

import com.framework.base.entity.BaseEntity;

/**
 * <p>表${tableName}对应的实体${entityName}</p>
 *
 * @author 自动生成
 * @version 1.0.0
 */
public class ${entityName} extends BaseEntity {
    /** 序列号 */
    private static final long serialVersionUID = 1L;
<#list fieldList as field>
    /** ${field.comment} */
    private ${field.type} ${field.name};
</#list>

    /**
     * <p>默认构造函数</p>
     */
    public ${entityName}() {
    }

<#list fieldList as field>
    /**
     * <p>${field.comment}</p>
     *
     * @return ${field.comment}
     */
    public ${field.type} get${field.methodAppend}() {
        return ${field.name};
    }

    /**
     * <p>${field.comment}</p>
     *
     * @param ${field.name} ${field.comment}
     */
    public void set${field.methodAppend}(${field.type} ${field.name}) {
        this.${field.name} = ${field.name};
    }
</#list>

}
