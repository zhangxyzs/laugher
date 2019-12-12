package com.zhangxy.laughportal.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangxy.laughportal.constants.RedisSystemKey;
import com.zhangxy.laughportal.constants.WeChatConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 创建菜单
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@RestController
@RequestMapping("/wechat/menu")
public class MenuController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping
    public Object createMenu(){
        JSONObject object = create();
        String url= WeChatConstant.CREATE_MENU.replace("ACCESS_TOKEN",redisTemplate.opsForValue().get(RedisSystemKey.REIDS_WECHAT_ACCESS_TOKEN).toString());
        JSONObject object1 = restTemplate.postForObject(url, object, JSONObject.class);
        System.out.println(object1.toJSONString());
        return object1;
    }

    public JSONObject create() {
        JSONArray array=new JSONArray();
        JSONObject first1=new JSONObject();
        first1.put("type","click");
        first1.put("name","近期笑话");
        first1.put("key","THE_RECENT_JOKE");
        JSONObject first2=new JSONObject();
        first2.put("name","精彩推荐");
        JSONArray first2_sub=new JSONArray();
        JSONObject first21=new JSONObject();
        first21.put("type","click");
        first21.put("name","经典笑话");
        first21.put("key","CLASSIC_JOKE");
        JSONObject first22=new JSONObject();
        first22.put("type","click");
        first22.put("name","冷笑话");
        first22.put("key","COLD_JOKE");
        first2_sub.add(first21);
        first2_sub.add(first22);
        first2.put("sub_button",first2_sub);
        JSONObject first3=new JSONObject();
        first3.put("name","夜读");
        first3.put("type","view");
        first3.put("url","https://mp.weixin.qq.com/mp/homepage?__biz=MTI0MDU3NDYwMQ==&hid=3&sn=7b9302ba2fa43d23b9e3f81c78e49a57&scene=18");
        array.add(first1);
        array.add(first2);
        array.add(first3);
        JSONObject object=new JSONObject();
        object.put("button",array);
        return object;
    }
}
