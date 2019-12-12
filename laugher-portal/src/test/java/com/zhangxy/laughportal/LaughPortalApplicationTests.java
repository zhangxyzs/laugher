package com.zhangxy.laughportal;

import com.alibaba.fastjson.JSONObject;
import com.zhangxy.laughportal.constants.WeChatConstant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.WritableResource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaughPortalApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    private final static  String appID="wxcb84083aa9621a4d";
    private final static  String appSecret="f21b68d5aac886b03e5614da8a5699fa";
    private String accessToken="";
    @Before
    public void getAccessToken(){
        String url= WeChatConstant.GET_ACCESS_TOKEN_URL.replace("APPID",appID).replace("APPSECRET",appSecret);
        ResponseEntity<JSONObject> object = restTemplate.getForEntity(url, JSONObject.class);
        JSONObject body = object.getBody();
        String access_token = body.getString("access_token");
        System.out.println("access_token:"+access_token);
        accessToken=access_token;
    }
    @Test
    public void uploadFile() throws FileNotFoundException {
        String url=WeChatConstant.UPLOAD_MATERIAL.replace("ACCESS_TOKEN",accessToken).replace("TYPE","image");
        File file=new File("C:\\Users\\zhangxy\\Desktop\\图片\\docker框架.png");
        WritableResource resource = new FileSystemResource(file);
        MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
        data.add("media", resource);
        String jsonObjectResponseEntity = restTemplate.postForObject(url, data, String.class);
        System.out.println(jsonObjectResponseEntity);
    }
}
