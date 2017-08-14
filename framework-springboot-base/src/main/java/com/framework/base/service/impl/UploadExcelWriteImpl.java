package com.framework.base.service.impl;

import com.framework.base.bean.UploadParam;
import com.framework.base.service.IUploadFileWrite;

import java.util.List;

/**
 * @author shi_yuxi
 */
public abstract class UploadExcelWriteImpl implements IUploadFileWrite{


    /**
     * 执行的写操作
     *
     * @param data 一次执行数据
     * @param param 前台参数
     * @param <T> 泛型
     */
    public abstract  <T> void toWriteData(List<T> data, UploadParam param);

    @Override
    public <T> void writeData(List<T> data, UploadParam param) {
        int size = data.size();
        int length = getMaXlLength();

        if(length == -1){
            toWriteData(data, param);
        }else{
            int eachSize = size/length;
            for(int i = 0; i >= eachSize; i++){
                toWriteData(data.subList(i*length, (i+1)*length), param);
            }
            if(size%length != 0){
                toWriteData(data.subList(eachSize*length, size), param);
            }
        }

    }

    /**
     * 获取每次执行条数，默认-1，全部执行
     * @return 执行条数
     */
    public int getMaXlLength(){
        return -1;
    }
}
