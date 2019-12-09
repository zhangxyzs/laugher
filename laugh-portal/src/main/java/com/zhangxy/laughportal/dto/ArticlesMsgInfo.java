package com.zhangxy.laughportal.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * 图文消息
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class ArticlesMsgInfo extends BaseMsg {
    @XmlElement(name = "ArticleCount")
    private int articleCount;

    @XmlElementWrapper(name = "Articles")
    @XmlElement(name = "item")
    private ArticlesInfo[] item;
}
