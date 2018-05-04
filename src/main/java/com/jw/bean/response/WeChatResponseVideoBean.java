package com.jw.bean.response;

import com.jw.bean.response.inner.Video;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseVideoBean extends WeChatResponseBaseBean {

    @XStreamAlias("Video")
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
