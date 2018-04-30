package com.jw.handler;

import com.jw.bean.msg.*;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.factory.ResponseMsgBuilder;

public interface MsgReceiveHandler {

    WeChatResponseBaseBean onReceiveMsgText(WeChatMsgTextBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgImage(WeChatImageBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgVoice(WeChatMsgVoiceBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgVideo(WeChatMsgVideoBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgShortVideo(WeChatMsgShortVideoBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgLocation(WeChatMsgLocationBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveMsgLink(WeChatMsgLinkBean msgBean, ResponseMsgBuilder builder);
}
