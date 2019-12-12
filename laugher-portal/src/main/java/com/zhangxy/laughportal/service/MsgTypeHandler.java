package com.zhangxy.laughportal.service;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;

/**
 * 处理消息
 */
public interface MsgTypeHandler {
    /**
     * 是否可以处理
     * @param msg
     * @return
     */
    boolean canSupport(InMsgInfo msg);

    BaseMsg handlerMsg(InMsgInfo msg);
}
