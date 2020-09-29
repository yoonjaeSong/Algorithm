package com.raccon.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    private List<int[]> list;
    private int[][] sudoku;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        list = new ArrayList<>();

        for (int row = 0; row < 9; row++) {
            String[] inputs = br.readLine().split(" ");
            for (int column = 0; column < 9; column++) {
                int number = Integer.parseInt(inputs[column]);
                sudoku[row][column] = number;
                if (number == 0) {
                    list.add(new int[]{row, column});
                }
            }
        }

        backtracking(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }

    }

    private boolean backtracking(int index) {

        if (index == list.size()) {
            return true;
        }

        int[] position = list.get(index);

        for (int i = 1; i <= 9; i++) {
            if (check(position[0], position[1], i)) {
                sudoku[position[0]][position[1]] = i;
                if (!backtracking(index + 1)) {
                    sudoku[position[0]][position[1]] = 0;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean check(int row, int column, int number) {

        for(int i=0; i<9; i++){
            if(sudoku[row][i] == number){
                return false;
            }
        }

        for(int i=0; i<9; i++){
            if(sudoku[i][column] == number){
                return false;
            }
        }

        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
                if (sudoku[i][j] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
