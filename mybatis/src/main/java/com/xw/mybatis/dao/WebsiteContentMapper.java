package com.xw.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.xw.mybatis.bean.WebsiteContent;
import com.xw.mybatis.search.WebsiteContentSearch;

/**
 * 通用 Mapper 代码生成器
 * Created by maolujun on 2018/09/03.
 */
public interface WebsiteContentMapper {
	
	List<WebsiteContent> queryBaseByCondition(WebsiteContentSearch websiteContentSearch);
	List<WebsiteContent> testCollections();
	
}




