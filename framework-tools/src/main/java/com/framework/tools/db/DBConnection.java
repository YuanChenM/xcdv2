package com.framework.tools.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.framework.tools.bean.DBTable;
import com.framework.tools.bean.TableColumn;
import com.framework.tools.utils.PropertyFileReader;

/**
 * DB连接类
 * @author yuan_chen
 */
public final class DBConnection {
	private static Properties property = null;
//	private static String SELECT_TABLE_COLUMN = "SELECT "
//												+"表名=CASE   WHEN   A.COLORDER=1   THEN   D.NAME   ELSE   ''   END, "
//												+"表说明=CASE   WHEN   A.COLORDER=1   THEN   ISNULL(F.VALUE,'')   ELSE   ''   END,"
//												+"字段序号=A.COLORDER, "
//												+"字段名=A.NAME, "
//												+"标识=CASE   WHEN   COLUMNPROPERTY(   A.ID,A.NAME,'ISIDENTITY')=1   THEN   '√'ELSE   ''   END, "
//												+"主键=CASE   WHEN   EXISTS(SELECT   1   FROM   SYSOBJECTS   WHERE   XTYPE='PK'   AND   NAME   IN   ( "
//												+"SELECT   NAME   FROM   SYSINDEXES   WHERE   INDID   IN( "
//												+"SELECT   INDID   FROM   SYSINDEXKEYS   WHERE   ID   =   A.ID   AND   COLID=A.COLID "
//												+" )))   THEN   '√'   ELSE   ''   END, "
//												+"类型=B.NAME, "
//												+"占用字节数=A.LENGTH, "
//												+"长度=COLUMNPROPERTY(A.ID,A.NAME,'PRECISION'), "
//												+"小数位数=ISNULL(COLUMNPROPERTY(A.ID,A.NAME,'SCALE'),0), "
//												+"允许空=CASE   WHEN   A.ISNULLABLE=1   THEN   '√'ELSE   ''   END, "
//												+"默认值=ISNULL(E.TEXT,''), "
//												+"字段说明=ISNULL(G.VALUE,'') "
//												+"FROM   SYSCOLUMNS   A "
//												+"LEFT   JOIN   SYSTYPES   B   ON   A.XUSERTYPE=B.XUSERTYPE "
//												+"INNER   JOIN   SYSOBJECTS   D   ON   A.ID=D.ID     AND   D.XTYPE='U'   AND     D.NAME<>'DTPROPERTIES' "
//												+"LEFT   JOIN   SYSCOMMENTS   E   ON   A.CDEFAULT=E.ID "
//												+"LEFT   JOIN   SYS.EXTENDED_PROPERTIES   G   ON   A.ID=G.MAJOR_ID   AND   A.COLID=G.MINOR_ID "
//												+"LEFT   JOIN   SYS.EXTENDED_PROPERTIES   F   ON   D.ID=F.MAJOR_ID   AND   F.MINOR_ID=0 "
//												+"WHERE   D.NAME=? "
//												+"ORDER   BY   A.ID,A.COLORDER";

	static {
		if (null == property) {
			property = PropertyFileReader.getProperties("config.jdbc");
		}
		try {
			DriverManager.registerDriver((Driver) Class.forName(
					property.getProperty("jdbc.driver").trim()).newInstance());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
				property.getProperty("jdbc.url"),
				property.getProperty("jdbc.username"),
				property.getProperty("jdbc.password"));
		return conn;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void closePreparedStatement(PreparedStatement pstam) {
		try {
			pstam.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<String> getTableNames() {
		List<String> tableList = new ArrayList<String>();
		String sql = "select TABLE_NAME from information_schema.tables "
				+ "where TABLE_SCHEMA = '"
				+ property.getProperty("jdbc.database")
				+ "';";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String tableName = resultSet.getString("TABLE_NAME");
				System.out.println(tableName);
				tableList.add(tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
		return tableList;
	}

	public static DBTable getTableColumns(String tableName) {
		DBTable dbTable = new DBTable();
		dbTable.setTableName(tableName);
		Connection connection = null;
		PreparedStatement pstam = null;
		ResultSet resultSet = null;
		String comment = null;
		String SELECT_TABLE_COLUMN =" select * "
	            + " from information_schema.columns "
	            + " where TABLE_NAME = ? "
	            + " and TABLE_SCHEMA = '"
	            + property.getProperty("jdbc.database")
	            + "';";
		System.out.println(SELECT_TABLE_COLUMN);
		try {
			connection = getConnection();
			pstam = connection.prepareStatement(SELECT_TABLE_COLUMN);
			pstam.setString(1, tableName);
			resultSet = pstam.executeQuery();
			List<TableColumn> tableColumnList = new ArrayList<TableColumn>();
			while (resultSet.next()) {
				TableColumn column = new TableColumn();
				dbTable.setTableDescription(resultSet.getString("TABLE_NAME"));
				column.setColumnName(resultSet.getString("COLUMN_NAME"));
				String identity = resultSet.getString("EXTRA");
				if("".equals(identity)){
					column.setIdentity(false);
				}else{
					column.setIdentity(true);
				}
				String pk = resultSet.getString("COLUMN_KEY");
				if("".equals(pk)){
					column.setPk(false);
				}else{
					column.setPk(true);
				}
				String dataType = resultSet.getString("DATA_TYPE");
				column.setDataType(dataType);
				comment = resultSet.getString("COLUMN_COMMENT");
				
				if (comment == null || comment == "")
					column.setColumnDescription(resultSet.getString("COLUMN_NAME"));
				else
					column.setColumnDescription(comment);
				
				column.setDefaultValue(resultSet.getString("COLUMN_DEFAULT"));
				tableColumnList.add(column);
			}
			dbTable.setTableColumnList(tableColumnList);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(resultSet);
			closePreparedStatement(pstam);
			closeConnection(connection);
		}
		return dbTable;
	}

}
