package com.zhangxy.laughportal.component;

import com.zhangxy.laughportal.constants.RedisSystemKey;
import com.zhangxy.laughportal.constants.WeChatConstant;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * 刷新Token
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Component
@Slf4j
public class RefreshTokenTask {

    @Value("${wechat.appID}")
    private String appID;
    @Value("${wechat.appSecret}")
    private String appSecret;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 每一个小时执行一次
     */
    @Scheduled(cron = "0 0 0/1 * * *")
    public void refreshAccessToken() throws JSONException {
        log.info("自动刷新任务开始执行。。。");
        String url= WeChatConstant.GET_ACCESS_TOKEN_URL.replace("APPID",appID).replace("APPSECRET",appSecret);
        ResponseEntity<JSONObject> object = restTemplate.getForEntity(url, JSONObject.class);
        if(object.getStatusCode()!= HttpStatus.OK){
            return ;
        }
        JSONObject body = object.getBody();
        String access_token = body.getString("access_token");
        //{"access_token":"ACCESS_TOKEN","expires_in":7200} 时间为秒，即2个小时
        redisTemplate.opsForValue().set(RedisSystemKey.REIDS_WECHAT_ACCESS_TOKEN,access_token, Duration.ofHours(1));
        log.info("自动刷新任务完成。。。");
    }
}
