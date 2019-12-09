package com.zhangxy.laughportal.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 图片消息
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticlesInfo {

    @XmlElement(name = "Title")
    private String title;

    @XmlElement(name = "Description")
    private String description;

    @XmlElement(name = "PicUrl")
    private String picUrl;

    @XmlElement(name = "Url")
    private String url;
}
