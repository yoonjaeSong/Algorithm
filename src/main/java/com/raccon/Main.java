package com.raccon;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] array = {"13", "1", "10", "22", "5", "6"};
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}
