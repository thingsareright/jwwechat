package com.jw.service.impl;

import com.jw.service.WeChatNetService;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class DefaultWeChatNetService extends WeChatNetService {
    @Override
    protected InputStream baseHttpRequest(String domainNameOnly, Map<String, String> mapParams, InputStream is, String httpMethodName) throws Exception {
        String strURL = buildUrlWithParam(domainNameOnly, mapParams);

        URL url = new URL(strURL);// 创建连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethodName); // 设置请求方式
        connection.connect();

        OutputStream connOutStream = connection.getOutputStream();
        byte[] bytes = new byte[1024];
        int length;
        while ((length = is.read(bytes)) != -1) {
            connOutStream.write(bytes, 0, length);
        }

        connOutStream.flush();
        is.close();
        connOutStream.close();

        return connection.getInputStream();
    }

    private String buildUrlWithParam(String domainNameOnly, Map<String, String> mapParams) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : mapParams.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return domainNameOnly + "?" + sb.toString();

    }
}
