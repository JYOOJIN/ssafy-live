package com.ssafy.day6.a_basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MultiExceptionHandling {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        // TODO: 다음에서 발생하는 예외를 처리해보자.
         try {
        	 Class.forName("abc.Def"); // ClassNotFoundException
             new FileInputStream("Hello.java"); // FileNotFoundException
             DriverManager.getConnection("Hello"); // SQLException
         }catch(ClassNotFoundException e) {
        	 e.printStackTrace();
         }catch(FileNotFoundException e) {
        	 e.printStackTrace();
         }catch(SQLException e) {
        	 e.printStackTrace();
         }

        // END
        System.out.println("프로그램 정상 종료");

    }
}
