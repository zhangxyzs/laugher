package com.zhangxy.laughportal.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangxy.laughportal.constants.WeChatConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * 权限接入
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Slf4j
@RestController
@RequestMapping("/wechat/auth")
public class AuthController {

    private static String WECHAT_ACCESS_TOKEN="WECHAT_ACCESS_TOKEN";

    @Value("${wechat.appID}")
    private String appID;
    @Value("${wechat.appSecret}")
    private String appSecret;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public Object getAccessToken() {
        String url= WeChatConstant.GET_ACCESS_TOKEN_URL.replace("APPID",appID).replace("APPSECRET",appSecret);
        ResponseEntity<JSONObject> object = restTemplate.getForEntity(url, JSONObject.class);
        if(object.getStatusCode()!= HttpStatus.OK){
            return null;
        }
        JSONObject body = object.getBody();
        String access_token = body.getString("access_token");
        //{"access_token":"ACCESS_TOKEN","expires_in":7200} 时间为秒，即2个小时
        redisTemplate.opsForValue().set(WECHAT_ACCESS_TOKEN,access_token, Duration.ofHours(1));
        return body;
    }
}
