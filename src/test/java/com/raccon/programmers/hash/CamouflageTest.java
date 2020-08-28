package com.raccon.programmers.hash;

import org.junit.Test;

import static org.junit.Assert.*;

public class CamouflageTest {

    @Test
    public void testcase1(){
        Camouflage algorithm = new Camouflage();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        assertEquals(algorithm.solution(clothes), 5);
    }

}