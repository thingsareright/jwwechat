package com.jw.bean.event;

import com.jw.bean.WeChatBaseBean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatEventBean extends WeChatBaseBean {
    
    public static final String EVENT_TYPE_OF_CLICK="CLICK";
    public static final String EVENT_TYPE_OF_LOCATION = "LOCATION";
    public static final String EVENT_TYPE_OF_SUBSCRIBE="subscribe";
    public static final String EVENT_TYPE_OF_SCAN="SCAN";
    public static final String EVENT_OF_SUBSCRIBE = "subscribe";
    public static final String EVENT_OF_UNSUBSCRIBE = "unsubscribe";


    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
