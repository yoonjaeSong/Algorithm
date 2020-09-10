package com.raccon.backjoon.dfs_bfs.maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Maze {

    private int[][] maze;
    private int[][] countMap;
    private Queue<Integer> xStack = new ArrayDeque<>();
    private Queue<Integer> yStack = new ArrayDeque<>();

    public int run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), m = Integer.parseInt(inputs[1]);

        maze = new int[n][m];
        countMap = new int[n][m];

        for (int row = 0; row < n; row++) {
            int column = 0;
            String[] line = br.readLine().split("");
            for (String number : line) {
                maze[row][column++] = Integer.parseInt(number);
            }
        }

        countMap[0][0] = 1;
        bfs();

        return countMap[n - 1][m - 1];
    }

    private void bfs() {
        int row = maze.length, column = maze[0].length;

        xStack.add(0);
        yStack.add(0);

        while (!xStack.isEmpty() && !yStack.isEmpty()) {
            int x = xStack.poll();
            int y = yStack.poll();

            int count = countMap[x][y];

            //상
            if ((x - 1 >= 0) && (maze[x - 1][y] == 1) && (countMap[x - 1][y] == 0)) {
                setCountMap(x - 1, y, count + 1);
            }

            // 하
            if ((x + 1 < row) && (maze[x + 1][y] == 1) && (countMap[x + 1][y] == 0)) {
                setCountMap(x + 1, y, count + 1);
            }

            // 좌
            if ((y - 1 >= 0) && (maze[x][y - 1] == 1) && (countMap[x][y - 1] == 0)) {
                setCountMap(x, y - 1, count + 1);
            }

            // 우
            if ((y + 1 < column) && (maze[x][y + 1] == 1) && (countMap[x][y + 1] == 0)) {
                setCountMap(x, y + 1, count + 1);
            }
        }
    }

    private void setCountMap(int x, int y, int value) {
        xStack.add(x);
        yStack.add(y);
        countMap[x][y] = value;
    }
}
