package com.zhangxy.laughportal.service;

import com.alibaba.fastjson.JSONObject;
import com.zhangxy.laughportal.dto.ArticlesBo;

import java.util.List;

public interface WeChatService {
    /**
     * 上传图文消息内的图片获取URL
     */
    String uploadImage(String path);
    /**
     * add_news
     * https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN
     */
    String addNews(List<ArticlesBo> articlesBoList);

    //新增其他类型永久素材
    JSONObject addMaterial(String path,String type,String title,String introduction);
}
