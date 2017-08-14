package com.framework.core.file.xml.jaxb.template;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * @author liu_tao2
 * @version 1.0
 * @param <T> 文件对象的实体对象
 */
@XmlRootElement(name="DATACOLLECTION")
public interface XmlTemplate<T> extends Serializable{
    @XmlElement(name = "DATA")
    public List<T> getData();
}
