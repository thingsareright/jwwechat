package com.jw.bean.msg;

public class WeChatMsgVoiceBean extends WeChatMsgTextBean {

    public static final String VOICE_TYPE_AMR = "amr";
    public static final String VOICE_TYPE_SPEEX = "speex";

    private String mediaId;
    private String format;
    private String recognition;

    public static String getVoiceTypeAmr() {
        return VOICE_TYPE_AMR;
    }

    public static String getVoiceTypeSpeex() {
        return VOICE_TYPE_SPEEX;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }
}
