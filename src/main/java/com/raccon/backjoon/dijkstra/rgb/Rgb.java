package com.raccon.backjoon.dijkstra.rgb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rgb {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = Integer.parseInt(br.readLine());

        int[][] rgb = new int[row][3];
        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                rgb[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] memory = new int[row][3];
        memory[0][0] = rgb[0][0];
        memory[0][1] = rgb[0][1];
        memory[0][2] = rgb[0][2];

        for (int i = 1; i < row; i++) {
            memory[i][0] = Math.min(memory[i - 1][1], memory[i - 1][2]) + rgb[i][0];
            memory[i][1] = Math.min(memory[i - 1][0], memory[i - 1][2]) + rgb[i][1];
            memory[i][2] = Math.min(memory[i - 1][0], memory[i - 1][1]) + rgb[i][2];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            answer = Math.min(answer, memory[row-1][i]);
        }

        return answer;
    }
}
