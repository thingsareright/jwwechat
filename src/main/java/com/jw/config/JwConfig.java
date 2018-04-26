package com.jw.config;

import com.jw.factory.SecureBeanFactory;
import com.jw.secure.VerifyTools;

public interface JwConfig {
    VerifyTools getVerifyTools();

    SecureBeanFactory getSecureBeanFactory();

    String getToken();

}
