package com.framework.batch.item;

import com.framework.batch.item.file.excel.Sheet;

/**
 * <p>读EXCEL文件的回调接口，处理跳过的行，在文件头/脚添加内容。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/11
 * @version 1.0.0
 */
public interface RowCallbackHandler {

    void handleRow(Sheet sheet, String[] cellValues);

}