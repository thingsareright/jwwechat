package com.jw.config.impl;

import com.jw.config.JwConfig;
import com.jw.factory.SecureBeanFactory;
import com.jw.factory.impl.DefaultSecureBeanFactory;
import com.jw.handler.EventReceiveHandler;
import com.jw.handler.MsgReceiveHandler;
import com.jw.handler.impl.DefaultEventReceiveHandler;
import com.jw.handler.impl.DefaultMsgReceiveHandler;
import com.jw.secure.VerifyTools;
import com.jw.secure.impl.DefaultWeChatVerifyTools;

public abstract class SimpleJwConfig implements JwConfig {

    public VerifyTools getVerifyTools() {
        return new DefaultWeChatVerifyTools();
    }

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

    public String getApiUrlDomain() {
        return "api.weixin.qq.com";
    }

    public abstract String getToken();


}
