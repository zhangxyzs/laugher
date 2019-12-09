package com.zhangxy.laughportal.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 基本消息
 *
 * @author zhangxy
 * @date 2019/12/04
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class BaseMsg {
    /**
     * 开发者微信号
     */
    @XmlElement(name="ToUserName")
    private String toUserName;

    /**
     *  发送方帐号（一个OpenID）
     */
    @XmlElement(name="FromUserName")
    private String fromUserName;
    /**
     * 	消息创建时间 （整型）
     */
    @XmlElement(name="CreateTime")
    private Long createTime;

    /**
     * 	消息类型，文本为text
     */
    @XmlElement(name="MsgType")
    private String msgType;

}
