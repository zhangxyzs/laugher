package com.zhangxy.laughportal.service;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;

/**
 * 事件处理
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
public interface EventHandler {
    boolean canSupport(InMsgInfo msg);
    BaseMsg handlerMsg(InMsgInfo msg);
}
