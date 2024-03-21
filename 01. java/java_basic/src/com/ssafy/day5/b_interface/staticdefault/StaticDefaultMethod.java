package com.ssafy.day5.b_interface.staticdefault;

import java.util.Arrays;

interface Aircon {
    void makeCool();

    // TODO: 2. 건조기능을 추가해보자.
    public default void dry() {
    	System.out.println("건조하기");
    }
    // END

    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void desc() {
    	System.out.println("에어컨에 대한 설명");
    }
    // END

}

class OldisButGoodies1 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon {
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class Nowind implements Aircon{
	public void makeCool() {
		System.out.println("무풍 냉각해줘");
	}
}
// END

public class StaticDefaultMethod {
    public static void main(String[] args) {
        Aircon[] aircons = { new OldisButGoodies1(), new OldisButGoodies2() };
        for (Aircon aircon : aircons) {
            aircon.makeCool();
        }
    }
}
