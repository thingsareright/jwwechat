package com.jw.secure.impl;

import com.jw.bean.secure.WeChatSecureBean;
import com.jw.secure.VerifyTools;
import com.jw.tools.PublicTools;

import java.util.Arrays;

public class DefaultWeChatVerifyTools extends VerifyTools<WeChatSecureBean> {

    public boolean doVerify(WeChatSecureBean weChatSecureBean, String tokenStr) {

        String[] strings = new String[]{tokenStr, weChatSecureBean.getTimestamp(), weChatSecureBean.getNonce()};
        Arrays.sort(strings);
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return weChatSecureBean.getSignature().equals(PublicTools.sha1Hex(sb.toString()));
    }
}
