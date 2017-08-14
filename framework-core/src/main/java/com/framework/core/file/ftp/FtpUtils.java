package com.framework.core.file.ftp;

import com.framework.core.utils.StringUtils;
import com.framework.exception.SystemException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Arrays;

/**
 * 连接ftp工具类
 *
 * @author liu_tao2
 * @version 1.0
 */
public class FtpUtils {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(FtpUtils.class);
    /**
     * 本地字符编码
     */
    private static String LOCAL_CHARSET = "GBK";
    /**
     * FTP协议里面，规定文件名编码为iso-8859-1
     */
    private static String SERVER_CHARSET = "ISO-8859-1";

    /**
     * ftp url
     */
    private String url;
    /**
     * ftp 端口
     */
    private int port;
    /**
     * ftp 用户名
     */
    private String username;
    /**
     * ftp 密码
     */
    private String passwd;

    /**
     * 构造方法
     *
     * @param url      ftp请求地址
     * @param port     端口
     * @param username 服务器用户名
     * @param passwd   服务器密码
     */
    public FtpUtils(String url, int port, String username, String passwd) {
        this.url = url;
        this.port = port;
        this.username = username;
        this.passwd = passwd;
    }

    /**
     * 连接ftp
     *
     * @param path       文件在服务器路径
     * @param createFlag 如果文件夹不存在,是否创建文件夹
     * @return FTPClient
     * @throws Exception 异常
     */
    private FTPClient connect(String path, boolean createFlag) throws Exception {

        FTPClient ftp = new FTPClient();
        ftp.connect(this.url, this.port);// 连接FTP服务器
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            if (logger.isErrorEnabled()) {
                logger.error("FTP服务器拒绝连接[{}]。{}:{}", reply, this.url, this.port);
            }
            ftp = null;
            return null;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("ftp连接成功。{}:{}@{}", this.url, this.port, this.username);
            }
        }

        // 登录
        if (ftp.login(this.username, this.passwd) == false) {
            if (logger.isErrorEnabled()) {
                logger.error("FTP服务器login失败。{}", this.username);
            }
            ftp.disconnect();
            ftp = null;
            return null;
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("FTP服务器login成功。{}", this.username);
            }
        }

        ftp.enterLocalPassiveMode(); // 被动模式传输(linux对应)
        ftp.setFileType(FTP.BINARY_FILE_TYPE); // 传输方式为2进制传输

        if (FTPReply.isPositiveCompletion(ftp.sendCommand("OPTS UTF8", "ON"))) {
            // 开启服务器对UTF-8的支持，如果服务器支持就用UTF-8编码，否则就使用本地编码（GBK）.
            LOCAL_CHARSET = "UTF-8";
        }
        ftp.setControlEncoding(LOCAL_CHARSET);

        // 文件夹是否存在
        String remotePath = encodeFileName(path);
        if (logger.isDebugEnabled()) {
            logger.debug("远程路径：{}", remotePath);
        }
        boolean exists = ftp.changeWorkingDirectory(remotePath);
        if (logger.isDebugEnabled()) {
            if (exists) {
                logger.debug("进入目录:{}", remotePath);
            } else {
                logger.debug("远程路径不存在：{}", remotePath);
            }
        }
        // 文件夹不存在，创建
        if (createFlag && !exists) {
            // 创建文件夹
            exists = makeFtpDir(path, ftp);
        }
        // 文件夹不存在，不创建
        if (!createFlag && !exists) {
            if (logger.isErrorEnabled()) {
                logger.error("指定文件夹目录不存在! {}", path);
            }
            SystemException systemException = new SystemException("system.error.ftpfail");
            throw systemException;
        }
        return ftp;
    }

    public boolean upload(String remotePath, InputStream inputStream, String fileName) {
        FTPClient ftp = null;
        try {
            ftp = connect(remotePath, true);
            if (ftp != null) {
                boolean result = upload(fileName, inputStream, ftp);
                return result;
            }
        } catch (Exception e) {
            SystemException systemException = new SystemException("system.error.ftpfail");
            systemException.initCause(e);
            throw systemException;
        }
        if (ftp != null) {
            disconnect(ftp);
        }
        return false;

    }


    private boolean upload(String fileName, InputStream inputStream, FTPClient ftp) {
        try {
            boolean result = ftp.storeFile(encodeFileName(fileName), inputStream);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.closeInputStream(inputStream);
        }
        return false;
    }


    private void closeInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 上传文件或目录到FTP
     *
     * @param remotePath 上传路径
     * @param localFile  上传的文件或文件夹
     * @return boolean
     */
    public boolean upload(String remotePath, File localFile) {
        boolean result = false;

        FTPClient ftp = null;
        try {
            ftp = connect(remotePath, true);
            if (ftp != null) {
                result = upload(localFile, ftp);
            }
        } catch (Exception e) {
            SystemException systemException = new SystemException("system.error.ftpfail");
            systemException.initCause(e);
            throw systemException;
        } finally {
            if (ftp != null) {
                disconnect(ftp);
            }
        }

        return result;
    }

    /**
     * 上传文件或目录到FTP
     *
     * @param localFile 上传的文件或文件夹
     * @param ftp       FTPClient
     * @return boolean
     * @throws Exception 异常
     */
    private boolean upload(File localFile, FTPClient ftp) throws Exception {
        boolean result = false;
        if (localFile.isDirectory()) {
            // 上传目录
            // 创建目录
            String dirName = encodeFileName(localFile.getName());
            if (result = makeFtpDir(dirName, ftp)) {
                File[] subFiles = localFile.listFiles();
                for (File subFile : subFiles) {
                    // 上传目录中的子对象
                    result = upload(subFile, ftp) && result;
                }
                // 返回到原目录
                ftp.changeToParentDirectory();
            } else {
                if (logger.isErrorEnabled()) {
                    logger.error("ftp上传文件,目录创建失败。{}", localFile.getPath());
                }
            }
        } else {
            // 上传文件
            FileInputStream input = null;
            try {
                File file = new File(localFile.getPath());
                input = new FileInputStream(file);
                result = ftp.storeFile(encodeFileName(file.getName()), input);
                if (logger.isInfoEnabled()) {
                    logger.info("ftp上传文件结果：{},{}", file.getPath(), result);
                }
            } finally {
                this.closeInputStream(input);
            }
        }

        return result;
    }

    /**
     * 从FTP下载文件
     *
     * @param remotePath ftp上的文件路径
     * @param remoteFile ftp上的文件名
     * @param localFile  下载保存的本地文件
     * @return boolean
     */
    public boolean download(String remotePath, String remoteFile, File localFile) {
        boolean result = false;
        if (logger.isDebugEnabled()) {
            logger.debug("ftp下载: remotePath={}, remoteFile={}, localFile={}", remotePath, remoteFile,
                    localFile != null ? localFile.getAbsolutePath() : "null");
        }

        if (localFile == null) {
            if (logger.isErrorEnabled()) {
                logger.error("ftp下载参数不正确。 localFile=null");
            }
            SystemException systemException = new SystemException("system.error.ftpfail");
            throw systemException;
        }

        // 本地文件不存在时，创建文件
        if (!localFile.exists()) {
            localFile.getParentFile().mkdirs();
            // localFile.createNewFile();
            if (logger.isDebugEnabled()) {
                logger.debug("创建本地文件:{}", localFile.getAbsolutePath());
            }
        }

        FTPClient ftp = null;
        OutputStream os = null;
        try {
            ftp = connect(remotePath, false);
            if (ftp == null) {
                return false;
            }
            if (logger.isDebugEnabled()) {
                try {
                    String[] files = ftp.listNames();
                    if (files != null && files.length > 0) {
                        for (String fileName : files) {
                            logger.debug("文件名:{}", fileName);
                        }
                    } else {
                        logger.debug("{}下没有文件", remotePath);
                    }
                } catch (Exception e) {
                    logger.debug("查看目录失败。", e);
                }
            }

            os = new FileOutputStream(localFile);
            if (ftp.retrieveFile(encodeFileName(remoteFile), os)) {
                result = true;
                if (logger.isInfoEnabled()) {
                    logger.info("ftp下载文件成功!{}", localFile);
                }
            } else {
                if (logger.isErrorEnabled()) {
                    logger.error("ftp下载文件失败!ReplyCode:{}", ftp.getReplyCode());
                }
            }
        } catch (Exception e) {
            SystemException systemException = new SystemException("system.error.ftpfail");
            systemException.initCause(e);
            throw systemException;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("ftp下载本地文件关闭失败!", e);
                    }
                }
            }
            if (ftp != null) {
                disconnect(ftp);
            }
        }

        return result;
    }

    /**
     * 关闭ftp连接
     *
     * @param ftp FTP客户端
     * @return boolean
     */
    private static boolean disconnect(FTPClient ftp) {
        if (null == ftp) {
            return true;
        }
        try {
            ftp.logout();
            if (logger.isDebugEnabled()) {
                logger.debug("ftp连接关闭!");
            }
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("ftp连接关闭异常!", e);
            }
        }
        try {
            ftp.disconnect();
            if (logger.isDebugEnabled()) {
                logger.debug("ftp连接关闭!");
            }
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("ftp连接关闭异常!", e);
            }
        }

        return true;
    }

    /**
     * 文件名转码
     *
     * @param fileName 文件名
     * @return 转码后的文件名
     */
    private static String encodeFileName(String fileName) {
        String result = fileName;
        if (!StringUtils.isEmpty(fileName)) {
            try {
                final byte[] name = fileName.getBytes(LOCAL_CHARSET);
                result = new String(name, SERVER_CHARSET);
                byte zero = 0;
                Arrays.fill(name, zero);
            } catch (Exception e) {
                if (logger.isWarnEnabled()) {
                    logger.warn("FTP文件名转码失败。", e);
                }
            }
        }
        return result;
    }

    /**
     * 创建FTP目录
     *
     * @param path 目录路径
     * @param ftp  FTP客户端
     * @return 创建成功：true
     * @throws Exception 异常
     */
    private static boolean makeFtpDir(String path, FTPClient ftp) throws Exception {
        boolean result = false;

        if (StringUtils.isEmpty(path)) {
            // path最后为/时的对应
            result = true;
        } else if (ftp.changeWorkingDirectory(encodeFileName(path))) {
            // 目录存在
            result = true;
            if (logger.isDebugEnabled()) {
                logger.debug("进入目录:{}", path);
            }
        } else {
            int index = path.lastIndexOf("/");
            if (index >= 0) {
                String parentPath = path.substring(0, index);
                String lastPath = path.substring(index + 1);
                result = makeFtpDir(parentPath, ftp);
                if (result) {
                    // 当前最后一层目录
                    result = makeFtpDir(lastPath, ftp);
                }
            } else {
                // 当前第一层目录
                result = ftp.makeDirectory(encodeFileName(path));
                if (logger.isDebugEnabled()) {
                    logger.debug("创建目录:{},{},{}", path, result, ftp.getReplyString());
                }
                if (result) {
                    result = ftp.changeWorkingDirectory(encodeFileName(path));
                    if (logger.isDebugEnabled()) {
                        logger.debug("进入目录:{},{}", path, result);
                    }
                } else {
                    SystemException ex = new SystemException("system.error.ftpfail");
                    throw ex;
                }
            }
        }

        return result;
    }
}
