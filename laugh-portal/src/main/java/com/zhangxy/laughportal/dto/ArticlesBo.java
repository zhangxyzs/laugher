package com.zhangxy.laughportal.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 图文消息
 *{
 *     "articles": [{
 *      "title": TITLE,
 *     "thumb_media_id": THUMB_MEDIA_ID,
 *     "author": AUTHOR,
 *     "digest": DIGEST,
 *     "show_cover_pic": SHOW_COVER_PIC(0 / 1),
 *     "content": CONTENT,
 *     "content_source_url": CONTENT_SOURCE_URL,
 *     "need_open_comment":1,
 *     "only_fans_can_comment":1
 * }
 * @author zhangxy
 * @date 2019/12/08
 **/
@Data
@ToString
public class ArticlesBo {
    /**
     * (必填项)
     */
    private String title;
    /**
     * 图文消息的封面图片素材id（必须是永久mediaID）
     * (必填项)
     */
    private String thumbMediaId;
    private String author;
    /**
     * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。
     * 如果本字段为没有填写，则默认抓取正文前64个字。
     */
    private String digest;
    /**
     * 是否显示封面，0为false，即不显示，1为true，即显示
     * (必填项)
     */
    private Integer showCoverPic;
    /**
     * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，
     * 且此处会去除JS,涉及图片url必须来源 "上传图文消息内的图片获取URL"接口获取。
     * 外部图片url将被过滤。
     * (必填项)
     */
    private String content;
    /**
     * 图文消息的原文地址，即点击“阅读原文”后的URL
     * (必填项)
     */
    private String contentSourceUrl;
    /**
     * Uint32 是否打开评论，0不打开，1打开
     */
    private String needOpenComment;
    /**
     * Uint32 是否粉丝才可评论，0所有人可评论，1粉丝才可评论
     */
    private String onlyFansFanComment;



}
