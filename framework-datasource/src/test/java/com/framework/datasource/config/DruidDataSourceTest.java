package com.framework.datasource.config;

import com.framework.datasource.bean.DataSourceProperties;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * Created by shi_yuxi on 2016/10/21.
 */
public class DruidDataSourceTest {
    @Test
    public void testConfigFromDataSourceProperties() throws SQLException {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://10.68.1.2:3306/oms_como-v2-dev?allowMultiQueries=true");
        dataSourceProperties.setUserName("root");
        dataSourceProperties.setPassword("Oms123@Mysql");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.configFromDataSourceProperties(dataSourceProperties);

        Statement callableStatement = druidDataSource.getConnection().createStatement();
        ResultSet rs=callableStatement.executeQuery("select 1");
        while(rs.next())
        Assert.assertEquals("success",rs.getString(1),"1");
    }
}
