package com.xw.mybatis.search;

import java.io.Serializable;

/**
 * 通用 VO 代码生成器
 * Created by maolujun on 2018/09/03.
 */
public class WebsiteTagSearch extends RequestSearchVO implements Serializable {

	//1-企业类型,2-企业规模,3-常用功能,4-使用目的
	private Integer type;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}


	
}
