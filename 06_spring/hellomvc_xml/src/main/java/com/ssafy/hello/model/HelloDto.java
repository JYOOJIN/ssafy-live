package com.ssafy.hello.model;

import java.util.Arrays;

public class HelloDto {

	private String userName;
	private int userAge;
	private String[] fruit;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String[] getFruit() {
		return fruit;
	}

	public void setFruit(String[] fruit) {
		this.fruit = fruit;
	}

	@Override
	public String toString() {
		return "HelloDto [userName=" + userName + ", userAge=" + userAge + ", fruit=" + Arrays.toString(fruit) + "]";
	}

}
