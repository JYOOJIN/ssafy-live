package com.ssafy.day6.c_throws;

public class ExceptionChaining {
    public static void main(String[] args) {
        OnlineShop shop = new OnlineShop();
        // TODO: 03. shop을 통해 주문해보자.
        shop.order();
        // END
        System.out.println("상품 주문 사용 완료!");
    }
}

class OnlineShop {

    public void order() {
        // TODO: 02. 주문 처리 과정에서 발생하는 예외를 처리하고 IllegalStateException을 발생시켜보자.
        try {
        	packaging();
            delivery();
            System.out.println("상품이 정상적으로 배송 되었습니다.");
        }catch(RuntimeException e) {
        	throw new IllegalStateException(e);
        }

        // END
    }

    private void packaging() {
        System.out.println("상품을 포장합니다.");
    }

    private void delivery() {
        deliveryToWareHouse();
        deliveryToCustomer();
    }

    private void deliveryToWareHouse() {
        System.out.println("물류 창고로 배송합니다.");
    }

    private void deliveryToCustomer() {
        System.out.println("고객에게 배송합니다.");
        // TODO: 01. 임의로 RuntimeException 계열의 예외를 발생시켜 보자.
        throw new RuntimeException("도로 결빙");
        // END
    }

}
