package com.jw.config.impl;

import com.jw.api.AccessTokenApi;
import com.jw.api.impl.DefaultAccessTokenApi;
import com.jw.config.JwConfig;
import com.jw.factory.SecureBeanFactory;
import com.jw.factory.impl.DefaultSecureBeanFactory;
import com.jw.handler.EventReceiveHandler;
import com.jw.handler.MsgReceiveHandler;
import com.jw.handler.impl.DefaultEventReceiveHandler;
import com.jw.handler.impl.DefaultMsgReceiveHandler;
import com.jw.secure.VerifyTools;
import com.jw.secure.impl.DefaultWeChatVerifyTools;
import com.jw.service.WeChatNetService;
import com.jw.service.impl.DefaultWeChatNetService;

public abstract class SimpleJwConfig implements JwConfig {

    @Override
    public VerifyTools getVerifyTools() {
        return new DefaultWeChatVerifyTools();
    }

    @Override
    public SecureBeanFactory getSecureBeanFactory() {
        return new DefaultSecureBeanFactory();
    }

    @Override
    public EventReceiveHandler getEventReceiveHandler() {
        return new DefaultEventReceiveHandler();
    }

    @Override
    public MsgReceiveHandler getMsgReceiveHandler() {
        return new DefaultMsgReceiveHandler();
    }

    @Override
    public AccessTokenApi getAccessTokenApi() {
        return new DefaultAccessTokenApi();
    }


    @Override
    public String getApiUrlDomain() {
        return "api.weixin.qq.com";
    }

    @Override
    public WeChatNetService getWeChatNetService() {
        return new DefaultWeChatNetService();
    }

    @Override
    public abstract String getToken();

    @Override
    public abstract String getAppId();

    @Override
    public abstract String getAppSecret();

}
