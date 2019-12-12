package com.zhangxy.laughportal.service.impl;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;
import com.zhangxy.laughportal.service.EventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 点击消息处理
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Slf4j
@Service("eventMsgTypeHandler")
public class EventMsgTypeHandler extends AbstractMsgTypeHandler {

    @Autowired
    private List<EventHandler> eventHandlers;

    public final String MSG_TYPE_EVENT="event";

    @Override
    protected BaseMsg handler(InMsgInfo info) {
        for (EventHandler eventHandler:eventHandlers){
            if(eventHandler.canSupport(info)){
                return eventHandler.handlerMsg(info);
            }
        }
        log.info("目前不支持【{}】事件的处理",info.getEvent());
        return null;
    }

    @Override
    public boolean canSupport(InMsgInfo msg) {
        if(msg.getMsgType().equals(MSG_TYPE_EVENT)){
            return true;
        }
        return false;
    }
}
