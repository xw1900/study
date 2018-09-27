package com.xw.mybatis.search;

import java.io.Serializable;
import java.util.List;

/**
 * 通用 VO 代码生成器
 * Created by maolujun on 2018/09/03.
 */
public class WebsiteContentSearch extends RequestSearchVO implements Serializable {

	private Long id;// 文章id
	private Long navId;// 文章所属导航id
	private String tags;// 文章所属标签
	private List<Long> contentIds;// 文章id集合
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNavId() {
		return navId;
	}
	public void setNavId(Long navId) {
		this.navId = navId;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public List<Long> getContentIds() {
		return contentIds;
	}
	public void setContentIds(List<Long> contentIds) {
		this.contentIds = contentIds;
	}
	
}
