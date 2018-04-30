package com.jw.factory;

import com.jw.bean.WeChatBaseBean;
import com.jw.bean.response.*;

public class ResponseMsgBuilder {
    private String requestToUserName;
    private String requestFromUserName;

    public ResponseMsgBuilder(WeChatBaseBean msgBean) {
        this.requestFromUserName = msgBean.getFromUserName();
        this.requestToUserName = msgBean.getToUserName();
    }

    public WeChatResponseTextBean buildDefaultSuccessTextBean() {
        WeChatResponseTextBean defaultBean = new WeChatResponseTextBean();
        doBuildBaseBean(defaultBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_TEXT);
        defaultBean.setContent("success");
        return defaultBean;
    }

    public String buildDefaultEmtpyMsg() {
        return "";
    }

    public WeChatResponseTextBean buildResponseTextBean() {
        WeChatResponseTextBean textBean = new WeChatResponseTextBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_TEXT);
        return textBean;
    }

    public WeChatResponseImageBean buildResponseImageBean() {
        WeChatResponseImageBean textBean = new WeChatResponseImageBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_IMAGE);
        return textBean;
    }

    public WeChatResponseVoiceBean buildResponseVoiceBean() {

        WeChatResponseVoiceBean textBean = new WeChatResponseVoiceBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_VOICE);
        return textBean;
    }

    public WeChatResponseVideoBean buildResponseVideoBean() {

        WeChatResponseVideoBean textBean = new WeChatResponseVideoBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_VIDEO);
        return textBean;

    }

    public WeChatResponseMusicBean buildResponseMusciBean() {

        WeChatResponseMusicBean textBean = new WeChatResponseMusicBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_MUSIC);
        return textBean;

    }

    public WeChatResponseNewsBean buildResponstNewsBean() {

        WeChatResponseNewsBean textBean = new WeChatResponseNewsBean();
        doBuildBaseBean(textBean, WeChatResponseBaseBean.RESPONSE_TYPE_OF_NEWS);
        return textBean;
    }

    private void doBuildBaseBean(WeChatResponseBaseBean bean, String msgType) {
        bean.setFromUserName(this.requestToUserName);
        bean.setToUserName(this.requestFromUserName);
        bean.setCreateTime(System.currentTimeMillis() + "");
        bean.setMsgType(msgType);
    }


}
