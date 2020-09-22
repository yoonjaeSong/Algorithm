package com.raccon.backjoon.greedy.coinZero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinZero {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int result = 0, index = n - 1;
        while (k != 0) {
            if(array[index] > k){
                index--;
                continue;
            }

            k -= array[index];
            result++;
        }

        return result;
    }
}
