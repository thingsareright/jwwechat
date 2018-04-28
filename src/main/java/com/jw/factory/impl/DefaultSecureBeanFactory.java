package com.jw.factory.impl;

import com.jw.bean.secure.WeChatSecureBean;
import com.jw.factory.SecureBeanFactory;
import com.jw.tools.PublicTools;

import javax.servlet.http.HttpServletRequest;


public class DefaultSecureBeanFactory extends SecureBeanFactory<WeChatSecureBean> {

    private final String SIGNATURE = "signature";
    private final String NONCE = "nonce";
    private final String TIMESTAMP = "timestamp";
    private final String ECHOSTR = "echostr";


    @Override
    public WeChatSecureBean buildFromHttpResponse(HttpServletRequest request) {
        WeChatSecureBean weChatSecureBean = new WeChatSecureBean();

        weChatSecureBean.setEchostr(PublicTools.StringNullToEmpty(request.getParameter(ECHOSTR)));
        weChatSecureBean.setNonce(PublicTools.StringNullToEmpty(request.getParameter(NONCE)));
        weChatSecureBean.setTimestamp(PublicTools.StringNullToEmpty(request.getParameter(TIMESTAMP)));
        weChatSecureBean.setSignature(PublicTools.StringNullToEmpty(request.getParameter(SIGNATURE)));

        return weChatSecureBean;
    }


}
