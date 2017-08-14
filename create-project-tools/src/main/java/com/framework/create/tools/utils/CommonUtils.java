package com.framework.create.tools.utils;

import java.util.Properties;

public class CommonUtils {

	private CommonUtils() {
	}

	private static Properties property = null;

	static {
		if (null == property) {
			property = PropertyFileReader.getProperties("config.base");
		}
	}

	public static String getProjectRootPath(){
		String diskPath = property.getProperty("project.disk.path");
		String projectName = property.getProperty("project.name");
		String srcRootPath = property.getProperty("project.src.root.name");
		srcRootPath = srcRootPath.replace('.', '/');
		return diskPath + "/" + projectName + "/" + srcRootPath + "/";
	}

	public static String getJavaSrcRootPath(){
		String javaSrcRootPath = property.getProperty("project.java.root.name");
		javaSrcRootPath = javaSrcRootPath.replace('.', '/');
		return javaSrcRootPath + "/";
	}

	public static String getResourceRootPath(){
		String resourceRootPath = property.getProperty("project.resource.root.name");
		resourceRootPath = resourceRootPath.replace('.', '/');
		return resourceRootPath + "/";
	}

	public static String getBeanRootPath(){
		String beanRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "bean/";
		return beanRootPath;
	}
	public static String getBeanParamRootPath(){
		String beanParamRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "bean/param/";
		return beanParamRootPath;
	}

	public static String getBeanResultRootPath(){
		String beanParamRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "bean/result/";
		return beanParamRootPath;
	}

	public static String getServiceRootPath(){
		String serviceRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "service/";
		return serviceRootPath;
	}

	public static String getServiceImplRootPath(){
		String serviceImplRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "service/impl/";
		return serviceImplRootPath;
	}

	public static String getDaoRootPath(){
		String daoRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "dao/";
		return daoRootPath;
	}

	public static String getDaoSqlRootPath(){
		String daoSqlRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "dao/sql/";
		return daoSqlRootPath;
	}

	public static String getEntityRootPath(){
		String entityRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "entity/";
		return entityRootPath;
	}

	public static String getRestControllerRootPath(){
		String restControllerRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "rest/";
		return restControllerRootPath;
	}

	public static String getValidatorRootPath(){
		String validatorRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "validator/";
		return validatorRootPath;
	}

	public static String getCommonRootPath(){
		String commonRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "common/";
		return commonRootPath;
	}

	public static String getUtilRootPath(){
		String utilRootPath = getJavaSrcRootPath() + getPackageRootPath() + getModuleName() + "util/";
		return utilRootPath;
	}

	public static String getPackageInfoPath(){
		String packageInfoName = property.getProperty("package.info.name");
		return packageInfoName;
	}
	public static String getModuleName(){
		String moduleName = property.getProperty("module.name");
		return moduleName + "/";
	}
	public static String getPackageRootPath(){
		String packageRootPath = property.getProperty("package.root.path");
		packageRootPath = packageRootPath.replace('.', '/');
		return packageRootPath + "/";
	}
	public static String getPomXmlPath(){
		String diskPath = property.getProperty("project.disk.path");
		String projectName = property.getProperty("project.name");
		return diskPath + "/" + projectName + "/" + "pom.xml";
	}
	public static String getArtifactIdContext(){
		String packageRootPath = property.getProperty("package.root.path");
		String moduleName = property.getProperty("module.name");
		return packageRootPath + "." + moduleName;
	}
	public static String getSourceEncode(){
		String sourceEncode = property.getProperty("encode");
		return sourceEncode;
	}
	public static String getPackageName(String type){
		String packageRootPath = property.getProperty("package.root.path");
		String moduleName = property.getProperty("module.name");
		String beanPackage = packageRootPath + "." + moduleName + "." + type;
		return beanPackage;
	}
}
