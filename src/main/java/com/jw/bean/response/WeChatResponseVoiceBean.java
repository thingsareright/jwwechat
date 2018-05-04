package com.jw.bean.response;

import com.jw.bean.response.inner.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseVoiceBean extends WeChatResponseBaseBean {
    @XStreamAlias("Voice")
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }
}
