package com.batch.linv.writer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.batch.linv.bean.entity.*;
import com.batch.linv.constant.LinvApiUrlConstant;
import com.framework.core.utils.DateUtils;
import com.framework.redis.dao.BaseRedisDao;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.linv.constant.ResponseDataReader;
import com.batch.linv.dao.LinvSynInvDao;
import com.framework.batch.item.database.MybatisItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangfan on 2017/5/6.
 */
public class SynWmsInvWriter extends MybatisItemWriter<InvmLoad> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SynWmsInvWriter.class);

    @Override
    protected void doWrite(List<InvmLoad> invmLoadList) throws Exception {
        //do noting
    }
}
