package com.demo.config;

import com.jw.config.impl.SimpleJwConfig;

public class MyWeChatConfig extends SimpleJwConfig {
    @Override
    public String getToken() {
        return "simplejian";
    }
}
