package com.raccon.backjoon.dfs_bfs.cheese;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Cheese {
    private static final int[] moveX = {-1, 1, 0, 0};
    private static final int[] moveY = {0, 0, -1, 1};

    private static int[][] map;
    private static boolean[][] air;
    private static Queue<int[]> cheese;

    public int[] solution(int[][] input) {
        int row = input.length, column = input[0].length;
        map = input;
        air = new boolean[row][column];
        cheese = new LinkedList<>();

        int[] start = {0, 0};
        flowIn(start);

//        print(row, column);

        int part = 0, time = 0;
        while (!cheese.isEmpty()) {
            int count = cheese.size();
            part = cheese.size();
            time++;
            for (int i = 0; i < count; i++) {
                int[] point = cheese.poll();
                map[point[0]][point[1]] = 0;
                flowIn(point);
            }
//            print(row, column);
        }

        return new int[] {time, part};
    }

    private void flowIn(int[] start) {
        Queue<int[]> airQueue = new LinkedList<>();

        air[start[0]][start[1]] = true;
        airQueue.add(start);

        while (!airQueue.isEmpty()) {
            int[] point = airQueue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = point[0] + moveY[i];
                int nx = point[1] + moveX[i];

                if ((nx < 0) || (ny < 0) || (nx >= air[0].length) || (ny >= air.length)) {
                    continue;
                }

                if (!air[ny][nx]) {
                    if (map[ny][nx] == 0) {
                        air[ny][nx] = true;
                        airQueue.add(new int[]{ny, nx});
                    } else {
                        air[ny][nx] = true;
                        cheese.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }

    private boolean isContacted(int[] point) {
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            ny = point[0] + moveY[i];
            nx = point[1] + moveX[i];

            if (map[ny][nx] == 0) {
                return true;
            }
        }

        return false;
    }

    private int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    private void print(int row, int column){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == 0) {
                    if (air[i][j]) {
                        System.out.print("0" + " ");
                    } else {
                        System.out.print("2" + " ");
                    }
                } else {
                    if (air[i][j]) {
                        System.out.print("C" + " ");
                    } else {
                        System.out.print("1" + " ");
                    }
                }
            }
            System.out.println();
        }

        System.out.println("=================================");
    }
}
