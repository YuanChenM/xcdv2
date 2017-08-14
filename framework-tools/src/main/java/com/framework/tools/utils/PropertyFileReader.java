package com.framework.tools.utils;

import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyFileReader {

	private PropertyFileReader() {
	}

	public static Properties getProperties(String propertyFileName) {

		Properties prop = new Properties();

		if (propertyFileName == null) {
			return null;
		}

		ResourceBundle resourceBundle = ResourceBundle.getBundle(propertyFileName);

		Enumeration<?> enumeration = resourceBundle.getKeys();
		while (enumeration.hasMoreElements()) {
			Object key = enumeration.nextElement();
			prop.put(key, resourceBundle.getObject((String) key));
		}

		return prop;

	}

}
