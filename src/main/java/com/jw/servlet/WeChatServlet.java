package com.jw.servlet;

import com.jw.bean.WeChatMsgBean;
import com.jw.bean.WeChatSecureBean;
import com.jw.config.JwConfig;
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
        switch (msgType) {
            case WeChatMsgBean.MSGTYPE_OF_TEXT:
                break;
            case WeChatMsgBean.MSGTYPE_OF_IMAGE:
                break;
            case WeChatMsgBean.MSGTYPE_OF_VOICE:
                break;
            case WeChatMsgBean.MSGTYPE_OF_VIDEO:
                break;
            case WeChatMsgBean.MSGTYPE_OF_SHORTVIDEO:
                break;
            case WeChatMsgBean.MSGTYPE_OF_LOCATION:
                break;
            case WeChatMsgBean.MSGTYPE_OF_LINK:
                break;

        }
    }

}
