package com.xw.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xw.mybatis.bean.WebsiteContent;
import com.xw.mybatis.dao.WebsiteContentMapper;
import com.xw.mybatis.search.WebsiteContentSearch;

public class WebSiteDemo {

	@Test
	public void test2() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			WebsiteContentMapper websiteContentMapper = session.getMapper(WebsiteContentMapper.class);
//			WebsiteContentSearch websiteContentSearch = new WebsiteContentSearch();
//			websiteContentSearch.setNavId(17L);
			List<WebsiteContent> queryBaseByCondition = websiteContentMapper.testCollections();
						
			System.out.println(queryBaseByCondition.size());
			System.out.println(queryBaseByCondition.get(0).getTagContents().size());
		} finally {
			session.close();
		}

	}
}
