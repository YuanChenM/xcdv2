package com.msk.comm.tag;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.TypeReference;
import com.msk.comm.bean.DictLeafNodeBean;
import com.msk.comm.bean.DictNodeBean;
import com.msk.comm.bean.FindNodeParam;
import com.msk.comm.utils.ConfigInfo;
import com.msk.comm.utils.RestNewClientUtil;

/**
 * CodeMasterTag
 **/
public class CodeMasterTag extends SimpleTagSupport implements DynamicAttributes {
    private static String VIEW_TYPE_SELECT = "select";
    /** 输出类型：label,select，json */
    private String viewType;
    /** code master的code type */
    private String codeType;
    /** code master的code value */
    private String codeValue;
    /** label和select标签使用的时候的ID */
    private String id;
    /** label和select标签使用的时候的name */
    private String name;
    /** select标签使用的时候第一个option **/
    private String emptyText;
    /** 自定义属性 */
    private Map<String, Object> attrMap;
    /** 校验规则 **/
    private String validate;
    /** 数据字典的根节点、父节点 **/
    private static String DIC_CODE = "CodeMaster";
    // 浏览器语言
    private static String LANGUAGE = "Accept-Language";
    // 中文
    private static String ZH_CN = "zh";

    protected HttpServletRequest getRequest() {
        PageContext pageContext = (PageContext) this.getJspContext();
        return (HttpServletRequest) pageContext.getRequest();
    }

    @Override
    public void doTag() throws JspException, IOException {
        String language = this.getRequest().getHeader(LANGUAGE);
        String[] languageArr = {ZH_CN};
        if (null != language) {
            languageArr = language.split("\\,");
        }
        Map<String, Object> tempMap = new LinkedHashMap<>();
        getDictInfo(tempMap);
        StringBuffer html = new StringBuffer();
        if (VIEW_TYPE_SELECT.equalsIgnoreCase(viewType)) {
            html.append(this.createCodeMasterSelect(tempMap, languageArr[0]));
        }
        JspWriter out = this.getJspContext().getOut();
        out.write(html.toString());
    }

    /**
     * 获取数据字典rest接口数据
     * 
     * @param tempMap
     *
     */
    private void getDictInfo(Map<String, Object> tempMap) {
        FindNodeParam param = new FindNodeParam();
        param.setDictCode(this.codeType);
        param.setRootCode(DIC_CODE);
        param.setDetail(true);
        String DICT_REST_URL = ConfigInfo.newConfigInfo().getZuul() + ConfigInfo.newConfigInfo().getDictApi();
        DictLeafNodeBean dictionList = RestNewClientUtil.post(DICT_REST_URL, param,
            new TypeReference<DictLeafNodeBean>() {});
        List<DictNodeBean> tempList = new ArrayList<>();
        if (null != dictionList) {
            tempList.addAll(dictionList.getValues());
        }
        if (!CollectionUtils.isEmpty(tempList)) {
            // 自定义排序
            Collections.sort(tempList, new Comparator<DictNodeBean>() {
                @Override
                public int compare(DictNodeBean o1, DictNodeBean o2) {
                    return o1.getDataValue().compareTo(o2.getDataValue());
                }
            });
            // 构造
            tempMap.put(this.codeType, tempList);
        }
    }

    private String createCodeMasterSelect(Map<String, Object> cacheMap, String language) {
        StringBuffer selectHtml = new StringBuffer();
        selectHtml.append("<select  class='form-control selectpicker'  ");
        if (StringUtils.isNotEmpty(this.id)) {
            selectHtml.append("  id=\"" + this.id + "\"");
        }
        if (StringUtils.isNotEmpty(this.name)) {
            selectHtml.append("  name=\"" + this.name + "\"");
        }
        if (StringUtils.isNotEmpty(this.validate)) {
            selectHtml.append("  validate=\"" + this.validate + "\"");
        }
        if (!CollectionUtils.isEmpty(this.attrMap)) {
            for (Map.Entry<String, Object> entry : this.attrMap.entrySet()) {
                selectHtml.append(" " + entry.getKey() + " ='" + entry.getValue() + "' ");
            }
        }
        selectHtml.append(" >");
        if (null != this.emptyText) {
            selectHtml.append("<option value=''>" + this.emptyText + "</option>");
        }
        if (!CollectionUtils.isEmpty(cacheMap)) {
            for (Object object : (List) cacheMap.get(this.codeType)) {
                DictNodeBean cacheBean = (DictNodeBean) object;
                if (cacheBean.getDataValue().equals(this.codeValue)) {
                    if (language.startsWith(ZH_CN)) {
                        selectHtml.append("<option value='" + cacheBean.getDataValue() + "' selected>"
                                + cacheBean.getDataCN() + "</option>");
                    } else {
                        selectHtml.append("<option value='" + cacheBean.getDataValue() + "' selected>"
                                + cacheBean.getDataEN() + "</option>");
                    }
                } else {
                    if (language.startsWith(ZH_CN)) {
                        selectHtml.append(
                            "<option value='" + cacheBean.getDataValue() + "'>" + cacheBean.getDataCN() + "</option>");
                    } else {
                        selectHtml.append(
                            "<option value='" + cacheBean.getDataValue() + "'>" + cacheBean.getDataEN() + "</option>");
                    }
                }
            }
        }
        selectHtml.append("</select>");

        return selectHtml.toString();
    }

    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        if (attrMap == null) {
            attrMap = new HashMap<String, Object>();
        }
        attrMap.put(localName, value);
    }

    /**
     * 获取viewType
     *
     * @return viewType viewType
     */
    public String getViewType() {
        return viewType;
    }

    /**
     * 设置viewType
     *
     * @param viewType viewType
     */
    public void setViewType(String viewType) {
        this.viewType = viewType;
    }

    /**
     * 获取codeType
     *
     * @return codeType codeType
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置codeType
     *
     * @param codeType codeType
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取codeValue
     *
     * @return codeValue codeValue
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置codeValue
     *
     * @param codeValue codeValue
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * 获取id
     *
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取name
     *
     * @return name name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getEmptyText() {
        return emptyText;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
}
