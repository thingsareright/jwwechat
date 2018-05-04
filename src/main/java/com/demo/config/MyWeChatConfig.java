package com.demo.config;

import com.jw.bean.msg.WeChatImageBean;
import com.jw.bean.msg.WeChatMsgTextBean;
import com.jw.bean.msg.WeChatMsgVideoBean;
import com.jw.bean.msg.WeChatMsgVoiceBean;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.bean.response.WeChatResponseImageBean;
import com.jw.bean.response.WeChatResponseVideoBean;
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
    public String getAppId() {
        return "wxac0d817f64dd27b4";
    }

    @Override
    public String getAppSecret() {
        return "f529b030d0fde3da5108bc1f089a7304";
    }

    @Override
    public MsgReceiveHandler getMsgReceiveHandler() {
        return new SimpleMsgReceiveHandler() {
            @Override
            public WeChatResponseBaseBean onReceiveMsgText(WeChatMsgTextBean msgBean, ResponseMsgBuilder builder) {

                return builder.buildResponseVoiceBean(msgBean.getContent());
            }

            @Override
            public WeChatResponseBaseBean onReceiveMsgImage(WeChatImageBean msgBean, ResponseMsgBuilder builder) {
                return builder.buildResponseTextBean(msgBean.getMediaId());
            }

            @Override
            public WeChatResponseBaseBean onReceiveMsgVideo(WeChatMsgVideoBean msgBean, ResponseMsgBuilder builder) {
                return builder.buildResponseTextBean(msgBean.getMediaId());
            }

            @Override
            public WeChatResponseBaseBean onReceiveMsgVoice(WeChatMsgVoiceBean msgBean, ResponseMsgBuilder builder) {
                return builder.buildResponseTextBean(msgBean.getMediaId());
            }
        };
    }
}
