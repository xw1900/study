package com.xw.mybatis.bean;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Student {

	private String studentno;
	private String studentName;
	private String loginpwd;
	private String sex;
	private int majorId;
	private String phone;
	private String email;
	private Date bornDate;
	private Boolean status;
	
}
