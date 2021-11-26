package com.raccon.programmers.devMatch2021.matrixBorder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void test1() {
        int rows = 6, columns = 6;
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        Solution solution = new Solution();

        assertArrayEquals(new int[] {8, 10, 25}, solution.solution(rows, columns, queries));
    }

}