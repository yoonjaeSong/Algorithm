package com.raccon.backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Decimal {
    public int run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(array);
        int maxNumber = array[n-1];

        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2);

        for(int i = 3; i<=maxNumber; i++){
            boolean flag = true;
            for(int number : set){
                if(i % number == 0){
                    flag = false;
                    break;
                }
            }

            if(flag)
                set.add(i);
        }

        int result = 0;
        for(int number : array){
            if(set.contains(number)){
                result++;
            }
        }

        return result;
    }
}
