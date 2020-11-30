package com.raccon.programmers.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P3Test {

    @Test
    public void testcase1(){
        P3 p3 = new P3();
        int[] citations = {3, 0, 6, 1, 5};
        Assertions.assertEquals(p3.solution(citations), 3);
    }
}