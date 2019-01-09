package com.xw.mybatis.bean;

import java.io.Serializable;

public class WebsiteTagContent implements Serializable {
    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 文章id
     */
    private Long contentId;

    private static final long serialVersionUID = 1L;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
}