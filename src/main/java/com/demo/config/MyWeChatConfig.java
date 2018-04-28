package com.demo.config;

import com.jw.bean.msg.WeChatMsgTextBean;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.bean.response.WeChatResponseTextBean;
import com.jw.config.impl.SimpleJwConfig;
import com.jw.factory.ResponseMsgBuilder;
import com.jw.handler.MsgReceiveHandler;
import com.jw.handler.impl.SimpleMsgReceiveHandler;

public class MyWeChatConfig extends SimpleJwConfig {
    @Override
    public String getToken() {
        return "simplejian";
    }


    @Override
    public MsgReceiveHandler getMsgReceiveHandler() {
        return new SimpleMsgReceiveHandler() {
            @Override
            public WeChatResponseBaseBean onReceiveMsgText(WeChatMsgTextBean msgBean, ResponseMsgBuilder builder) {
                WeChatResponseTextBean textBean = builder.buildResponseTextBean();
                textBean.setContent("copy that");
                return textBean;
            }
        };
    }
}
