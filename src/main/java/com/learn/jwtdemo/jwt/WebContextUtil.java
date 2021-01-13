package com.learn.jwtdemo.jwt;

import com.alibaba.fastjson.JSONObject;
import com.learn.jwtdemo.bean.UserToken;

/**
 * @Description: 线程缓存工具
 * @Author: lh
 * @Date: 2021/1/12 15:10
 **/
public class WebContextUtil {

    /**
     * 本地缓存 token
     */
    private static ThreadLocal<String> local = new ThreadLocal<>();

    /**
     * 设置 token
     *
     * @param content
     */
    public static void setUserToken(String content) {
        removeUserToken();
        local.set(content);
    }

    /**
     * 获取 token
     *
     * @return token
     */
    public static UserToken getUserToken() {
        if (local.get() == null) {
            return null;
        }

        return JSONObject.parseObject(local.get(), UserToken.class);
    }

    public static void removeUserToken() {
        if (local.get() == null) {
            return;
        }

        local.remove();
    }

}
