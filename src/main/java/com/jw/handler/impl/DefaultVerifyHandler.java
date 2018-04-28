package com.jw.handler.impl;

import com.jw.bean.secure.WeChatSecureBean;
import com.jw.handler.VerifyHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultVerifyHandler implements VerifyHandler<WeChatSecureBean> {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public DefaultVerifyHandler(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }


    public void onVerifySuccess(WeChatSecureBean weChatSecureBean) {
        try {
            response.getWriter().print(weChatSecureBean.getEchostr());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onVerifyFailer(WeChatSecureBean weChatSecureBean) {

    }
}
