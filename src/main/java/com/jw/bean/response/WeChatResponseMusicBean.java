package com.jw.bean.response;

import com.jw.bean.response.inner.Music;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseMusicBean extends WeChatResponseBaseBean {
    @XStreamAlias("Music")
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
