package com.zhangxy.laughportal.service.impl;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;
import com.zhangxy.laughportal.service.EventHandler;

/**
 * 事件抽象类
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
public abstract class AbstractEventHandler implements EventHandler {
    @Override
    public BaseMsg handlerMsg(InMsgInfo info){
        //这里处理一下消息重复的
        return handler(info);
    }
    protected abstract BaseMsg handler(InMsgInfo info);
}
