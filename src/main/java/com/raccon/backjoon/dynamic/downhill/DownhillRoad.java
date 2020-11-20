package com.raccon.backjoon.dynamic.downhill;

// 백준-내리막길(1520)
public class DownhillRoad {

    private static final int[] mx = {-1, 1, 0, 0};
    private static final int[] my = {0, 0, -1, 1};

    public int solution(int[][] map) {
        int m = map.length, n = map[0].length;
        int[][] memory = new int[m][n]; // -1 : 방문 안 한것

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memory[i][j] = -1;
            }
        }
        memory[m - 1][n - 1] = 1;

        return dfs(map, memory, 0, 0);
    }

    public int dfs(int[][] map, int[][] memory, int row, int column) {

        if (memory[row][column] >= 0) {
            return memory[row][column];
        }

        memory[row][column] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = column + mx[i];
            int ny = row + my[i];

            if (!isPossible(memory, nx, ny)) {
                continue;
            }

            if (map[row][column] <= map[ny][nx]) {
                continue;
            }

            memory[row][column] += dfs(map, memory, ny, nx);
        }

        return memory[row][column];
    }

    private boolean isPossible(int[][] memory, int x, int y) {

        if ((x < 0) || (x >= memory[0].length) || (y < 0) || y >= memory.length) {
            return false;
        }

        return true;
    }
}
