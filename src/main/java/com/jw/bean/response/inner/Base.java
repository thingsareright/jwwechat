package com.jw.bean.response.inner;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Base {
    
    @XStreamAlias("MediaId")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

}
