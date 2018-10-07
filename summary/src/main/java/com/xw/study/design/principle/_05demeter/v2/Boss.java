package com.xw.study.design.principle._05demeter.v2;

public class Boss {
	public void commandCheckNumbers(TeamLeader teamLeader){
		teamLeader.checkNumbers();
	}
}
