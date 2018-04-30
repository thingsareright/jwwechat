package com.jw.handler;

import com.jw.bean.event.WeChatEventClickBean;
import com.jw.bean.event.WeChatEventLocationBean;
import com.jw.bean.event.WeChatEventQscanBean;
import com.jw.bean.event.WeChatEventSubscribeBean;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.factory.ResponseMsgBuilder;

public interface EventReceiveHandler {
    /**
     * 关注/取消关注事件
     * @param msgBean
     * @param builder
     * @return
     */
    WeChatResponseBaseBean onReceiveSubscribeEvent(WeChatEventSubscribeBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveQScanEvent(WeChatEventQscanBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveLocationEvent(WeChatEventLocationBean msgBean, ResponseMsgBuilder builder);

    WeChatResponseBaseBean onReceiveClickvent(WeChatEventClickBean msgBean, ResponseMsgBuilder builder);



}
