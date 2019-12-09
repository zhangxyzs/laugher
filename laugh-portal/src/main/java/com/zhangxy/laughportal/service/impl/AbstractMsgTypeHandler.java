package com.zhangxy.laughportal.service.impl;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;
import com.zhangxy.laughportal.service.MsgTypeHandler;

/**
 * 处理消息类
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
public abstract class AbstractMsgTypeHandler implements MsgTypeHandler {
    /*文本*/
    public final String MSG_TYPE_TEXT="text";
    /*图片*/
    public final String MSG_TYPE_IMAGE="image";
    /*音频*/
    public final String MSG_TYPE_VOICE="voice";
    /*视频*/
    public final String MSG_TYPE_VIDEO="video";
    /*音乐*/
    public final String MSG_TYPE_MUSIC="music";
    /*图文*/
    public final String MSG_TYPE_NEWS="news";
    /*短视频*/
    public final String MSG_TYPE_SHORTVIDEO="shortvideo";
    /*位置*/
    public final String MSG_TYPE_LOCATION="location";
     /*链接消息*/
    public final String MSG_TYPE_LINK="link";

    @Override
     public BaseMsg handlerMsg(InMsgInfo info){
        //这里处理一下消息重复的
        return handler(info);
    }
    protected abstract BaseMsg handler(InMsgInfo info);
}
