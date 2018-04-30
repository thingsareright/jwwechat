package com.jw.bean.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseImageBean  extends WeChatResponseBaseBean{

    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
