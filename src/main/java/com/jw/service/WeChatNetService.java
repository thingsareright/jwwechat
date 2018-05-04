package com.jw.service;

import com.jw.factory.UnionInstanceHolder;
import com.jw.tools.PublicTools;

import java.io.*;
import java.util.Map;


public abstract class WeChatNetService {


    public String weChatHttpGetString(String domainSuffix, Map<String, String> params)  {
        InputStream is = weChatHttpGet(domainSuffix, params, null);
        try {
            return PublicTools.getStrFromStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String weChatHttpPostStr(String domainSuffix, Map<String, String> params, InputStream is) {
        InputStream is2 = weChatHttpPost(domainSuffix, params, is);
        try {
            return PublicTools.getStrFromStream(is2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


    public InputStream weChatHttpGet(String domainSuffix, Map<String, String> params, InputStream is) {
        try {
            return baseHttpRequest(UnionInstanceHolder.getJwConfigInstance().getApiUrlDomain(), domainSuffix, params, is, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public InputStream weChatHttpPost(String domainSuffix, Map<String, String> params, InputStream is) {
        try {
            return baseHttpRequest(UnionInstanceHolder.getJwConfigInstance().getApiUrlDomain(), domainSuffix, params, is, "POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String weChatHttpUploadFile(String domainNameSuffix, File file, String serverFiledName, Map<String, String> params) {
        try {
            return baseUploadFile(UnionInstanceHolder.getJwConfigInstance().getApiUrlDomain(),domainNameSuffix,file,serverFiledName,params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    protected abstract String baseUploadFile(String domainNamePrefix, String domainNameSuffix, File localFile, String serverFieldName, Map<String, String> params) throws Exception;

    protected abstract InputStream baseHttpRequest(String domainNamePrefix, String domainNameSuffix, Map<String, String> mapParams, InputStream is, String httpMethodName) throws Exception;

}