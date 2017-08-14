package com.framework.core.file.xml.jaxb;

import com.framework.core.file.xml.XmlWrite;
import com.framework.core.file.xml.jaxb.template.XmlTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Jaxb方式创建的XML文件流
 *
 * @param <T> 实体对象
 * @author liu_tao2
 * @version 1.0
 */
public class JaxbXmlWrite<T extends Serializable> implements XmlWrite<Class<T>, InputStream> {
    /**
     * Logger
     */
    private static Logger logger = LoggerFactory.getLogger(JaxbXmlWrite.class);

    /**
     * XML文件对象的实体对象
     */
    private XmlTemplate xmlTemplate;

    /**
     * 构造函数
     *
     * @param xmlTemplate XML Template对象
     */
    public JaxbXmlWrite(XmlTemplate xmlTemplate) {
        this.xmlTemplate = xmlTemplate;
    }

    @Override
    public InputStream createXml(Class<T> templateClass) {
        String xml = this.createXmlString(templateClass);
        logger.info("输出XML:" + xml);
        return new ByteArrayInputStream(xml.getBytes());
    }

    /**
     * 根据Template Class和Template生成XML字符串
     *
     * @param templateClass Template Class
     * @return XML 字符串
     */
    private String createXmlString(Class<T> templateClass) {
        String xml = null;
        StringWriter writer = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(templateClass);
            Marshaller ms = jc.createMarshaller();
            ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ms.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            writer = new StringWriter();
            ms.marshal(this.xmlTemplate, writer);
            xml = writer.toString();
        } catch (JAXBException e) {
            logger.error(e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return xml;
    }

}
