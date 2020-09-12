package com.raccon.backjoon.dijkstra.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Triangle {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(br.readLine());

        int[][] triangle = new int[row][row];
        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                triangle[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] memory = new int[row][row];
        memory[0][0] = triangle[0][0];

        for (int i = 1; i < row; i++) {
            memory[i][0] += memory[i - 1][0] + triangle[i][0];

            for (int j = 1; j < i; j++) {
                memory[i][j] = Math.max(memory[i - 1][j - 1], memory[i - 1][j]) + triangle[i][j];
            }

            memory[i][i] += memory[i - 1][i - 1] + triangle[i][i];
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            answer = Math.max(answer, memory[row - 1][i]);
        }

        return answer;
    }
}
