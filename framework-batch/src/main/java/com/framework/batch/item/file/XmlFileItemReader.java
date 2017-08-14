package com.framework.batch.item.file;

import org.springframework.batch.item.xml.StaxEventItemReader;

/**
 * <p>XML文件的读接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class XmlFileItemReader<I> extends StaxEventItemReader<I> {

}
