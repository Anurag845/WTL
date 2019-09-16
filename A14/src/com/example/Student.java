package com.example;

public class Student {
	
	private String name;
	private int roll_no;
	private String addr;
	
	public Student() {}
	
	public Student(String name, int roll_no, String addr) {
		super();
		this.name = name;
		this.roll_no = roll_no;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll_no=" + roll_no + ", addr=" + addr + "]";
	}

}
