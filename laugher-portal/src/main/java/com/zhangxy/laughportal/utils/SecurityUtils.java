package com.zhangxy.laughportal.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 安全工具类
 *
 * @author zhangxy
 * @date 2019/12/04
 **/
public class SecurityUtils {
    /**
     *
     * @param val
     * @return
     */
    public static String sha1Hex(String val){
        if(StringUtils.isEmpty(val)){
            return null;
        }
        return DigestUtils.sha1Hex(val);
    }
}
