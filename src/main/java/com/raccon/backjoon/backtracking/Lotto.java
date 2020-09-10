package com.raccon.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] lines = br.readLine().split(" ");
            int row = Integer.parseInt(lines[0]);

            if (row == 0) {
                break;
            }

            String[] array = new String[row];
            for (int i = 0; i < row; i++) {
                array[i] = lines[1 + i];
            }

            String[] lotto = new String[6];
            dfs(array, lotto, 0, 0);
            System.out.println();
        }
    }

    private void dfs(String[] array, String[] lotto, int index, int count) {
        if (count == 6) {
            System.out.println(String.join(" ", lotto));
            return;
        }

        if(index >= array.length){
            return;
        }

        lotto[count] = array[index];
        dfs(array, lotto, index + 1, count + 1);
        if (index < (array.length - 1)) {
            dfs(array, lotto, index + 1, count);
        }
    }
}
