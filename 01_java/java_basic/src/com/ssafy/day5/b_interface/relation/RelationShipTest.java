package com.ssafy.day5.b_interface.relation;

public class RelationShipTest {
    public static void main(String[] args) {
        Object[] objs = { new HandPhone(), new Camera(), new Phone(), new DigitalCamera() };

        // TODO: 충전 가능한 객체들을 충전하시오.
        for(Object obj : objs) {
        	if(obj instanceof Chargeable c) {
        		c.charge();
        	}
        }
    }
}
