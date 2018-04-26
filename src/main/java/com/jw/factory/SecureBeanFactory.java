package com.jw.factory;

import javax.servlet.http.HttpServletRequest;

public abstract class SecureBeanFactory<BEAN> {

    protected abstract BEAN buildFromHttpResponse(HttpServletRequest request);

    public BEAN buildSecureBean(HttpServletRequest request) {
        BEAN bean = buildFromHttpResponse(request);
        return bean;
    }

}
