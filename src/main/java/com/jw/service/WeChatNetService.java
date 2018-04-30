package com.jw.service;

import com.jw.factory.UnionInstanceHolder;

import java.io.InputStream;
import java.util.Map;


public abstract class WeChatNetService {


    InputStream weChatHttpGet(Map<String, String> params,InputStream is) {
        try {
            return baseHttpRequest(UnionInstanceHolder.getJwConfigInstance().getApiUrlDomain(),params,is,"GET");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    InputStream weChatHttpPost(Map<String, String> params,InputStream is) {
        try {
            return baseHttpRequest(UnionInstanceHolder.getJwConfigInstance().getApiUrlDomain(),params,is,"POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected abstract InputStream baseHttpRequest(String domainNameOnly, Map<String, String> mapParams, InputStream is, String httpMethodName) throws Exception;

}