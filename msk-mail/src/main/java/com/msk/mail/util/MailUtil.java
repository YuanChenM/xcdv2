package com.msk.mail.util;

import com.framework.core.utils.StringUtils;
import org.springframework.core.io.FileSystemResource;

import java.io.*;
import java.util.*;

/**
 * Created by zhou_yajun on 2016/11/14.
 */
public class MailUtil {

    public static String[] getMailCcAddressee(String[] cc, String appendMailCc) {
        if (StringUtils.isEmpty(appendMailCc)) {
            return cc;
        }
        String[] appendMailCcList = appendMailCc.split(",");
        if (cc == null || cc.length == 0) {
            return appendMailCcList;
        }
        List<String> mailCcAddresseeList = new ArrayList<>();
        Collections.addAll(mailCcAddresseeList, cc);
        Collections.addAll(mailCcAddresseeList, appendMailCcList);
        return mailCcAddresseeList.toArray(new String[mailCcAddresseeList.size()]);
    }

    public static Map<String, FileSystemResource> getAttachments(Map<String, InputStream> attachment) {
        Object[] attachmentArr = attachment.keySet().toArray();
        Map<String, FileSystemResource> fileSystemResourceArr = new HashMap<>();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        String tempPath = System.getProperty("java.io.tmpdir");
        try {
            for (int i = 0; i < attachmentArr.length; i++) {
                String attachmentName = StringUtils.toString(attachmentArr[i]);
                String attachmentFullPath = tempPath + attachmentName;
                File attachmentFile = new File(attachmentFullPath);
                inputStream = attachment.get(attachmentArr[i]);
                outputStream = new FileOutputStream(attachmentFile);
                int j;
                while ((j = inputStream.read()) != -1) {
                    outputStream.write(j);
                }
                outputStream.flush();
                FileSystemResource fileSystemResource = new FileSystemResource(attachmentFile);
                fileSystemResourceArr.put(attachmentName, fileSystemResource);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileSystemResourceArr;
    }
}
