package com.raccon.inflearn.binarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void testcase1() {
        BinarySearch algorithm = new BinarySearch();
        int[] a = {30, 94, 27, 92, 21, 37, 25, 47, 25, 53, 98, 19, 32, 32, 7};
        int m = 53;

        assertEquals(algorithm.solution(a, m), 12);
    }

    @Test
    public void testcase2() {
        BinarySearch algorithm = new BinarySearch();
        int[] a = {51, 46, 30, 89, 12, 50, 14, 45, 100, 99, 94, 4, 67, 20, 73, 69, 71, 17, 21, 49};
        int m = 67;

        assertEquals(algorithm.solution(a, m), 13);
    }

    @Test
    public void testcase3() {
        BinarySearch algorithm = new BinarySearch();
        int[] a = {57, 17, 22, 28, 30, 98, 47, 38, 12, 75, 86, 25, 4, 29, 20, 52, 37, 70, 79, 78, 87, 33, 60, 13, 59,
                88, 44, 43, 58, 1, 23, 35, 34, 36, 92, 65, 32, 15, 3, 89, 31, 95, 100, 77, 73, 39, 66, 56, 93, 8, 48,
                10, 21, 19, 67, 71, 14, 62, 96, 91, 7, 90, 5, 54, 69, 27, 41, 50, 94, 68, 72, 63, 16, 81, 64, 18, 97,
                55, 82, 83, 26, 9, 49, 2, 85, 80, 84, 45, 24, 99, 40, 53, 6, 42, 46, 11, 51, 76, 74, 61};
        int m = 35;

        assertEquals(algorithm.solution(a, m), 35);
    }
}