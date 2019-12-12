package com.zhangxy.laughportal.service.impl;

import com.zhangxy.laughportal.dto.ArticlesInfo;
import com.zhangxy.laughportal.dto.ArticlesMsgInfo;
import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;
import org.springframework.stereotype.Service;

/**
 * 自定义菜单点击事件推送
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Service("clickEventHandler")
public class ClickEventHandler extends AbstractEventHandler{

    private final String EVENT_TYPE="CLICK";
    @Override
    protected BaseMsg handler(InMsgInfo info) {
        ArticlesMsgInfo articlesMsgInfo=new ArticlesMsgInfo();
        ArticlesInfo articlesInfo=new ArticlesInfo();
        articlesInfo.setTitle("尬了半天,不知如何是好");
        articlesInfo.setDescription("尬了半天,不知如何是好");
        articlesInfo.setPicUrl("https://mmbiz.qpic.cn/mmbiz_jpg/26EY7lLNFoLS7uNfoKWcu5yzWrn8sMnYmDZHbwQ4J7jMvTg3x12eTRibJULQMOEwAEt99nhSOlnwIpcAics8KlIw/640?wx_fmt=jpeg&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
        articlesInfo.setUrl("https://mp.weixin.qq.com/s/99o4AZmZ7rGH8pFwIEVoDA");
        articlesMsgInfo.setToUserName(info.getFromUserName());
        articlesMsgInfo.setFromUserName(info.getToUserName());
        articlesMsgInfo.setCreateTime(System.currentTimeMillis()/1000);
        articlesMsgInfo.setMsgType("news");
        articlesMsgInfo.setArticleCount(1);
        articlesMsgInfo.setItem(new ArticlesInfo[]{articlesInfo});
        return articlesMsgInfo;
    }

    @Override
    public boolean canSupport(InMsgInfo msg) {
        return msg.getEvent().equals(EVENT_TYPE);
    }
}
