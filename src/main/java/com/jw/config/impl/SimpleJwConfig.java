package com.jw.config.impl;

import com.jw.config.JwConfig;
import com.jw.factory.SecureBeanFactory;
import com.jw.factory.impl.DefaultSecureBeanFactory;
import com.jw.secure.VerifyTools;
import com.jw.secure.impl.DefaultWeChatVerifyTools;

public abstract class SimpleJwConfig implements JwConfig {

    public VerifyTools getVerifyTools() {
        return new DefaultWeChatVerifyTools();
    }

    public SecureBeanFactory getSecureBeanFactory() {
        return new DefaultSecureBeanFactory();
    }

    public abstract String getToken();
}
