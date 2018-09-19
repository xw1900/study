package com.xw.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.xw.mybatis.bean.Student;
import com.xw.mybatis.dao.StudentMapper;

public class MybatisDemo {

	@Test
	public void test1() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			Student student = session.selectOne("selectStudent", "S001");
			System.out.println(student);
		} finally {
			session.close();
		}
	}

	@Test
	public void test2() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession session = sqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = session.getMapper(StudentMapper.class);
			Student student = studentMapper.selectStudentByCondition("S001", "8888");
			System.out.println(student);
		} finally {
			session.close();
		}

	}
}
