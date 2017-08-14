package com.framework.base.controller.rest;

import com.framework.base.bean.RestResponse;
import com.framework.base.bean.UploadParam;
import com.framework.base.service.IUploadFileProcess;
import com.framework.base.service.IUploadFileRead;
import com.framework.base.service.IUploadFileWrite;
import com.framework.base.service.UploadFileService;
import com.framework.base.utils.FileUploadUtil;
import com.framework.base.utils.SpringContextUtil;
import com.msk.redis.dao.BaseRedisDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * @author shi_yuxi
 */
@RestController
@Api(value = "asyncUploadFileController-api",
        description = "异步上传后台接口",
        position = 1,
        tags = "AsyncUploadFileController")
public class AsyncUploadFileRestController extends BaseRestController{

    /**
     * logger
     */
    private static Logger logger = getLogger(AsyncUploadFileRestController.class);

    public static final String SERVICE_READ = "Read";

    public static final String SERVICE_PROCESS = "Process";

    public static final String SERVICE_WRITE = "Write";

    @Autowired
    private BaseRedisDao baseRedisDao;

    @ApiOperation(value = "异步上传后台方法",
            notes = "异步上传后台方法",
            position = 1)
    @RequestMapping(value = "/async/_upload", method = {RequestMethod.POST, RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RestResponse<String> uploadFile(@RequestBody UploadParam uploadParam, HttpServletRequest request) throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            InputStream file = FileUploadUtil.getFileInputStream(uploadParam.getFid());

            IUploadFileRead uploadFileRead = (IUploadFileRead) SpringContextUtil.getBean(uploadParam.getServiceName() + SERVICE_READ);
            IUploadFileProcess uploadFileProcess = (IUploadFileProcess) SpringContextUtil.getBean(uploadParam.getServiceName() + SERVICE_PROCESS);
            IUploadFileWrite uploadFileWrite = (IUploadFileWrite) SpringContextUtil.getBean(uploadParam.getServiceName() + SERVICE_WRITE);
            List<T> listData =uploadFileRead.read(file, uploadParam);
            uploadFileProcess.processData(listData, uploadParam);
            uploadFileWrite.writeData(listData, uploadParam);
            map.put("status", "2");
            map.put("info", "上传成功。");
        }catch (Exception e){
            map.put("status", "1");
            map.put("info", "系统异常。");
            logger.error("上传异常",e);
        }
        baseRedisDao.delete(uploadParam.getTaskId());
        baseRedisDao.saveRedisMap(uploadParam.getTaskId(), map);
        RestResponse<String> restResponse = new RestResponse<>();
        restResponse.setMessage("成功!");
        restResponse.setResult("成功!");
        return restResponse;

    }
}
