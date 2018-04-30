package com.jw.handler.impl;

import com.jw.bean.msg.WeChatMsgTextBean;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.factory.ResponseMsgBuilder;

public class DefaultMsgReceiveHandler extends SimpleMsgReceiveHandler {

    @Override
    public WeChatResponseBaseBean onReceiveMsgText(WeChatMsgTextBean msgBean, ResponseMsgBuilder builder) {
        return builder.buildDefaultSuccessTextBean();
    }
}
