package com.jw.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
@XStreamAlias("xml")
public class WeChatBaseBean {

    public static final String MSGTYPE_OF_TEXT = "text";
    public static final String MSGTYPE_OF_IMAGE = "image";
    public static final String MSGTYPE_OF_VOICE = "voice";
    public static final String MSGTYPE_OF_VIDEO = "video";
    public static final String MSGTYPE_OF_SHORTVIDEO = "shortvideo";
    public static final String MSGTYPE_OF_LOCATION = "location";
    public static final String MSGTYPE_OF_LINK = "link";
    public static final String MSGTYPE_OF_EVENT = "event";

    @XStreamAlias("ToUserName")
    private String toUserName;

    @XStreamAlias("FromUserName")
    private String fromUserName;

    @XStreamAlias("CreateTime")
    private String createTime;

    @XStreamAlias("MsgType")
    private String msgType;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
