package com.ssafy.day1.b_array;

import java.util.*;

public class ArrayTest_09 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] scores = { 90, 80, 100 };

        scores = new int[] {90, 80, 100, 95}; // #2


        //scores = Arrays.copyOf(scores, 5); // #4
        //scores[3]=95;

        int[] scores2 = new int[4]; // #5
        System.arraycopy(scores, 0, scores2, 0, scores.length);
        scores2[3] = 95;

    }
}
