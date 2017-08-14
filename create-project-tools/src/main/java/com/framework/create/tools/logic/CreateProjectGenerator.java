package com.framework.create.tools.logic;

import com.framework.create.tools.utils.CommonUtils;
import com.framework.create.tools.utils.FileUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CreateProjectGenerator{

	public static void genaratorEntity(Configuration cfg) throws IOException,ParserConfigurationException,SAXException,TemplateException{
		BufferedWriter writer = null;
		try {
			//做成resources文件夹
			String resourceRootPath = CommonUtils.getResourceRootPath();
			mkdir(writer,cfg,resourceRootPath,null);
			//生成bean目录文件夹,并在文件夹下生成package-info.java文件
			String beanRootPath = CommonUtils.getBeanRootPath();
			String beanPackage = CommonUtils.getPackageName("bean");
			mkdir(writer,cfg,beanRootPath,beanPackage);
			//生成bean目录下param文件夹,并在文件夹下生成package-info.java文件
			String beanParamRootPath = CommonUtils.getBeanParamRootPath();
			String beanParamPackage = CommonUtils.getPackageName("bean.param");
			mkdir(writer,cfg,beanParamRootPath,beanParamPackage);
			//生成bean目录下result文件夹,并在文件夹下生成package-info.java文件
			String beanResultRootPath = CommonUtils.getBeanResultRootPath();
			String beanResultPackage = CommonUtils.getPackageName("bean.result");
			mkdir(writer,cfg,beanResultRootPath,beanResultPackage);
			//生成service目录文件夹,并在文件夹下生成package-info.java文件
			String serviceRootPath = CommonUtils.getServiceRootPath();
			String servicePackage = CommonUtils.getPackageName("service");
			mkdir(writer,cfg,serviceRootPath,servicePackage);
			//生成service目录下impl文件夹,并在文件夹下生成package-info.java文件
			String serviceImplRootPath = CommonUtils.getServiceImplRootPath();
			String serviceImplPackage = CommonUtils.getPackageName("service.impl");
			mkdir(writer,cfg,serviceImplRootPath,serviceImplPackage);
			//生成dao目录文件夹,并在文件夹下生成package-info.java文件
			String daoRootPath = CommonUtils.getDaoRootPath();
			String daoPackage = CommonUtils.getPackageName("dao");
			mkdir(writer,cfg,daoRootPath,daoPackage);
			//生成dao目录下sql文件夹,并在文件夹下生成package-info.java文件
			String daoSqlRootPath = CommonUtils.getDaoSqlRootPath();
			String daoSqlPackage = CommonUtils.getPackageName("dao.sql");
			mkdir(writer,cfg,daoSqlRootPath,daoSqlPackage);
			//生成rest目录文件夹,并在文件夹下生成package-info.java文件
			String restControllerRootPath = CommonUtils.getRestControllerRootPath();
			String restPackage = CommonUtils.getPackageName("rest");
			mkdir(writer,cfg,restControllerRootPath,restPackage);
			//生成validator目录文件夹,并在文件夹下生成package-info.java文件
			String validatorRootPath = CommonUtils.getValidatorRootPath();
			String validatorPackage = CommonUtils.getPackageName("validator");
			mkdir(writer,cfg,validatorRootPath,validatorPackage);
			//生成entity目录文件夹,并在文件夹下生成package-info.java文件
			String entityRootPath = CommonUtils.getEntityRootPath();
			String entityPackage = CommonUtils.getPackageName("entity");
			mkdir(writer,cfg,entityRootPath,entityPackage);
			//生成common目录文件夹,并在文件夹下生成package-info.java文件
			String commonRootPath = CommonUtils.getCommonRootPath();
			String commonPackage = CommonUtils.getPackageName("common");
			mkdir(writer,cfg,commonRootPath,commonPackage);
			//生成util目录文件夹,并在文件夹下生成package-info.java文件
			String utilRootPath = CommonUtils.getUtilRootPath();
			String utilPackage = CommonUtils.getPackageName("util");
			mkdir(writer,cfg,utilRootPath,utilPackage);
			//生成pom文件
			readPomXML();
		}
		finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}

	/**
	 * 文件夹做成
	 * @param rootPath
	 */
	public static void mkdir(BufferedWriter writer,Configuration cfg,String rootPath,String rootPackageName) throws IOException,TemplateException{
		String packageInfoPath = CommonUtils.getPackageInfoPath();
		String projectRootPath = CommonUtils.getProjectRootPath();
		FileUtils.mkdir(projectRootPath + rootPath + packageInfoPath);
		if(null != rootPackageName){
			createPackageInfo(writer,cfg,rootPath,rootPackageName);
		}
	}

	/**
	 * 读pom.xml模板,修改artifactId
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void readPomXML() throws ParserConfigurationException,IOException,SAXException{
		File xmlFile = new File("src/main/resources/pom.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		Element root = doc.getDocumentElement();
		NodeList pomNodeList = root.getChildNodes();

		for(int i = 0;i < pomNodeList.getLength();i ++){
			Node pomNode = pomNodeList.item(i);
			if(pomNode.getNodeType() == Node.ELEMENT_NODE){
				if("groupId".equals(pomNode.getNodeName())){
					pomNode.setTextContent(CommonUtils.getModuleName());
					continue;
				}
				//设置pom.xml的artifactId
				if("artifactId".equals(pomNode.getNodeName())){
					pomNode.setTextContent(CommonUtils.getArtifactIdContext());
					continue;
				}
			}
		}
		savePomXml(doc);
	}

	/**
	 * 保存pom.xml
	 * @param document
	 */
	public static void savePomXml(Document document){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			String pmXmlPath = CommonUtils.getPomXmlPath();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new FileOutputStream(pmXmlPath));
			transformer.transform(domSource, streamResult);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建package-info.java
	 * @param writer
	 * @param cfg
	 * @param path
	 * @param packageName
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createPackageInfo(BufferedWriter writer,Configuration cfg,String path,String packageName) throws IOException,TemplateException{
		try {
			String applicationPath = CommonUtils.getProjectRootPath() + path + "package-info.java";
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(applicationPath), CommonUtils.getSourceEncode()));
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("package", packageName);
			paramMap.put("date", new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			Template tpl = cfg.getTemplate("package-info.ftl");
			tpl.setEncoding("UTF-8");
			tpl.process(paramMap, writer);
		}finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}

	/**
	 * 创建Application.java
	 * @param writer
	 * @param cfg
	 * @param path
	 * @param packageName
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createApplication(BufferedWriter writer,Configuration cfg,String path,String packageName) throws IOException,TemplateException{
		try {
			String applicationFullPath = path + "Application.java";
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(applicationFullPath), CommonUtils.getSourceEncode()));
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("package",packageName);
			paramMap.put("date",new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
			paramMap.put("module",CommonUtils.getModuleName().toUpperCase());
			Template tpl = cfg.getTemplate("Application.ftl");
			tpl.setEncoding("UTF-8");
			tpl.process(paramMap, writer);
		}finally {
			if (null != writer) {
				writer.flush();
				writer.close();
			}
		}
	}
}
