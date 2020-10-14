package com.raccon.backjoon.dfs_bfs.p1389;

import org.junit.Test;

import static org.junit.Assert.*;

public class P1389Test {

    @Test
    public void testcase1() {
        P1389 p = new P1389();
        int n = 5;
        int[][] inputs = {{1, 3}, {1, 4}, {4, 5}, {4, 3}, {3, 2}};

        assertEquals(p.solution(n, inputs), 3);
    }

}