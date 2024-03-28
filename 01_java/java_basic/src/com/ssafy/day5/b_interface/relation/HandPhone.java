package com.ssafy.day5.b_interface.relation;

// TODO: HandPhone를 충전 가능하게 설정하시오.
public class HandPhone extends Phone implements Chargeable{
    // TODO: Chargeable을 구현하시오.
	@Override
	public void charge() {
		System.out.println("휴대폰 충전");
	}
    // END
}
