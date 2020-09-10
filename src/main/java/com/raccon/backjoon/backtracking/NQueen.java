package com.raccon.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    public int run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] array = new int[n][n];

        return backtracking(array, 0);
    }

    private int backtracking(int[][] array, int column) {
        int result = 0;

        if (column == array.length) {
            return 1;
        }

        // row 선택
        for (int row = 0; row < array.length; row++) {
            if (array[row][column] == 0) {
                checkTrace(array, row, column);
                result += backtracking(array, column+1);
                unCheckTrace(array, row, column);
            }
        }

        return result;
    }

    private void checkTrace(int[][] array, int row, int column) {

        array[row][column] += 1;

        for (int i = 1; i < array.length - column; i++) {
            // 오른쪽 위 대각선
            if ((row - i) >= 0) {
                array[row - i][column + i] += 1;
            }

            // 행
            array[row][column + i] += 1;

            // 오른쪽 아래 대각선
            if ((row + i) < array.length) {
                array[row + i][column + i] += 1;
            }
        }
    }

    private void unCheckTrace(int[][] array, int row, int column) {

        array[row][column] -= 1;

        for (int i = 1; i < array.length - column; i++) {
            // 오른쪽 위 대각선
            if ((row - i) >= 0) {
                array[row - i][column + i] -= 1;
            }

            // 행
            array[row][column + i] -= 1;

            // 오른쪽 아래 대각선
            if ((row + i) < array.length) {
                array[row + i][column + i] -= 1;
            }
        }
    }
}
