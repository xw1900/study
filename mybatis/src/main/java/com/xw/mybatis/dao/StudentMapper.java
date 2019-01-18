package com.xw.mybatis.dao;

import org.apache.ibatis.annotations.Param;

import com.xw.mybatis.bean.Student;

public interface StudentMapper {

	Student selectStudent(String studentNo);
	
	Student selectStudentByCondition(@Param("studentno")String studentNo, @Param("loginpwd")String loginPwd);
	
	int updateById(Student student);
}
