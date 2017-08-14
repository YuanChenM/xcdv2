package com.bms.prce.service;

import com.bms.prce.bean.param.PRCE0213IParam;
import com.bms.prce.bean.result.PRCE0213IResult;
import com.framework.boot.base.BaseService;

import java.util.List;

public interface PrcePricePlateService extends BaseService {

    List<PRCE0213IResult> findPrcePricePlateList(PRCE0213IParam param);

}