package com.jw.servlet;

import com.jw.bean.WeChatBaseBean;
import com.jw.bean.event.*;
import com.jw.bean.msg.*;
import com.jw.bean.response.WeChatResponseBaseBean;
import com.jw.bean.secure.WeChatSecureBean;
import com.jw.config.JwConfig;
import com.jw.factory.ResponseMsgBuilderFactory;
import com.jw.factory.UnionInstanceHolder;
import com.jw.handler.impl.DefaultVerifyHandler;
import com.jw.tools.PublicTools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class WeChatServlet extends HttpServlet {

    private JwConfig jwConfig;
    private final String JW_CONFIG_CLASS = "jwconfigclass";

    @Override
    public void init() throws ServletException {
        String jwConfigClass = getServletContext().getInitParameter(JW_CONFIG_CLASS);
        if (null == jwConfigClass || "".equals(jwConfigClass)) {
            throw new RuntimeException("you must config your config class");
        }
        try {
            Class configClass = Class.forName(jwConfigClass);
            this.jwConfig = (JwConfig) configClass.newInstance();
            UnionInstanceHolder.setJwConfigInstance(jwConfig);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | Error e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WeChatSecureBean weChatSecureBean = (WeChatSecureBean) jwConfig.getSecureBeanFactory().buildSecureBean(req);
        jwConfig.getVerifyTools().verifyBiz(weChatSecureBean, jwConfig.getToken(), new DefaultVerifyHandler(req, resp));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String> entityMap = PublicTools.getMapFromStream(req.getInputStream());
        String msgType = entityMap.get("MsgType");

        WeChatBaseBean msgBean = null;
        WeChatResponseBaseBean responseBaseBean = null;

        switch (msgType) {
            case WeChatBaseBean.MSGTYPE_OF_TEXT:
                msgBean = PublicTools.getEntityByMap(WeChatMsgTextBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgText((WeChatMsgTextBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_IMAGE:
                msgBean = PublicTools.getEntityByMap(WeChatImageBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgImage((WeChatImageBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_VOICE:
                msgBean = PublicTools.getEntityByMap(WeChatMsgVoiceBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgVoice((WeChatMsgVoiceBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_VIDEO:
                msgBean = PublicTools.getEntityByMap(WeChatMsgVideoBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgVideo((WeChatMsgVideoBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_SHORTVIDEO:
                msgBean = PublicTools.getEntityByMap(WeChatMsgShortVideoBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgShortVideo((WeChatMsgShortVideoBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_LOCATION:
                msgBean = PublicTools.getEntityByMap(WeChatMsgLocationBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgLocation((WeChatMsgLocationBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_LINK:
                msgBean = PublicTools.getEntityByMap(WeChatMsgLinkBean.class, entityMap);
                responseBaseBean = jwConfig.getMsgReceiveHandler().onReceiveMsgLink((WeChatMsgLinkBean) msgBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean));
                break;

            case WeChatBaseBean.MSGTYPE_OF_EVENT:
                String eventType = entityMap.get("Event");

                WeChatEventBean baseBean = null;

                switch (eventType) {
                    case WeChatEventBean.EVENT_OF_SUBSCRIBE:
                        baseBean = PublicTools.getEntityByMap(WeChatEventSubscribeBean.class, entityMap);
                        responseBaseBean = jwConfig.getEventReceiveHandler().onReceiveQScanEvent((WeChatEventQscanBean) baseBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(baseBean));
                        break;

                    case WeChatEventBean.EVENT_OF_UNSUBSCRIBE:
                        baseBean = PublicTools.getEntityByMap(WeChatEventSubscribeBean.class, entityMap);
                        responseBaseBean = jwConfig.getEventReceiveHandler().onReceiveSubscribeEvent((WeChatEventSubscribeBean) baseBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(baseBean));
                        break;

                    case WeChatEventBean.EVENT_TYPE_OF_CLICK:
                        baseBean = PublicTools.getEntityByMap(WeChatEventClickBean.class, entityMap);
                        responseBaseBean = jwConfig.getEventReceiveHandler().onReceiveClickvent((WeChatEventClickBean) baseBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(baseBean));
                        break;

                    case WeChatEventBean.EVENT_TYPE_OF_LOCATION:
                        baseBean = PublicTools.getEntityByMap(WeChatEventLocationBean.class, entityMap);
                        responseBaseBean = jwConfig.getEventReceiveHandler().onReceiveLocationEvent((WeChatEventLocationBean) baseBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(baseBean));
                        break;

                    case WeChatEventBean.EVENT_TYPE_OF_SCAN:
                        baseBean = PublicTools.getEntityByMap(WeChatEventQscanBean.class, entityMap);
                        responseBaseBean = jwConfig.getEventReceiveHandler().onReceiveQScanEvent((WeChatEventQscanBean) baseBean, ResponseMsgBuilderFactory.getResponseMsgBuilder(baseBean));
                        break;
                }
                break;
            default:
                responseBaseBean = ResponseMsgBuilderFactory.getResponseMsgBuilder(msgBean).buildDefaultSuccessTextBean();
        }

        String xml = PublicTools.getXmlStrfromEnity(responseBaseBean);
        resp.getWriter().print(xml);
        resp.getWriter().flush();
        resp.getWriter().close();
    }

}
