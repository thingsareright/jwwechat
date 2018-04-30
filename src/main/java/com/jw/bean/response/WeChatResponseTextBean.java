package com.jw.bean.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseTextBean extends WeChatResponseBaseBean {

    @XStreamAlias("Content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
