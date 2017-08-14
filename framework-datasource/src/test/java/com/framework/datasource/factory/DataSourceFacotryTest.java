package com.framework.datasource.factory;

import com.framework.datasource.bean.DataSourceProperties;
import com.framework.datasource.bean.SimpleDataSourceProperties;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by shi_yuxi on 2016/10/21.
 */
public class DataSourceFacotryTest {

    @Test
    public void createDataSource() throws SQLException {
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://10.68.1.2:3306/oms_como-v2-dev?allowMultiQueries=true");
        dataSourceProperties.setUserName("root");
        dataSourceProperties.setPassword("Oms123@Mysql");
        DataSource dataSource = DataSourceFacotry.createDataSource(dataSourceProperties);
        Statement callableStatement = dataSource.getConnection().createStatement();
        ResultSet rs=callableStatement.executeQuery("select 1");
        while(rs.next())
            Assert.assertEquals("success",rs.getString(1),"1");
    }

    @Test
    public void createDataSourceSimple() throws SQLException {
        SimpleDataSourceProperties dataSourceProperties = new SimpleDataSourceProperties();
        dataSourceProperties.setUrl("jdbc:mysql://10.68.1.2:3306/oms_como-v2-dev?allowMultiQueries=true");
        dataSourceProperties.setUserName("root");
        dataSourceProperties.setPassword("Oms123@Mysql");
        DataSource dataSource = DataSourceFacotry.createDataSource(dataSourceProperties);
        Statement callableStatement = dataSource.getConnection().createStatement();
        ResultSet rs=callableStatement.executeQuery("select 1");
        while(rs.next())
            Assert.assertEquals("success",rs.getString(1),"1");
    }
}
