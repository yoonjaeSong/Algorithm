package com.raccon.programmers.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class P3Test {

    @Test
    public void testcase1(){
        P3 p3 = new P3();
        int[] citations = {3, 0, 6, 1, 5};
        assertEquals(p3.solution(citations), 3);
    }
}