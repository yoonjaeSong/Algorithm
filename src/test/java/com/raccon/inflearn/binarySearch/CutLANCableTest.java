package com.raccon.inflearn.binarySearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CutLANCableTest {

    @Test
    public void testcase1(){
        CutLANCable algorithm = new CutLANCable();
        int[] cables = {802, 743, 457, 539};
        int k = 11;

        assertEquals(algorithm.solution(cables, k), 200);
    }

    @Test
    public void testcase2(){
        CutLANCable algorithm = new CutLANCable();
        int[] cables = {273, 401, 753, 345, 105};
        int k = 10;

        assertEquals(algorithm.solution(cables, k), 150);
    }

    @Test
    public void testcase3(){
        CutLANCable algorithm = new CutLANCable();
        int[] cables = {405, 321, 349, 113, 329, 285, 405, 369, 217, 413, 305, 153, 45, 89, 353, 265, 149, 329, 349,
                25, 301, 313, 177, 265, 101, 149, 221, 281, 9, 125, 49, 57, 89, 369, 473, 9, 209, 453, 309, 385, 153,
                421, 361, 313, 17, 105, 465, 477, 373, 85, 465, 13, 293, 457, 493, 21, 365, 397, 297, 161, 337, 473,
                417, 5, 133, 5, 253, 97, 301, 497, 229, 33, 257, 373, 425, 249, 393, 29, 149, 421, 341, 477, 201, 485,
                213, 333, 161, 93, 329, 321, 345, 81, 293, 465, 61, 425, 53, 17, 97, 25};
        int k = 100;

        assertEquals(algorithm.solution(cables, k), 166);
    }
}