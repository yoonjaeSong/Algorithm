package com.raccon.programmers.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P1Test {

    @Test
    public void testcase(){
        P1 algorithm = new P1();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        Assertions.assertArrayEquals(algorithm.solution(array, command), new int[]{5, 6, 3});
    }
}