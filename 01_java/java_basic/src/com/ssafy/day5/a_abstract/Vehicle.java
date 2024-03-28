package com.ssafy.day5.a_abstract;

// TODO: Vehicle을 상속받는 구조로 변경해보자.
 public abstract class Vehicle {
    private int curX, curY;

    public void reportPosition() {
        System.out.printf("차종: %s: 현재 위치: (%d, %d)%n", this.getClass().getSimpleName(), curX, curY);
    }

    public abstract void addFuel();
 }
