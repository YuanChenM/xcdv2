package com.msk.favorites.rest;

import com.msk.common.bean.RsRequest;
import com.msk.common.bean.RsResponse;
import com.msk.common.config.BaseRedisDao;
import com.msk.favorites.bean.FavoritesRedisBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

/**
 * Created by shi_yuxi on 2016/9/8.
 */
@RestController
@RequestMapping("api")
public class FavoritesRsController {

    @Autowired
    private BaseRedisDao baseRedisDao;

    @RequestMapping(value = "/favorites/_load", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    RsResponse<Map<String, String>> getFavoritesItems(@RequestBody RsRequest<FavoritesRedisBean> request) throws Exception{

        baseRedisDao.setDatabase(request.getParam().getDbNumber());
        Map<String, String> map = baseRedisDao.getRedisMapValue(request.getParam().getKey());
        RsResponse<Map<String, String>> response = new RsResponse<Map<String, String>>();
        response.setResult(map);
        response.setStatus("S");
        response.setReturnCode("200");
        response.setMessage("成功！");
        return response;
    }

    @RequestMapping(value = "/favorites/_save", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    RsResponse<Boolean> saveFavorites(@RequestBody RsRequest<FavoritesRedisBean> request) throws Exception{
        FavoritesRedisBean param = request.getParam();
        baseRedisDao.setDatabase(param.getDbNumber());
        baseRedisDao.saveRedisMap(param.getKey(), param.getData());
        RsResponse<Boolean> response = new RsResponse<>();
        response.setResult(true);
        response.setStatus("S");
        response.setReturnCode("200");
        response.setMessage("成功！");
        return response;
    }

    @RequestMapping(value = "/favorite/exist/_check", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    RsResponse<Boolean> checkFavoritesExist(@RequestBody RsRequest<FavoritesRedisBean> request) throws Exception{
        FavoritesRedisBean param = request.getParam();
        baseRedisDao.setDatabase(param.getDbNumber());
        boolean flag = baseRedisDao.exist(param.getKey());
        RsResponse<Boolean> response = new RsResponse<Boolean>();
        response.setResult(flag);
        response.setStatus("S");
        response.setReturnCode("200");
        response.setMessage("成功！");
        return response;
    }

    @RequestMapping(value = "/favorites/item/_save", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    RsResponse<Boolean> saveFavoritesItems(@RequestBody RsRequest<FavoritesRedisBean> request) throws Exception{
        FavoritesRedisBean param = request.getParam();
        baseRedisDao.setDatabase(param.getDbNumber());
        boolean flag = baseRedisDao.saveRedisMapOne(param.getKey(), param.getField(), param.getValue());
        RsResponse<Boolean> response = new RsResponse<Boolean>();
        response.setResult(flag);
        response.setStatus("S");
        response.setReturnCode("200");
        response.setMessage("成功！");
        return response;
    }

    @RequestMapping(value = "/favorites/item/_delete", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    RsResponse<Long> removeFavoritesItems(@RequestBody RsRequest<FavoritesRedisBean> request) throws Exception{
        FavoritesRedisBean param = request.getParam();
        baseRedisDao.setDatabase(param.getDbNumber());
        long count = baseRedisDao.removeRedisMapItems(param.getKey(), (String[])param.getFields().toArray(new String[param.getFields().size()]));
        RsResponse<Long> response = new RsResponse<Long>();
        response.setResult(count);
        response.setStatus("S");
        response.setReturnCode("200");
        response.setMessage("成功！");
        return response;
    }


}
