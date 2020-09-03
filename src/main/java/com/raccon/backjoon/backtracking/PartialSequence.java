package com.raccon.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartialSequence {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);

        String input = br.readLine();
        int[] array = new int[n];
        int index = 0;
        for (String number : input.split(" ")) {
            array[index++] = Integer.parseInt(number);
        }

        int answer = backtracking(array, 0, 0, s);
        System.out.println(answer);
    }

    private int backtracking(int[] array, int index, int sum, int s) {
        int result = 0;

        if (index == array.length) {
            return 0;
        }

        if ((sum + array[index]) == s) {
            result += 1;
        }

        result += backtracking(array, index + 1, sum + array[index], s);
        result += backtracking(array, index + 1, sum, s);

        return result;
    }
}
