package com.framework.tools.logic;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.tools.bean.DBTable;
import com.framework.tools.bean.TableColumn;
import com.framework.tools.utils.CommonUtils;
import com.framework.tools.utils.FileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * SqlMapGenerator
 * 
 * @author yuan_chen
 */
public class SqlMapGenerator {
	public static String PK_TYPE = null;

	public static void genaratorSqlMap(Configuration cfg, DBTable dbTable) throws TemplateException, IOException {
		PK_TYPE = null;
		String tableName = dbTable.getTableName();
		List<TableColumn> columnList = dbTable.getTableColumnList();
		String path = CommonUtils.getSqlMapOutPutPath("mapper") + "/" + getSqlMapName(tableName);
		FileUtils.mkdir(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("servicePackage", CommonUtils.getServicePackage(tableName));
			paramMap.put("selectColumns", getSelectTableColumn(columnList));
			paramMap.put("selectConditions", getSelectConditions());
			paramMap.put("entityPackage", CommonUtils.getEntityPackage());
			paramMap.put("entityName", CommonUtils.getOutputColumnName(tableName, true));
			paramMap.put("tableName", tableName);
			paramMap.put("insertColumns", getInsertSql(columnList));
			paramMap.put("insertValues", getInsertValueSql(columnList));
			paramMap.put("updateColumns", getUpdateSet(columnList));
			paramMap.put("updateCondtions", getUpdateCondtion(columnList));
			paramMap.put("daoPackage", CommonUtils.getDaoPackage(tableName));
			System.out.println(isValid(columnList));
			paramMap.put("isValid", isValid(columnList));
			paramMap.put("aaa", "#{isValid}");

			Template tpl = cfg.getTemplate("SqlMap.ftl");
			tpl.setEncoding("UTF-8");
			tpl.process(paramMap, writer);
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}

	public static boolean isValid(List<TableColumn> columnList) {
		for (TableColumn column : columnList) {
			if ("isValid".equalsIgnoreCase(column.getColumnName())) {
				return true;
			}
		}
		return false;
	}

	public static String getPage(List<TableColumn> columnList) {
		StringBuffer pageSql = new StringBuffer("order by ");
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if (!tableColumn.isIdentity() && !tableColumn.isPk()) {
				continue;
			}
			String columnName = tableColumn.getColumnName();
			pageSql.append("\n");
			pageSql.append("            ");
			pageSql.append(columnName);
		}
		pageSql.append("\n");
		pageSql.append("            ");
		pageSql.append(" OFFSET #{startPos} row fetch next #{pageSize} row only");
		return pageSql.toString();
	}

	public static String getUpdateCondtion(List<TableColumn> columnList) {
		StringBuffer updateCondtionSql = new StringBuffer();
		int columnLength = columnList.size();
		boolean flag = false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if (!tableColumn.isIdentity() && !tableColumn.isPk()) {
				continue;
			}
			if (tableColumn.isPk()) {
				PK_TYPE = tableColumn.getDataType();
			}

			String columnName = tableColumn.getColumnName();
			if (flag) {
				updateCondtionSql.append("\t\tAND ");
			}
			else {
				updateCondtionSql.append("\t\t\t");
			}
			updateCondtionSql.append(columnName + " = " + "#{" + CommonUtils.getOutputColumnName(columnName, false) + "}\n");
			flag = true;
		}

		if (updateCondtionSql.toString().contains("\n")) {
			return updateCondtionSql.substring(0, updateCondtionSql.lastIndexOf("\n"));
		}
		return updateCondtionSql.toString();
	}

	public static String getUpdateSet(List<TableColumn> columnList) {
		StringBuffer updateSetSql = new StringBuffer();
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if (tableColumn.isIdentity() || tableColumn.isPk()) {
				continue;
			}
			String columnName = tableColumn.getColumnName();
			updateSetSql.append("\t\t\t");
			updateSetSql.append(columnName + " = " + "#{" + CommonUtils.getOutputColumnName(columnName, false) + "}");
			if (i < columnLength - 1) {
				updateSetSql.append(",");
				updateSetSql.append("\n");
			}
		}
		return updateSetSql.toString();
	}

	public static String getInsertValueSql(List<TableColumn> columnList) {
		StringBuffer insertSql = new StringBuffer();
		int columnLength = columnList.size();
		TableColumn preTableColumn = null;
		boolean flg = false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if (tableColumn.isIdentity()) {
				continue;
			}
			String columnName = tableColumn.getColumnName();
			if (0 < insertSql.length()) {
				if (flg) {
					insertSql.append("\n");
				}
				if ("".equals(preTableColumn.getDefaultValue())) {
					flg = true;
				}
				else {
					if (!flg) {
						insertSql.append("\n");
					}
				}
			}
			if ("".equals(tableColumn.getDefaultValue())) {
				insertSql.append("\t\t\t");
				if (flg) {
					insertSql.append(",");
				}
				else {
					flg = true;
				}
				insertSql.append("#{" + CommonUtils.getOutputColumnName(columnName, false) + "}");
			}
			else {
				insertSql.append("\t\t\t");
				if (flg) {
					insertSql.append(",");
				}
				insertSql.append("#{" + CommonUtils.getOutputColumnName(columnName, false) + "}");
				if (!flg) {
					insertSql.append(",");
				}
			}
			preTableColumn = tableColumn;
		}
		return insertSql.substring(0, insertSql.lastIndexOf(","));
	}

	public static String getInsertSql(List<TableColumn> columnList) {
		StringBuffer insertSql = new StringBuffer();
		int columnLength = columnList.size();
		TableColumn preTableColumn = null;
		boolean flg = false;
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			if (tableColumn.isIdentity()) {
				continue;
			}

			String columnName = tableColumn.getColumnName();
			if (insertSql.length() > 0) {
				if (flg) {
					insertSql.append("\n");
				}
				if ("".equals(preTableColumn.getDefaultValue())) {
					flg = true;
				}
				else {
					if (!flg) {
						insertSql.append("\n");
					}
				}
			}

			if ("".equals(tableColumn.getDefaultValue())) {
				insertSql.append("\t\t\t");
				if (flg) {
					insertSql.append(",");
				}
				else {
					flg = true;
				}
				insertSql.append(columnName);
			}
			else {
				insertSql.append("\t\t\t");
				if (flg) {
					insertSql.append(",");
				}
				insertSql.append(columnName);
				if (!flg) {
					insertSql.append(",");
				}
			}
			preTableColumn = tableColumn;
		}
		return insertSql.substring(0, insertSql.lastIndexOf(","));
	}
	
	public static String getSelectConditions() {
		return "\t\t\t1 = 1\n" 
			 + "\t\t\t<if test=\"filterMap.delFlg != null and filterMap.delFlg != ''\">\n"
             + "\t\t\t\tAND A.DEL_FLG = #{filterMap.delFlg}\n"
        	 + "\t\t\t</if>";
	}

	public static String getConditionSql(List<TableColumn> columnList) {
		StringBuffer condtionSql = new StringBuffer().append("\t\t1 = 1\n");
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			String columnName = tableColumn.getColumnName();
			condtionSql.append("\t\t<if test=\"" + CommonUtils.getOutputColumnName(columnName, false) + " != null\">\n");
			condtionSql.append("\t\t\tAND " + columnName + " = #{" + CommonUtils.getOutputColumnName(columnName, false) + "}\n");
			condtionSql.append("\t\t</if>");
			if (i < columnLength - 1) {
				condtionSql.append("\n");
			}
		}
		return condtionSql.toString();
	}

	public static String getSelectTableColumn(List<TableColumn> columnList) {
		StringBuffer selectColumn = new StringBuffer();
		int columnLength = columnList.size();
		for (int i = 0; i < columnLength; i++) {
			TableColumn tableColumn = columnList.get(i);
			String columnName = tableColumn.getColumnName();
			selectColumn.append("\t\t" + columnName + " AS " + CommonUtils.getOutputColumnName(columnName, false));
			if (columnLength != i + 1) {
				selectColumn.append(",");
				selectColumn.append("\n");
			}
		}
		return selectColumn.toString();
	}

	public static String getSqlMapName(String tableName) {
		String sqlMapTableName = CommonUtils.getOutputColumnName(tableName, true);
		return "SqlMap-" + sqlMapTableName + ".xml";
	}

}
