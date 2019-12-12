package com.zhangxy.laughportal.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收文本消息
 *
 * @author zhangxy
 * @date 2019/12/04
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class InMsgInfo extends BaseMsg{

    /**
     * 消息唯一Id
     */
    @XmlElement(name="MsgId")
    private Long msgId;
    /**
     * 文本消息
     */
    @XmlElement(name="Content")
    private String content;

    /**
     * 媒体消息
     */
    @XmlElement(name="MediaId")
    private String mediaId;

    @XmlElement(name="Event")
    private String Event;

    @XmlElement(name="EventKey")
    private String eventKey;
}
