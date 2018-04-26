package com.jw.secure;

import com.jw.handler.VerifyHandler;

public abstract class VerifyTools<SECURE_BEAN> {

    public void verifyBiz(SECURE_BEAN secureBean,String tokenStr, VerifyHandler handler) {
        boolean verifyResult = doVerify(secureBean,tokenStr);
        if (verifyResult) {
            handler.onVerifySuccess(secureBean);
        } else {
            handler.onVerifyFailer(secureBean);
        }
    }

    protected abstract boolean doVerify(SECURE_BEAN secure_bean,String tokenStr);
}
