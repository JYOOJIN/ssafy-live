package com.ssafy.day5.b_interface.relation;

// TODO: DigitalCamera를 충전 가능하게 설정하시오.
public class DigitalCamera extends Camera implements Chargeable{
    // TODO: Chargeable을 구현하시오.
	@Override
	public void charge() {
		System.out.println("디지털카메라 충전");
	}
    // END
}
