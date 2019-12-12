package com.zhangxy.laughportal.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * 回复消息
 *
 * @author zhangxy
 * @date 2019/12/04
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class OutMsgInfo extends BaseMsg{

    /**
     * 文本消息
     */
    @XmlElement(name="Content")
    private String content;
    /*图片消息媒体id，可以调用多媒体文件下载接口拉取数据*/

    /**
     * 媒体消息
     */
    @XmlElementWrapper(name="Image")
    @XmlElement(name="MediaId")
    private String[] mediaId ;
}
