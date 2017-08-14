package com.bms.linv.rest;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.framework.aop.boot.dynamic.datasource.DatabaseContextHolder;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by 健 on 2017/6/5.
 */
@RestController
@Api(description = "商品库存调整*",
    tags = "LINV9999IRestController",
    value = "LINV9999IRestController")
public class LINV9999IRestController {

    @Autowired
    @Qualifier(DatabaseContextHolder.MASTER_DATA_SOURCE)
    DataSource dataSource;

    @ApiOperation(value = "商品库存调整1",
        notes = "商品库存调整1")
    @RequestMapping(value = "/linv/comoInv/_execQuery",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public String execQuery(@RequestBody String param) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        JSONArray array = new JSONArray();
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(param);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 1; i <= columns; i++) {
                    String columnName = resultSetMetaData.getColumnLabel(i);
                    String value = rs.getString(columnName);
                    jsonObject.put(columnName, value);
                }
                array.add(jsonObject);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return array.toString();
    }

    @ApiOperation(value = "商品库存调整2",
        notes = "商品库存调整2")
    @RequestMapping(value = "/linv/comoInv/_execDML",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public int execDML(@RequestBody String param) throws Exception {
        String sql = param != null ? param.toUpperCase() : "";
        String[] checkSQL = sql.split(";");
        for (String check : checkSQL) {
            if (!check.startsWith("INSERT") && check.indexOf("WHERE") == -1) {
                throw new Exception("Missing where condition");
            }
        }
        int flag = 0;
        Connection conn = null;
        Statement st = null;
        try {
            conn = dataSource.getConnection();
            st = conn.createStatement();
            flag = st.executeUpdate(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

}
