package com.wanghuadi.beans;

public enum Status {
	SUCCESS("通过"),NOTSUCCESS("未通过"),WAIT("待审核");
	
	private String name;

	private Status(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
