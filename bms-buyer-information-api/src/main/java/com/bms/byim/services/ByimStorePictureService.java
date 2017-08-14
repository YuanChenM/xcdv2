/*
 * 2016/12/29 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.byim.services;

import com.bms.byim.bean.param.BaseBean;
import com.bms.byim.bean.param.StorePictureRsParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>ByimStorePictureService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface ByimStorePictureService extends BaseService {
    @Transactional
    int saveStorePictures(List<StorePictureRsParam> storePictureList);

    @Transactional
    int modifyStorePhotos(List<BaseBean<StorePictureRsParam, StorePictureRsParam>> baseBeanList);
}