package com.raccon.programmers.devMatch2021.matrixBorder;

public class Solution {

    private int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = makeMatrix(rows, columns);
        int seq = 0;

        for (int[] query : queries) {
            answer[seq++] = rotateMatrix(query);
        }

        return answer;
    }

    private int rotateMatrix(int[] query) {
        int x1 = query[0] - 1, x2 = query[2] - 1;
        int y1 = query[1] - 1, y2 = query[3] - 1;

        int minValue = matrix[x1][y1];
        int before, after = matrix[x1][y1], diffX = x2 - x1, diffY = y2 - y1;

        // right y++
        for (int i = 1; i <= diffY; i++) {
            minValue = Math.min(minValue, after);
            before = after;
            after = matrix[x1][y1 + i];
            matrix[x1][y1 + i] = before;
        }

        // down x++
        for (int j = 1; j <= diffX; j++) {
            minValue = Math.min(minValue, after);
            before = after;
            after = matrix[x1 + j][y2];
            matrix[x1 + j][y2] = before;
        }

        //left y--
        for (int i = 1; i <= diffY; i++) {
            minValue = Math.min(minValue, after);
            before = after;
            after = matrix[x2][y2 - i];
            matrix[x2][y2 - i] = before;
        }

        //up x--
        for (int j = 1; j <= diffX; j++) {
            minValue = Math.min(minValue, after);
            before = after;
            after = matrix[x2 - j][y1];
            matrix[x2 - j][y1] = before;
        }

        return minValue;
    }

    private int[][] makeMatrix(int rows, int columns) {
        int seq = 1;
        matrix = new int[rows][columns];

        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
                matrix[rowIndex][columnIndex] = seq++;
            }
        }

        return matrix;
    }
}
