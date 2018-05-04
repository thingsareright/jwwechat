package com.jw.api.impl;

import com.google.gson.Gson;
import com.jw.api.AccessTokenApi;
import com.jw.bean.json.AccessToken;
import com.jw.factory.UnionInstanceHolder;
import com.jw.service.WeChatNetService;

import java.util.HashMap;
import java.util.Map;

public class DefaultAccessTokenApi implements AccessTokenApi {
    public static final String ERROR = "error";

    private String accessTokenStr;
    private long lastAccessTime = 0;
    private long expiresInTime = 0;

    @Override
    public String getAccessTokenStr() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAccessTime < expiresInTime && null != accessTokenStr && !"".equals(accessTokenStr)) {//AccessToken尚未过期
            return accessTokenStr;
        }
        return getWeChatAccessToken();
    }

    private String getWeChatAccessToken() {
        WeChatNetService weChatNetService = UnionInstanceHolder.getJwConfigInstance().getWeChatNetService();
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credential");
        params.put("appid", UnionInstanceHolder.getJwConfigInstance().getAppId());
        params.put("secret", UnionInstanceHolder.getJwConfigInstance().getAppSecret());
        String strResult = weChatNetService.weChatHttpGetString("cgi-bin/token", params);
        if (strResult.contains("access_token")) {
            AccessToken accessToken = new Gson().fromJson(strResult, AccessToken.class);
            this.expiresInTime = accessToken.getExpires_in() * 1000;
            this.lastAccessTime = System.currentTimeMillis();
            this.accessTokenStr = accessToken.getAccess_token();
            return accessTokenStr;
        } else {
            throw new RuntimeException(strResult);
        }
    }

}
