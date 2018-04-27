package com.jw.tools;

import org.apache.commons.codec.digest.DigestUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    /**
     * 从输入流中获取xml文档，并把xml文档转为map对象返回
     *
     * @return
     */
    public static Map<String, String> getMapFromStream(InputStream is) {
        Map<String, String> map = new HashMap<String, String>();

        SAXReader reader = new SAXReader();
        List<Element> elements = null;

        try {
            elements = reader.read(is).getRootElement().elements();
        } catch (DocumentException e) {
            e.printStackTrace();
            map.put("MsgType", null);
            return map;
        }

        for (Element element : elements) {
            map.put(element.getName(), element.getText());
        }
        return map;
    }

    /**
     * 根据map获取传来的值信息
     *
     * @param instance
     * @param map
     * @param <T>
     * @return
     */
    public static <T> T getEntityByMap(Class<T> instance, Map<String, String> map) {
        T t = null;
        try {
            t = instance.newInstance();

            Set<String> keys = map.keySet();

            for (String key : keys) {
                String value = map.get(key);
                Method method = instance.getMethod("set" + key, String.class);
                method.invoke(t, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }



}
