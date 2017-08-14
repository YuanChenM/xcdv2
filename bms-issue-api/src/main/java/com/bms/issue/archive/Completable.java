package com.bms.issue.archive;

/**
 * 可补全的
 * 
 * @author li_huiqian
 *
 */
public interface Completable {

    /**
     * 通过ID或者其他唯一标识补全对象，补全时，不需补全明细信息。如果无法补全，请报错
     * 
     * @param allowDelete
     *            是否允许DEL_FLG=1
     */
    public void complete(boolean allowDelete);

}
