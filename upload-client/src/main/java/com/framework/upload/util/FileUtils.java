package com.framework.upload.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * 文件操作辅助类
 * 
 * @author shi_yuxi
 * 
 */
public final class FileUtils {

    /** 当前目录 */
    public static final String CURRENT_PATH = "./";
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);
    /** 路径分隔符 */
    private static final String PATH_DOT = ".";

    /**
     * 构造方法
     */
    private FileUtils() {

    }

    /**
     * 
     * <p>
     * 检查目录是否存在
     * </p>
     * 
     * @param dir 目录
     * @return 目录存在返回true,目录不存在返回false
     */
    public static boolean checkDirExist(File dir) {
        boolean exist = false;
        if (dir != null) {
            exist = dir.exists();
        }
        return exist;
    }

    /**
     * 
     * <p>
     * 检查文件是否存在
     * </p>
     * 
     * @param file 文件
     * @return 文件存在返回True,文件不存在返回False
     */
    public static boolean checkFileExist(File file) {
        return file.exists();
    }

    /**
     * 
     * <p>
     * 删除文件
     * </p>
     * 
     * @param fileName 文件名称
     */
    public static void deleteFile(String fileName) {
        deleteFile(new File(fileName));
    }

    /**
     * 
     * <p>
     * 删除文件
     * </p>
     * 
     * @param file 文件
     */
    public static void deleteFile(File file) {
        if (checkFileExist(file)) {
            file.delete();
        }
    }

    /**
     * 获得文件的名称,不包含后缀
     * 
     * @param file 文件
     * @return 文件名称
     */
    public static String getFileName(File file) {
        String fileName = file.getName();
        int indexOf = fileName.indexOf(PATH_DOT);
        String filePrefix = fileName.substring(0, indexOf);
        return filePrefix;
    }

    /**
     * 获得文件名称的后缀
     * 
     * 
     * @param fileName 文件名称
     * @return 后缀
     * 
     * @author jiang_nan
     */
    public static String getFileSuffix(String fileName) {
        int indexOf = fileName.lastIndexOf(PATH_DOT);
        String fileSuffix = fileName.substring(indexOf + 1);
        return fileSuffix;
    }

    /**
     * 创建目录
     * 
     * @param dir 目录
     */
    public static void createDirectory(File dir) {
        if (dir != null && !checkDirExist(dir)) {
            boolean result = false;
            result = dir.mkdirs();
            if (!result) {
                logger.warn("文件目录创建失败：" + dir.getName());
            }
        }
    }

    /**
     * 创建文件
     * 
     * @param file 文件
     */
    public static void createFile(File file) {
        if (!checkFileExist(file)) {
            boolean result = file.mkdirs();
            if (!result) {
                logger.debug("文件创建失败：" + file.getName());
            }
        }
    }

    /**
     * 移动文件
     * 
     * @param srcPath 源路径
     * @param destPath 目标路径
     * @return boolean
     */
    public static boolean moveFile(String srcPath, String destPath) {
        boolean success = false;
        // File (or directory) to be moved
        File file = new File(srcPath);
        if (FileUtils.checkFileExist(file)) {
            // Destination directory
            File dest = new File(destPath);
            if (!checkFileExist(dest)) {
                dest.mkdirs();
            }
            // Move file to new directory
            success = file.renameTo(new File(dest, file.getName()));
        }
        return success;
    }

    /**
     * 获得系统临时目录
     * @return 系统临时目录
     */
    public static String getSystemTmpDir(){
        return System.getProperty("java.io.tmpdir");
    }
}
