package com.xw.mybatis.search;

import java.io.Serializable;
import java.util.List;

/**
 * 通用 VO 代码生成器
 * Created by maolujun on 2018/09/07.
 */
public class WebsiteTagContentSearch extends RequestSearchVO implements Serializable {

    private List<Long> contentIds;

    public List<Long> getContentIds() {
        return contentIds;
    }

    public void setContentIds(List<Long> contentIds) {
        this.contentIds = contentIds;
    }
    
    
}
