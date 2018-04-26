package com.jw.handler;

public interface VerifyHandler<SECURE_BEAN> {
    void onVerifySuccess(SECURE_BEAN secureBean);

    void onVerifyFailer(SECURE_BEAN secureBean);
}
