package com.raccon.programmers.sort;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class P2Test {

    @Test
    public void testcase(){
        P2 p2 = new P2();
        int[] numbers = {3, 9, 30, 34, 5};
        assertEquals(p2.solution(numbers), "9534330");
    }

    @Test
    public void testcase2(){
        P2 p2 = new P2();
        int[] numbers = {6, 10, 2};
        assertEquals(p2.solution(numbers), "6210");
    }

    @Test
    public void testcase3(){
        P2 p2 = new P2();
        int[] numbers = {10, 9, 12, 22, 202};
        assertEquals(p2.solution(numbers), "9222021210");
    }
}