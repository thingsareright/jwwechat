package com.jw.tools;

import org.apache.commons.codec.digest.DigestUtils;

public class PublicTools {

    private PublicTools() {
    }

    public static String StringNullToEmpty(String nullAble) {
        if (null == nullAble) {
            return "";
        }
        return nullAble;
    }

    public static String sha1Hex(String str) {
        return DigestUtils.sha1Hex(str);
    }
}
