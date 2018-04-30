package com.jw.handler.impl;

import com.jw.bean.event.WeChatEventClickBean;
import com.jw.bean.event.WeChatEventLocationBean;
import com.jw.bean.event.WeChatEventQscanBean;
import com.jw.bean.event.WeChatEventSubscribeBean;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.factory.ResponseMsgBuilder;
import com.jw.handler.EventReceiveHandler;

public class DefaultEventReceiveHandler implements EventReceiveHandler {
    @Override
    public WeChatResponseBaseBean onReceiveSubscribeEvent(WeChatEventSubscribeBean msgBean, ResponseMsgBuilder builder) {
        return builder.buildDefaultSuccessTextBean();
    }

    @Override
    public WeChatResponseBaseBean onReceiveQScanEvent(WeChatEventQscanBean msgBean, ResponseMsgBuilder builder) {
        return builder.buildDefaultSuccessTextBean();

    }

    @Override
    public WeChatResponseBaseBean onReceiveLocationEvent(WeChatEventLocationBean msgBean, ResponseMsgBuilder builder) {
        return builder.buildDefaultSuccessTextBean();

    }

    @Override
    public WeChatResponseBaseBean onReceiveClickvent(WeChatEventClickBean msgBean, ResponseMsgBuilder builder) {
        return builder.buildDefaultSuccessTextBean();

    }
}
