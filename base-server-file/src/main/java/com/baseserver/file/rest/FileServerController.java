package com.baseserver.file.rest;

import com.baseserver.file.bean.ConfigManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * FileServerController
 * @author shi_yuxi
 * @version 1.0
 */
@RestController
public class FileServerController {
    private static Logger logger = LoggerFactory.getLogger(FileServerController.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    private static final int SUCCESS_RESPONSE = 200;

    @Autowired
    ConfigManager configManager;

    /**
     * client端上传文件到文件服务
     *
     * @param request 请求
     * @param response 相应
     * @throws IOException
     */
    @RequestMapping(value = "/file/_upload", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) throws IOException{
        logger.info("客户端ip地址：" + request.getRemoteAddr());

        Map<String, String[]> data = request.getParameterMap();
        BASE64Decoder decoder = new BASE64Decoder();

        JSONObject successResult = new JSONObject();
        String fileServerPath = configManager.getFileServerPath();

        try {
            for(Map.Entry<String, String[]> entry : data.entrySet()){

                String fieldName = entry.getKey();
                String fid = null;
                //进行非图片文件上传
                fid = post(fileServerPath, decoder.decodeBuffer(entry.getValue()[0]), fieldName);
                //上传成功并返回了fid
                successResult.put(fieldName, fid);

            }

            logger.info("返回结果:" + successResult.toString());
            response.getOutputStream().write(successResult.toString().getBytes());
        } catch (Exception e) {
            logger.info(e.toString());
            response.sendError(406, "Not acceptable");
        }
    }

    /**
     * 从文件服务器下载文件
     *
     * @param request 请求
     * @param response 相应
     * @throws IOException
     */
    @RequestMapping(value = "/file/proxy/_download", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void downLoadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fid = request.getParameter("fid");
        String fileName = request.getParameter("fileName");
        if (StringUtils.isEmpty(fid) || StringUtils.isEmpty(fileName)) {
            return;
        }
        InputStream inputStream = getFileInputStream(fid);
        if (inputStream == null) {
            return;
        }
        byte[] buf = new byte[20480];
        int len = 0;
        String currentSys = System.getProperty("os.name");
        if (!StringUtils.isEmpty(currentSys) && currentSys.indexOf("Windows") >= 0) {
            response.addHeader("Content-Disposition", "filename=" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1"));
        } else {
            response.addHeader("Content-Disposition", "filename=" + fileName);
        }
        response.setContentType("application/x-msdownload;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        while ((len = inputStream.read(buf)) > 0) {
            response.getOutputStream().write(buf, 0, len);
        }
    }

    /**
     * 前台页面上传文件
     *
     * @param request 请求
     * @param response 相应
     * @throws IOException
     */
    @RequestMapping(value = "/file/jsp/_upload", method = RequestMethod.POST)
    public void uploadFileForJsp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("客户端ip地址：" + request.getRemoteAddr());

        JSONObject result = new JSONObject();
        JSONObject fids = new JSONObject();
        try {
            MultiValueMap<String, MultipartFile> files = ((MultipartRequest)request).getMultiFileMap();
            PrintWriter printWriter = new PrintWriter(response.getWriter());

            for(MultiValueMap.Entry<String, List<MultipartFile>> entry : files.entrySet()) {

                String fieldName = entry.getKey();
                InputStream inputStream = entry.getValue().get(0).getInputStream();
                String fid = post(configManager.getFileServerPath(), toByteArray(inputStream), fieldName);
                result.put("success",true);
                fids.put(fieldName, fid);
                result.put("fids",fids);
            }
            printWriter.write("<script>" +
                    "this.parent.window.postMessage(" + result + ",'*');" +
                    "</script>");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    /**
     * 向文件服务器上传文件
     *
     * @param path 请求路径
     * @param inputStream 文件byte数组
     * @param fileName 文件名
     * @return fid文件id
     * @throws IOException
     */
    private static String post(String path, final byte[] inputStream, final String fileName) throws IOException {
        logger.info("开始上传文件：" + fileName);
        String fid = null;
        ObjectMapper obj = new ObjectMapper();
        HttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(path);
        HttpEntity entity = MultipartEntityBuilder.create().setCharset(Charset.forName("UTF-8")).addBinaryBody(fileName, inputStream).seContentType(ContentType.MULTIPART_FORM_DATA).build();
        post.setEntity(entity);
        HttpResponse rs = client.execute(post);
        Map<?, ?> result = objectMapper.readValue(IOUtils.toString(rs.getEntity().getContent(), "UTF-8"), Map.class);

        fid = (String) result.get("fid");
        logger.info("文件" + fileName + "上传结束，获得fid=" + fid);
        return fid;
    }

    /**
     * 文件流下载
     *
     * @param fid 文件fid
     * @return 文件路径
     */
    public InputStream getFileInputStream(String fid) {
        String fileDownloadPath = configManager.getFileDownloadPath();
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(fileDownloadPath + fid);
        InputStream inputStream = null;
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
                logger.info("从服务器获得文件成功：" + fileDownloadPath + fid);
                inputStream = httpResponse.getEntity().getContent();
            } else {
                logger.error("下载文件" + fileDownloadPath + fid + " 返回状态: " + httpResponse.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputStream;
    }
}
