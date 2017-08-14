package com.framework.base.utils;




import com.alibaba.fastjson.util.IOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.framework.base.consts.NumberConst;
import com.framework.base.consts.StringConst;
import com.framework.exception.UploadException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mao_yejun on 2016/4/18.
 */
public class FileUploadUtil {

    //public static final String FILE_SERVICE_URL = ConfigManager.getFileServerUpload() + ConfigManager.getFileUploadService();
    //TODO 数据字典
    public static final String FILE_SERVICE_URL = "http://10.20.16.157:8882/msk-file/file/_upload";
    private static final int SUCCESS_RESPONSE = 200;
    //TODO 数据字典
    //private static final String FILE_DOWNLOAD_URL = SystemServerManager.CommonServerManager.getMskFlieDownLoad();
    private static final String FILE_DOWNLOAD_URL = "http://10.20.16.157:8882/msk-file/file/_download/";
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);

    /**
     * 文件上传
     *
     * @param files
     * @return
     * @throws IOException
     */
    public static Map<String, String> uploadFiles(Map<String, File> files) throws Exception {

        Map<String, String> result = new HashMap<String, String>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(FILE_SERVICE_URL);
        ContentType contentType = ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), Charset.forName("UTF-8"));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
        for (String key : files.keySet()) {

            multipartEntityBuilder.addPart(key, new FileBody(files.get(key)));

        }
        multipartEntityBuilder.seContentType(ContentType.MULTIPART_FORM_DATA);
        HttpEntity entity = multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
            result = objectMapper.readValue(IOUtils.toString(response.getEntity().getContent()), Map.class);

        }
        return result;

    }

    /**
     * 文件流形式上传。
     *
     * @param streamMaps 指定的流文件 map 集。
     * @return 上传成功后的文件信息 map（key：所上传的文件流唯一标识，value：文件存储唯一标识）
     * @throws IOException
     */
    public static Map<String, String> uploadStreamFiles(Map<String, InputStream> streamMaps) throws Exception {
        BASE64Encoder encoder=new BASE64Encoder();
        Map<String, String> result = new HashMap<>();
        ObjectMapper objectMapper = new ObjectMapper();
        HttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(FILE_SERVICE_URL);
        ContentType contentType = ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), Charset.forName("UTF-8"));
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));

        for (String key : streamMaps.keySet()) {
//            multipartEntityBuilder.addBinaryBody("multipartFile", streamMaps.get(key));
            //multipartEntityBuilder.addTextBody("data", );
            byte[] data = toByteArray(streamMaps.get(key));
            //文件不得大于40M
            if(data.length >= 40*1024*1024){
                throw new UploadException("文件大于40M");
            }
            multipartEntityBuilder.addTextBody(key, encoder.encode(data));
        }

        multipartEntityBuilder.seContentType(ContentType.MULTIPART_FORM_DATA);
        HttpEntity entity = multipartEntityBuilder.build();
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
            result = objectMapper.readValue(IOUtils.toString(response.getEntity().getContent()), Map.class);
        }
        return result;
    }

    /**
     * 文件下载
     *
     * @param fid      文件fid
     * @param fileName 文件名
     * @return 文件路径
     */
    public static String getFile(String fid, String fileName) {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(FILE_DOWNLOAD_URL + fid);
        InputStream in = null;
        FileOutputStream out = null;
        String path = null;
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
                logger.info("从服务器获得文件成功："+FILE_DOWNLOAD_URL + fid );
                in = httpResponse.getEntity().getContent();
                String tempPath = FileUtils.getSystemTmpDir();
                out = new FileOutputStream(tempPath + "/" + fileName);
                byte[] b = new byte[1024];
                int n = 0;
                while ((n = in.read(b)) != -1) {
                    out.write(b, 0, n);
                }
                path = tempPath + "/" + fileName;
            } else {
                logger.error("下载文件" + FILE_DOWNLOAD_URL + fid + " 返回状态: " + httpResponse.getStatusLine().getStatusCode());
                return path;

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return path;
    }

    /**
     * 文件流下载
     *
     * @param fid 文件fid
     * @return 文件路径
     */
    public static InputStream getFileInputStream(String fid) {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(FILE_DOWNLOAD_URL + fid);
        InputStream in = null;
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == SUCCESS_RESPONSE) {
                logger.info("从服务器获得文件成功："+FILE_DOWNLOAD_URL + fid );
                in = httpResponse.getEntity().getContent();
            } else {
                logger.error("下载文件" + FILE_DOWNLOAD_URL + fid + " 返回状态: " + httpResponse.getStatusLine().getStatusCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return in;
    }

    /**
     * 文件获取文件流并转化为JSON以String形式返回。
     *
     * @param fid 文件fid
     * @return
     */
    public static String getFileString(String fid) {
        HttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(FILE_DOWNLOAD_URL + fid);
        InputStream in = null;
        String result = null;
        try {
            HttpResponse httpResponse = client.execute(httpGet);
            in = httpResponse.getEntity().getContent();

            result = inputStream2String(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    //文件输入流转String
    private static String inputStream2String(InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    /**
     * 获取可浏览器直接重命名下载的url
     *
     * @param fileId   文件fid
     * @param fileName 文件名 (含文件名后缀)
     * @return url
     */
    public static String getRealFileNameUrl(String fileId, String fileName){
        if(StringUtils.isEmpty(fileId)){

            return StringConst.EMPTY;
        }
        if(StringUtils.isEmpty(fileName)){
            return fileId;
        }
        String[] temps = fileId.split(StringConst.COMMA);
        String result = null;
        //fileid为固定格式
        if(temps.length == NumberConst.IntDef.INT_TWO){
            result = temps[0] + "/" + temps[1] + "/" + fileName;
        }else{
            result = StringConst.EMPTY;
        }
        return result;
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
}


