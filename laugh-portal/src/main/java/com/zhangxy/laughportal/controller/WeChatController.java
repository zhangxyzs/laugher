package com.zhangxy.laughportal.controller;

import com.zhangxy.laughportal.dto.BaseMsg;
import com.zhangxy.laughportal.dto.InMsgInfo;
import com.zhangxy.laughportal.dto.OutMsgInfo;
import com.zhangxy.laughportal.service.MsgTypeHandler;
import com.zhangxy.laughportal.utils.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * 微信验证控制器
 *
 * @author zhangxy
 * @date 2019/12/04
 **/
@RestController
@Slf4j
@RequestMapping("/wechat")
public class WeChatController {

    @Value("${wechat.appToken}")
    private String appToken;
    @Autowired
    private List<MsgTypeHandler> handlerList;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(String signature, String timestamp, String nonce, String echostr) {
        // 1）将token、timestamp、nonce三个参数进行字典序排序
        String[] array=new String[]{appToken,timestamp,nonce};
        Arrays.sort(array);
        // 2）将三个参数字符串拼接成一个字符串进行sha1加密
        StringBuilder sb=new StringBuilder();
        for(String str:array){
            sb.append(str);
        }
        // 3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        String mysignature= SecurityUtils.sha1Hex(sb.toString());
        if(signature.equals(mysignature)){
            return echostr;
        }
        return null;
    }

    /**
     * 注意添加produces类型为 MediaType.TEXT_XML_VALUE，我没有加这个，搞了好久
     * @param msgInfo
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST,produces= {MediaType.TEXT_XML_VALUE})
    public BaseMsg handleMsg(@RequestBody InMsgInfo msgInfo){
        OutMsgInfo out=new OutMsgInfo();
        log.info("消息内容{}",msgInfo.toString());
        for(MsgTypeHandler handler:handlerList){
            if(handler.canSupport(msgInfo)){
                return handler.handlerMsg(msgInfo);
            }
        }
        //这里算降级策略
        out.setToUserName(msgInfo.getFromUserName());
        out.setFromUserName(msgInfo.getToUserName());
        out.setMsgType("text");
        out.setContent("服务异常，请稍后重试");
        out.setCreateTime(System.currentTimeMillis()/1000);
        return out;
    }
}
