package com.jw.servlet;

import com.jw.bean.WeChatSecureBean;
import com.jw.config.JwConfig;
import com.jw.handler.impl.DefaultVerifyHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    }

}
