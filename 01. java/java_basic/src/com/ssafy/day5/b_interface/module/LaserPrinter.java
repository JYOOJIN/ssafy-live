package com.ssafy.day5.b_interface.module;

public class LaserPrinter implements Printer {

	@Override
	public void print(String fileName) {
		System.out.println("Laser Printer로 프린트한다");
	}

}
