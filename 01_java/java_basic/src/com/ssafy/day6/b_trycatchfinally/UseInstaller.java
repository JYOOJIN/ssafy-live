package com.ssafy.day6.b_trycatchfinally;

public class UseInstaller {
    public static void main(String[] args) {
        // TODO: InstallApp을 이용하면서 자원이 확실히 정리되도록 해보자.
    	InstallApp app = new InstallApp();	
    	try {
    		app.copy();
    		app.install();

    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		app.delete();
    	}
        // END
        System.out.println("설치 종료");

    }
}
