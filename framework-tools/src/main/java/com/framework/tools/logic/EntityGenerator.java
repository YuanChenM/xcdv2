package com.framework.tools.logic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.framework.tools.bean.DBTable;
import com.framework.tools.bean.EntityField;
import com.framework.tools.bean.TableColumn;
import com.framework.tools.utils.CommonUtils;
import com.framework.tools.utils.FileUtils;
import com.framework.tools.utils.Globles;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EntityGenerator implements Globles {

	public static void genaratorEntity(Configuration cfg, DBTable dbTable) throws IOException, TemplateException {
		BufferedWriter writer = null;
		String tableName = dbTable.getTableName();
		try {
			String _package = CommonUtils.getEntityOutPutPath();
			String path = _package + "/" + getDomainName(tableName) + ".java";
			FileUtils.mkdir(path);
			System.out.println("<typeAlias type=\"" + CommonUtils.getEntityPackage() + "." + getDomainName(tableName) + ".java\" alias=\"" + getDomainName(tableName) + "\"/>");
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), CommonUtils.getSourceEncode()));

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			paramMap.put("package", CommonUtils.getEntityPackage());
			paramMap.put("tableName", tableName);
			paramMap.put("entityName", getDomainName(tableName));
			paramMap.put("fieldList", getEntityFieldList(dbTable.getTableColumnList()));

			Template tpl = cfg.getTemplate("Entity.ftl");
			tpl.setEncoding("UTF-8");
			tpl.process(paramMap, writer);
		}
		finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}

	}

	public static List<EntityField> getEntityFieldList(List<TableColumn> tableColumnList) {
		List<EntityField> list = new ArrayList<EntityField>();
		for (TableColumn column : tableColumnList) {
			EntityField entityField = new EntityField();
			entityField.setName(CommonUtils.getOutputColumnName(column.getColumnName(), false));
			entityField.setMethodAppend(CommonUtils.getOutputColumnName(column.getColumnName(), true));
			String comment = column.getColumnDescription();
			if ("".equals(comment)) {
				entityField.setComment(CommonUtils.getOutputColumnName(column.getColumnName(), false));
			}
			else {
				entityField.setComment(comment);
			}
			entityField.setType(CommonUtils.getJavaMappingType(column.getDataType()));
			list.add(entityField);
		}
		return list;
	}

	private static String getDomainName(String tableName) {
		return CommonUtils.getOutputColumnName(tableName, true);
	}

}
