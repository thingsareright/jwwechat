package com.jw.bean.response;

import com.jw.bean.response.inner.Image;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class WeChatResponseImageBean  extends WeChatResponseBaseBean{

    @XStreamAlias("Image")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
