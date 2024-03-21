package com.ssafy.day1.a_basic;

import java.util.Random;

public class Lang_07 {
    public static void main(String[] args) {
        byFor();
        byWhile();
    }

    private static void byFor() {
        int sum = 0;
        int cnt = 100;
        double avg = 0;
        Random rand = new Random();
        // TODO: for 문장을 이용해서 cnt 만큼 주사위를 던지고 그 합과 평균(소수점 1자리)을 출력하시오.
        for(int i = 0; i < cnt; i++) {
        	sum += rand.nextInt(6) + 1;
        	avg = 1.0*sum / cnt;
        	
        	
        }
        // END
        System.out.printf("sum: %d, avg: %.1f\n", sum, avg);
    }

    public static void byWhile() {
        int sum = 0;
        int cnt = 100;
        double avg = 0;
        Random rand = new Random();
        // TODO: while 문장을 이용해서 cnt 만큼 주사위를 던지고 그 합과 평균(소수점 1자리)을 출력하시오.
        int index = 0;
        while(index < cnt) {
        	sum += rand.nextInt(6) + 1;
        	avg = 1.0*sum / cnt;
        	

        	index++;
        }
        // END
        System.out.printf("sum: %d, avg: %.1f\n", sum, avg);
    }

}
