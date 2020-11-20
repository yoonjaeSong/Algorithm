package com.raccon.backjoon.dfs_bfs.ballEscape;

import java.util.LinkedList;
import java.util.Queue;

public class P13460 {

    private static final int[] mx = {0, 0, -1, 1};
    private static final int[] my = {-1, 1, 0, 0};

    private static Ball red;
    private static Ball blue;
    private static int[] hole; // {x, y}
    private static int[][] map;
    private static boolean[][] visited;

    public int solution(String[][] input) {
        int n = input.length, m = input[0].length;
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j].equals("#")) {
                    map[i][j] = -1;
                    continue;
                } else if (input[i][j].equals("R")) {
                    red = new Ball(j, i);
                } else if (input[i][j].equals("B")) {
                    blue = new Ball(j, i);
                } else if (input[i][j].equals("O")) {
                    hole = new int[]{j, i};
                }

                map[i][j] = 0;
            }
        }

        return bfs();
    }

    private static int bfs() {
        Queue<Information> queue = new LinkedList<>();
        queue.add(new Information(0, red, blue));

        while (!queue.isEmpty()) {
            Information info = queue.poll();

            if (info.count == 10) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                Ball copyRed = info.red.clone(), copyBlue = info.blue.clone();
                int type = move(copyRed, copyBlue, i);
                if (type == 1) {
                    queue.add(new Information(info.count + 1, copyRed, copyBlue));
                } else if (type == 2) {
                    return info.count + 1;
                }
            }
        }

        return -1;
    }

    // 0 이동 불가능 (blue가 빠진 경우, 이미 지난간 경우), 1 이동 가능, 2 red ball이 구멍에 빠짐
    private static int move(Ball red, Ball blue, int direction) {
        boolean redMove = true, blueMove = true;

        while (redMove || blueMove) {
            redMove = isMovableRed(red, blue, direction);
            blueMove = isMovableBlue(blue, red, direction);
        }

        if (visited[red.y][red.x] || blue.isEscaped) {
            return 0;
        }

        if (red.isEscaped) {
            return 2;
        }

        return 1;
    }

    private static boolean isMovableRed(Ball red, Ball blue, int direction) {
        boolean result = false;

        while (true) {
            int nx = red.x + mx[direction];
            int ny = red.y + my[direction];

            if (red.isEscaped) {
                break;
            }

            // 벽인가?
            if (map[ny][nx] == -1) {
                break;
            }

            // 다른 공인가?
            if ((nx == blue.x) && (ny == blue.y)) {
                break;
            }

            // 방문한 곳?
            if (visited[ny][nx]) {
                break;
            }
            visited[red.y][red.x] = true;

            result = true;
            red.x = nx;
            red.y = ny;

            // 구멍
            if ((nx == hole[0]) && (ny == hole[1])) {
                red.isEscaped = true;
                break;
            }
        }

        return result;
    }

    private static boolean isMovableBlue(Ball blue, Ball red, int direction) {
        boolean result = false;

        while (true) {
            int nx = blue.x + mx[direction];
            int ny = blue.y + my[direction];

            // 구멍에 빠졌는가?
            if (blue.isEscaped) {
                break;
            }

            // 벽인가?
            if (map[ny][nx] == -1) {
                break;
            }

            // 다른 공인가?
            if ((nx == red.x) && (ny == red.y) && !red.isEscaped) {
                break;
            }

            result = true;
            blue.x = nx;
            blue.y = ny;

            // 구멍
            if ((nx == hole[0]) && (ny == hole[1])) {
                blue.isEscaped = true;
                break;
            }
        }

        return result;
    }
}

class Information {
    int count;
    Ball red;
    Ball blue;

    public Information(int count, Ball red, Ball blue) {
        this.count = count;
        this.red = new Ball(red.x, red.y);
        this.blue = new Ball(blue.x, blue.y);
    }
}

class Ball {
    int x;
    int y;
    boolean isEscaped;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.isEscaped = false;
    }

    public Ball clone() {
        Ball ball = new Ball(this.x, this.y);
        ball.isEscaped = this.isEscaped;
        return ball;
    }
}
