package com.raccon.backjoon.backtracking.bishop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bishop {
    private static final int[] mx = {-1, 1, -1, 1};
    private static final int[] my = {-1, -1, 1, 1};
    private static final boolean WHITE = true;
    private static final boolean BLACK = false;

    private static int result;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Room[][] map = new Room[n][n];
        result = 0;

        // 지도 만들기
        boolean rowColor = BLACK;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            boolean columnColor = rowColor;
            for (int j = 0; j < n; j++) {
                map[i][j] = new Room(Integer.parseInt(input[j]), columnColor);
                columnColor = !columnColor;
            }
            rowColor = !rowColor;
        }

        int white = 0, black = 0;
        dfs(map, 0, 0, BLACK);
        white = result;
        result = 0;

        dfs(map, 1, 0, WHITE);
        black = result;

        return white + black;
    }

    private void dfs(Room[][] map, int step, int bishop, boolean color) {
        int n = map.length;

        if (step >= (n * n)) {
            result = Math.max(result, bishop);
            return;
        }

        int row = step / n, column = step % n;
        Room room = map[row][column];

        // 색깔 비교
        if (room.getColor() != color) {
            dfs(map, step + 1, bishop, color);
            return;
        }

        // 비숏을 놓은 수 있는 가?
        if (room.isLocated()) {
            check(map, row, column, 1);
            dfs(map, step + 1, bishop + 1, color);

            // 복구
            check(map, row, column, -1);
        }

        dfs(map, step + 1, bishop, color);
    }

    private void check(Room[][] map, int row, int column, int num) {
        // 현재 위치 표시
        map[row][column].check(num);

        // 대각선 표시
        for (int i = 0; i < 4; i++) {
            int x = column + mx[i], y = row + my[i];
            while ((x >= 0) && (x < map.length) && (y >= 0) && (y < map.length)) {
                map[y][x].check(num);

                x += mx[i];
                y += my[i];
            }
        }
    }
}

class Room {
    private boolean flag;
    private boolean color;
    private int count;

    public Room(int flag, boolean color) {
        this.flag = (flag == 1);
        this.color = color;
        this.count = 0;
    }

    public void check(int num) {
        count += num;
    }

    public boolean getColor() {
        return color;
    }

    public boolean isLocated() {
        // 비숍이 놓아질 수 있는 공간?
        if (!flag) {
            return false;
        }

        // 지나가는 비숍이 있는 가?
        if (count > 0) {
            return false;
        }

        return true;
    }
}