package com.jw.config;

import com.jw.factory.SecureBeanFactory;
import com.jw.handler.EventReceiveHandler;
import com.jw.handler.MsgReceiveHandler;
import com.jw.secure.VerifyTools;

public interface JwConfig {
    VerifyTools getVerifyTools();

    SecureBeanFactory getSecureBeanFactory();

    EventReceiveHandler getEventReceiveHandler();

    MsgReceiveHandler getMsgReceiveHandler();

    String getToken();

}
