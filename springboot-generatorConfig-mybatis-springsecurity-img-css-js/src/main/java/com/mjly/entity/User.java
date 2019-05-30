package com.mjly.entity;

public class User {
	private String name;
	private String pwd;
	private int age;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User() {
		super();
	}
	public User(String name, String pwd, int age, String address) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", age=" + age + ", address=" + address + "]";
	}
}
