package com.jw.bean.event;

public class WeChatEventSubscribeBean extends WeChatEventBean {
    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    private String eventKey;
}
