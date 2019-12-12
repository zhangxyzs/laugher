package com.zhangxy.laughportal.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhangxy.laughportal.constants.RedisSystemKey;
import com.zhangxy.laughportal.constants.WeChatConstant;
import com.zhangxy.laughportal.dto.ArticlesBo;
import com.zhangxy.laughportal.service.WeChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.List;

/**
 * 微信接口服务
 *
 * @author zhangxy
 * @date 2019/12/07
 **/
@Service
@Slf4j
public class WeChatServiceImpl implements WeChatService {
    @Autowired
    private RestTemplate restTemplate;

    private RedisTemplate redisTemplate;
    /**
     * 上传图文消息内的图片获取URL
     */
    @Override
    public String uploadImage(String path) {
        String mediaId="";
        try {
            String url = WeChatConstant.UPLOADIMG.replace("ACCESS_TOKEN", redisTemplate.opsForValue().get(RedisSystemKey.REIDS_WECHAT_ACCESS_TOKEN).toString());
            File file=new File(path);
            WritableResource resource = new FileSystemResource(file);
            MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
            data.add("media", resource);
            JSONObject object = restTemplate.postForObject(url, data, JSONObject.class);
            return object.getString("url");
        }catch (Exception e){
            log.error("上传图文消息异常{}",e);
        }
        return null;
    }

    /**
     * add_news
     * https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
     */
    @Override
    public String addNews(List<ArticlesBo> articlesBoList) {
        String mediaId="";
        try {
            String url = WeChatConstant.ADD_NEWS.replace("ACCESS_TOKEN", redisTemplate.opsForValue().get(RedisSystemKey.REIDS_WECHAT_ACCESS_TOKEN).toString());
            JSONObject object = restTemplate.postForObject(url, articlesBoList, JSONObject.class);
            return object.getString("media_id");
        }catch (Exception e){
            log.error("添加图文消息异常{}",e);
        }
        return null;
    }

    @Override
    public JSONObject addMaterial(String path,String type,String title,String introduction) {
        try {
            String url = WeChatConstant.ADD_MATERIAL
                    .replace("TYPE",type)
                    .replace("ACCESS_TOKEN", redisTemplate.opsForValue().get(RedisSystemKey.REIDS_WECHAT_ACCESS_TOKEN).toString());
            File file=new File(path);
            WritableResource resource = new FileSystemResource(file);
            MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
            data.add("media", resource);
            data.add("title",title);
            data.add("introduction",introduction);
            JSONObject object = restTemplate.postForObject(url, data, JSONObject.class);
            return object;
        }catch (Exception e){
            log.error("新增其他类型永久素材异常{}",e);
        }
        return null;
    }
}
