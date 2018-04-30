package com.jw.factory;

import com.jw.config.JwConfig;
import com.jw.exception.JwConfigWithNullException;

public class UnionInstanceHolder {

    private static JwConfig jwConfigInstance;

    public static JwConfig getJwConfigInstance() {

        if (null == UnionInstanceHolder.jwConfigInstance) {
            throw new JwConfigWithNullException();
        }

        return jwConfigInstance;

    }

    public static void setJwConfigInstance(JwConfig configInstance) {
        if (null != UnionInstanceHolder.jwConfigInstance || configInstance == null) {
            throw new JwConfigWithNullException();
        }

        UnionInstanceHolder.jwConfigInstance = configInstance;
    }


}
