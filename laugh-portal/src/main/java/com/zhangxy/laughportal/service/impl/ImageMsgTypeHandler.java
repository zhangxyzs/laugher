package com.zhangxy.laughportal.service.impl;

import com.zhangxy.laughportal.dto.InMsgInfo;
import com.zhangxy.laughportal.dto.OutMsgInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 文本消息处理
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Slf4j
@Service("imageEventHandler")
public class ImageMsgTypeHandler extends AbstractMsgTypeHandler {
    @Override
    protected OutMsgInfo handler(InMsgInfo info) {
        //todo 消息处理
        //比如根据消息内容通过分析之后回复不同的消息内容
        log.info("处理图片消息{}",info.toString());
        //todo 消息回复（这里回复先按照默认的走。后期改为动态的）
        OutMsgInfo res=new OutMsgInfo();
        res.setFromUserName(info.getToUserName());
        res.setToUserName(info.getFromUserName());
        res.setCreateTime(System.currentTimeMillis()/1000);
        res.setMsgType(MSG_TYPE_IMAGE);
        res.setMediaId(new String[]{info.getMediaId()});
        return res;
    }

    @Override
    public boolean canSupport(InMsgInfo msg) {
        if(msg.getMsgType().equals(MSG_TYPE_IMAGE)){
            return true;
        }
        return false;
    }
}
