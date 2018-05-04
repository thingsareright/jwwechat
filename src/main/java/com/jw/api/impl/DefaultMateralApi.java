package com.jw.api.impl;

import com.demo.config.MyWeChatConfig;
import com.google.gson.Gson;
import com.jw.api.MaterialApi;
import com.jw.bean.json.Material;
import com.jw.bean.json.MaterialDownload;
import com.jw.factory.UnionInstanceHolder;
import com.jw.service.WeChatNetService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DefaultMateralApi implements MaterialApi {

    @Override
    public String addTempMedia(String mediaType, File file) {

        WeChatNetService weChatNetService = UnionInstanceHolder.getJwConfigInstance().getWeChatNetService();
        Map<String, String> param = new HashMap<>();
        param.put("type", mediaType);
        param.put("access_token", UnionInstanceHolder.getJwConfigInstance().getAccessTokenApi().getAccessTokenStr());
        String result = weChatNetService.weChatHttpUploadFile("/cgi-bin/media/upload", file, "media", param);
        if (null != result && result.contains("media_id")) {
            Material media = new Gson().fromJson(result, Material.class);
            return media.getMedia_id();
        } else {
            throw new RuntimeException(result);
        }

    }

    @Override
    public String getTempMedia(String meidaId) {
        WeChatNetService weChatNetService = UnionInstanceHolder.getJwConfigInstance().getWeChatNetService();

        Map<String, String> params = new HashMap<>();
        params.put("access_token", UnionInstanceHolder.getJwConfigInstance().getAccessTokenApi().getAccessTokenStr());
        params.put("media_id", meidaId);
        String result = weChatNetService.weChatHttpGetString("cgi-bin/media/get", params);
        if (null != result && result.contains("video_url")) {
            MaterialDownload materialDownload = new Gson().fromJson(result, MaterialDownload.class);
            return materialDownload.getVideo_url();
        } else {
            throw new RuntimeException(result);
        }
    }

    public static void main(String[] args) {
        UnionInstanceHolder.setJwConfigInstance(new MyWeChatConfig());
        MaterialApi api = new DefaultMateralApi();
        System.out.println(api.getTempMedia("GU8CFpyJdmY_udneR3nO37uRFJvBL4-dDlYSaE3o-_txeJaF-fQDWpkpZ5RmkUnW"));
    }

}
