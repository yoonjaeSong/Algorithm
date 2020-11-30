package com.raccon.programmers.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamouflageTest {

    @Test
    public void testcase1(){
        Camouflage algorithm = new Camouflage();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        assertEquals(algorithm.solution(clothes), 5);
    }

}