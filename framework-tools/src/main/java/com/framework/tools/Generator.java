package com.framework.tools;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.framework.tools.bean.DBTable;
import com.framework.tools.db.DBConnection;
import com.framework.tools.logic.*;

import freemarker.template.Configuration;

public class Generator {
	private static Configuration config;
	
	static {
		if (null == config) {
			config = new Configuration();
			try {
				String filePath = Generator.class.getResource("/").getPath().replaceAll("%20", " ") + "template";
				config.setDirectoryForTemplateLoading(new File(filePath));
				config.setDefaultEncoding("UTF-8");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		List<String> tableList = DBConnection.getTableNames();
		for (String table : tableList) {
			DBTable dbTable = DBConnection.getTableColumns(table);
			try {
				SqlMapGenerator.genaratorSqlMap(config, dbTable);
				EntityGenerator.genaratorEntity(config, dbTable);
				DaoGenerator.genaratorDao(config, dbTable);
				ServiceGenerator.genaratorService(config, dbTable);
				ServiceImplGenerator.genaratorServiceImpl(config, dbTable);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
