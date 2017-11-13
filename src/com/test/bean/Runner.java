package com.test.bean;

public class Runner implements Hobby {

	private Hobby hobby;
	
	public Runner(Hobby hobby) {
		this.hobby = hobby;
	}
	
	public Runner() {
	}

	@Override
	public void running() {
		hobby.running();
	}
	
}
