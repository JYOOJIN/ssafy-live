package com.ssafy.day4.b_singleton;

class SingletonClass {
  // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
  private SingletonClass() {}
  
  private static SingletonClass instance = new SingletonClass();
  
  public static SingletonClass getInstance() {
	  return instance;
  }
  // END
  public void sayHello() {
    System.out.println("Hello");
  }

}

public class SingletonTest {
  public static void main(String[] args) {
    // TODO:SingletonClass를 사용해보세요.
	  SingletonClass sc = SingletonClass.getInstance();
	  sc.sayHello();
	  
	  SingletonClass sc2 = SingletonClass.getInstance();
	  sc2.sayHello();
    // END
  }
}
