package com.raccon.programmers.skill2.p1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P1Test {

    @Test
    public void testcase1(){
        P1 p1 = new P1();
        String skill = "CBD";
        String[] skillTree = {"BACDE", "CBADF", "AECB", "BDA"};

        Assertions.assertEquals(p1.solution(skill, skillTree), 2);
    }
}