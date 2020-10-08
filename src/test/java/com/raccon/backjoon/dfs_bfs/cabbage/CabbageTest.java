package com.raccon.backjoon.dfs_bfs.cabbage;

import org.junit.Test;

import static org.junit.Assert.*;

public class CabbageTest {

    @Test
    public void testcase1() {
        int[][] inputs = {
                {0, 0}, {1, 0}, {1, 1}, {4, 2}, {4, 3}, {4, 5}, {2, 4}, {3, 4},
                {7, 4}, {8, 4}, {9, 4}, {7, 5}, {8, 5}, {9, 5}, {7, 6}, {8, 6}, {9, 6}
        };
        Cabbage cabbage = new Cabbage();
        assertEquals(cabbage.solution(8, 10, inputs), 5);
    }

    @Test
    public void testcase2() {
        int[][] inputs = {{5, 5}};
        Cabbage cabbage = new Cabbage();
        assertEquals(cabbage.solution(10, 10, inputs), 1);
    }

    @Test
    public void testcase3() {
        int[][] inputs = {{0, 2}, {1, 2}, {2, 2}, {3, 2}, {4, 2}, {4, 0}};
        Cabbage cabbage = new Cabbage();
        assertEquals(cabbage.solution(3, 5, inputs), 2);
    }
}