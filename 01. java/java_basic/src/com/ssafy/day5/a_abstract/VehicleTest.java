package com.ssafy.day5.a_abstract;

public class VehicleTest {

  public static void main(String[] args) {
	  Vehicle[] vs = {new DieselSUV(), new ElectricCar()};
	  
	  for(Vehicle v : vs) {
		  v.addFuel();
		  v.reportPosition();
	  }
  }
}
