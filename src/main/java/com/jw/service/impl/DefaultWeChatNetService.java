package com.jw.service.impl;

import com.jw.service.WeChatNetService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultWeChatNetService extends WeChatNetService {
    @Override
    protected String baseUploadFile(String domainNamePrefix, String domainNameSuffix, File localFile, String serverFieldName, Map<String, String> params) throws Exception {
        String respStr = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost(buildDomainName(domainNamePrefix, domainNameSuffix));
            FileBody binFileBody = new FileBody(localFile);

            MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder
                    .create();
            // add the file params
            multipartEntityBuilder.addPart(serverFieldName, binFileBody);
            // 设置上传的其他参数
            setUploadParams(multipartEntityBuilder, params);

            HttpEntity reqEntity = multipartEntityBuilder.build();
            httppost.setEntity(reqEntity);

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity resEntity = response.getEntity();
                respStr = getRespString(resEntity);
                EntityUtils.consume(resEntity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return respStr;
    }

    @Override
    protected InputStream baseHttpRequest(String domainNamePrefix, String domainNameSuffix, Map<String, String> mapParams, InputStream is, String httpMethodName) throws Exception {

        String domainName = buildDomainName(domainNamePrefix, domainNameSuffix);
        String strURL = buildUrlWithParam(domainName, mapParams);

        URL url = new URL(strURL);// 创建连接
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(httpMethodName); // 设置请求方式
        connection.setDoOutput(true);
        connection.connect();

        OutputStream connOutStream = connection.getOutputStream();

        if (is != null && is.available() > 0 && connOutStream != null) {
            byte[] bytes = new byte[1024];
            int length;
            while ((length = is.read(bytes)) != -1) {
                connOutStream.write(bytes, 0, length);
            }
            is.close();
            connOutStream.flush();
            connOutStream.close();
        }

        return connection.getInputStream();
    }

    private String buildDomainName(String domainNamePrefix, String domainNameSuffix) {

        if (!domainNamePrefix.contains("https://") || !domainNamePrefix.contains("http://")) {
            domainNamePrefix = "https://" + domainNamePrefix;
        }

        if (domainNameSuffix.charAt(0) != '/') {
            domainNameSuffix = '/' + domainNameSuffix;
        }

        return domainNamePrefix + domainNameSuffix;

    }

    private String buildUrlWithParam(String domainName, Map<String, String> mapParams) {
        if (mapParams.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : mapParams.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return domainName + "?" + sb.toString();
    }

    private void setUploadParams(MultipartEntityBuilder multipartEntityBuilder,
                                 Map<String, String> params) {
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                multipartEntityBuilder
                        .addPart(key, new StringBody(params.get(key),
                                ContentType.TEXT_PLAIN));
            }
        }
    }


    private String getRespString(HttpEntity entity) throws Exception {
        if (entity == null) {
            return null;
        }
        InputStream is = entity.getContent();
        StringBuffer strBuf = new StringBuffer();
        byte[] buffer = new byte[4096];
        int r = 0;
        while ((r = is.read(buffer)) > 0) {
            strBuf.append(new String(buffer, 0, r, "UTF-8"));
        }
        return strBuf.toString();
    }

}
