package com.jw.factory;

import com.jw.bean.WeChatBaseBean;

public class ResponseMsgBuilderFactory {
    public static ResponseMsgBuilder getResponseMsgBuilder(WeChatBaseBean msgBean) {
        ResponseMsgBuilder responseMsgBuilder = new ResponseMsgBuilder(msgBean);
        return responseMsgBuilder;
    }
}
