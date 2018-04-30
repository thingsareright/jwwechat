package com.jw.handler.impl;

import com.jw.bean.msg.*;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.factory.ResponseMsgBuilder;
import com.jw.handler.MsgReceiveHandler;

public abstract class SimpleMsgReceiveHandler implements MsgReceiveHandler {

    abstract public WeChatResponseBaseBean onReceiveMsgText(WeChatMsgTextBean msgBean, ResponseMsgBuilder builder);

    @Override
    public WeChatResponseBaseBean onReceiveMsgImage(WeChatImageBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }

    @Override
    public WeChatResponseBaseBean onReceiveMsgVoice(WeChatMsgVoiceBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }

    @Override
    public WeChatResponseBaseBean onReceiveMsgVideo(WeChatMsgVideoBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }

    @Override
    public WeChatResponseBaseBean onReceiveMsgShortVideo(WeChatMsgShortVideoBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }

    @Override
    public WeChatResponseBaseBean onReceiveMsgLocation(WeChatMsgLocationBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }

    @Override
    public WeChatResponseBaseBean onReceiveMsgLink(WeChatMsgLinkBean msgBean, ResponseMsgBuilder builder) {
        return null;
    }


}
