package com.xw.mybatis.search;

import java.io.Serializable;

/**
 * 通用 VO 代码生成器
 * Created by maolujun on 2018/09/03.
 */
public class WebsiteNavSearch extends RequestSearchVO implements Serializable {
	
    private Integer type; //导航类型

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
