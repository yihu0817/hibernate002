package com.ittx.hibernate002.model;

import java.util.Date;

public class Student {
	private int number;  //学号	
	private String name; //姓名
	private int age;    //年龄
	private String sex;  //性别 
	private Date birthday; //出生日期

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(int number, String name, int age, String sex, Date birthday) {
		this.number = number;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday="
				+ birthday + "]";
	}
	
	
}
