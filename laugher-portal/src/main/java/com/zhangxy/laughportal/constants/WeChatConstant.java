package com.zhangxy.laughportal.constants;

/**
 * 微信公共常量
 *
 * @author zhangxy
 * @date 2019/12/05
 **/
public class WeChatConstant {
    /*获取参数*/
    public static final String GET_ACCESS_TOKEN_URL
            ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /*创建菜单*/
    public static final String CREATE_MENU=
            "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /*上传素材*/
    public static final String UPLOAD_MATERIAL =
            "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    /*新增永久图文素材(永久)*/
    public static final String ADD_NEWS=
            "https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";
    /*上传图文消息内的图片获取URL(永久)*/
    public static final String UPLOADIMG=
            "https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";
    /*新增其他类型永久素材(永久)*/
    public static final String ADD_MATERIAL=
            "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    public static final String MATERIAL_TYPE_IMAGE="image";
    public static final String MATERIAL_TYPE_VOICE="voice";
    public static final String MATERIAL_TYPE_VIDEO="video";
    //缩略图
    public static final String MATERIAL_TYPE_THUMB="thumb";
}
