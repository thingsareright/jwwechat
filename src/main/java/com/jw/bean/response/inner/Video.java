package com.jw.bean.response.inner;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Video extends Base {


    @XStreamAlias("Title")
    private String title;


    @XStreamAlias("Description")
    private String description;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
