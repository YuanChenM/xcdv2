package com.framework.mybatis.factory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.io.Reader;

/**
 * @Author zhou_yajun.
 * @Version 1.0
 */
public class MyBatisSqlSessionFactory {
    /**
     * mybatis<br/>
     * Demo:<br/>
     * MyBatisSqlSessionFactory myBatisSqlSessionFactory = new MyBatisSqlSessionFactory();<br/>
     * String resource = "MyBatis-Config.xml";<br/>
     * Reader reader = Resources.getResourceAsReader(resource);<br/>
     * SqlSessionFactory sqlSessionFactory = myBatisSqlSessionFactory.sqlSessionFactory(reader);<br/>
     * @param reader
     * @return
     */
    public SqlSessionFactory sqlSessionFactory(Reader reader) {
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(reader);
        return sqlSessionFactory;
    }
    /**
     * mybatis<br/>
     * Demo:<br/>
     * MyBatisSqlSessionFactory myBatisSqlSessionFactory = new MyBatisSqlSessionFactory();<br/>
     * String resource = "MyBatis-Config.xml";<br/>
     * InputStream in = Resources.getResourceAsStream(resource);<br/>
     * SqlSessionFactory sqlSessionFactory = myBatisSqlSessionFactory.sqlSessionFactory(in);<br/>
     * @param inputStream
     * @return
     */
    public SqlSessionFactory sqlSessionFactory(InputStream inputStream){
        SqlSessionFactory sqlSessionFactory = (new SqlSessionFactoryBuilder()).build(inputStream);
        return sqlSessionFactory;
    }
}
