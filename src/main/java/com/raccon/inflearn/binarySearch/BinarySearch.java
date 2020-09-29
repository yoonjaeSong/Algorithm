package com.raccon.inflearn.binarySearch;

import java.util.Arrays;

public class BinarySearch {
    public int solution(int[] array, int m) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length;
        int index = (end + start) / 2;

        while (array[index] != m) {
            if (array[index] > m) {
                end = index - 1;
            } else {
                start = index + 1;
            }

            index = (start + end) / 2;
        }

        return index + 1;
    }
}
