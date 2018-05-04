package com.jw.config;

import com.jw.api.AccessTokenApi;
import com.jw.factory.SecureBeanFactory;
import com.jw.handler.EventReceiveHandler;
import com.jw.handler.MsgReceiveHandler;
import com.jw.secure.VerifyTools;
import com.jw.service.WeChatNetService;

public interface JwConfig {


    VerifyTools getVerifyTools();

    SecureBeanFactory getSecureBeanFactory();

    EventReceiveHandler getEventReceiveHandler();

    MsgReceiveHandler getMsgReceiveHandler();

    WeChatNetService getWeChatNetService();

    AccessTokenApi getAccessTokenApi();

    String getToken();

    String getApiUrlDomain();

    String getAppId();

    String getAppSecret();

}
