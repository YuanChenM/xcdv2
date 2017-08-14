package com.framework.core.file.xml;

/**
 *
 * @param <P> 输入参数
 * @param <O> 返回参数
 * @see com.framework.core.file.xml.jaxb.JaxbXmlWrite
 *
 */
public interface XmlWrite<P,O> {

    /**
     * 创建XML
     * @param param 创建XML需要的参数
     * @return XML,根据不同的创建XML类型会返回不同的类型
     */
    O createXml(P param);
}
