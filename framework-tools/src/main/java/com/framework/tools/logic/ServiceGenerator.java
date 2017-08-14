package com.framework.tools.logic;

import com.framework.tools.bean.DBTable;
import com.framework.tools.utils.CommonUtils;
import com.framework.tools.utils.FileUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ServiceGenerator {

	public static void genaratorService(Configuration cfg, DBTable dbTable) throws IOException, TemplateException {
		BufferedWriter writer = null;
		String tableName = dbTable.getTableName();
		try {
			String _package = CommonUtils.getServiceOutPutPath(tableName);
			String path = _package + "/" + getServiceName(tableName) + ".java";
			FileUtils.mkdir(path);
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), CommonUtils.getSourceEncode()));
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			paramMap.put("package", CommonUtils.getServicePackage(tableName));
			paramMap.put("entityName", CommonUtils.getOutputColumnName(tableName, true));
			paramMap.put("pk", "Long");
			Template tpl = cfg.getTemplate("Service.ftl");
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

	public static String getServiceName(String tableName) {
		String domainName = CommonUtils.getOutputColumnName(tableName, true);
		return domainName + "Service";
	}

}
