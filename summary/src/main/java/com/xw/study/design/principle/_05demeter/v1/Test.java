package com.xw.study.design.principle._05demeter.v1;

public class Test {
	// 例子：boss通过teamLeader查看课程数量
	// 问题：违背了迪米特原则，
		// boss的commandCheckNumbers中和陌生人Course说话了。
	public static void main(String[] args) {
		Boss boss = new Boss();
		TeamLeader leader = new TeamLeader();
		boss.commandCheckNumbers(leader);
	}
}
