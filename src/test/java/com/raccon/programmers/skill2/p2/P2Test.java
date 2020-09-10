package com.raccon.programmers.skill2.p2;

import org.junit.Test;

import static org.junit.Assert.*;

public class P2Test {

    @Test
    public void testcase1(){
        P2 p2 = new P2();
        int[] array = {1, 2, 3, 9, 10, 12};
        int K = 7;

        assertEquals(p2.solution(array, K), 2);
    }
}