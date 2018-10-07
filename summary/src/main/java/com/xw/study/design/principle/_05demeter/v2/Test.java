package com.xw.study.design.principle._05demeter.v2;

public class Test {
	// 例子：boss通过teamLeader查看课程数量
	public static void main(String[] args) {
		Boss boss = new Boss();
		TeamLeader leader = new TeamLeader();
		boss.commandCheckNumbers(leader);
	}
}
