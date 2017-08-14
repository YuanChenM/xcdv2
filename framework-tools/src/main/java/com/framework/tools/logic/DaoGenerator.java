package com.framework.tools.logic;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.framework.tools.bean.DBTable;
import com.framework.tools.utils.CommonUtils;
import com.framework.tools.utils.FileUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DaoGenerator {

	public static void genaratorDao(Configuration cfg, DBTable dbTable) throws IOException, TemplateException {
		BufferedWriter writer = null;
		String tableName = dbTable.getTableName();
		try {
			String _package = CommonUtils.getDaoOutPutPath(tableName);
			String path = _package + "/" + getDaoName(tableName) + ".java";
			FileUtils.mkdir(path);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), CommonUtils.getSourceEncode()));
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			paramMap.put("package", CommonUtils.getDaoPackage(tableName));
			paramMap.put("entityName", CommonUtils.getOutputColumnName(tableName, true));
			paramMap.put("entityPackage", CommonUtils.getEntityPackage());
			paramMap.put("pk", "Long");
			Template tpl = cfg.getTemplate("Dao.ftl");
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

	public static String getDaoName(String tableName) {
		String domainName = CommonUtils.getOutputColumnName(tableName, true);
		return domainName + "Dao";
	}

}
