package com.raccon.backjoon.greedy.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Algospot {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int column = Integer.parseInt(line[0]), row = Integer.parseInt(line[1]);

        int[][] map = new int[row][column];
        int[][] crash = new int[row][column]; // default false
        for (int i = 0; i < row; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < column; j++) {
                map[i][j] = Integer.parseInt(inputs[j]) * -1;
                crash[i][j] = Integer.MAX_VALUE;
            }
        }

        crash[0][0] = 0;
        go(0, 0, map, crash);

        return crash[row - 1][column - 1];
    }

    private void go(int x, int y, int[][] map, int[][] crash) {
        int[] moveX = {0, 0, -1, 1};
        int[] moveY = {-1, 1, 0, 0};
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = node.getX() + moveX[i];
                int nextY = node.getY() + moveY[i];

                if ((nextX < 0) || (nextX >= map[0].length) || (nextY < 0) || (nextY >= map.length)) {
                    continue;
                }

                if (map[nextY][nextX] == 0) {
                    if (crash[nextY][nextX] > crash[node.getY()][node.getX()]) {
                        crash[nextY][nextX] = crash[node.getY()][node.getX()];
                        queue.add(new Node(nextX, nextY));
                    }
                } else {  // 벽
                    if (crash[nextY][nextX] > crash[node.getY()][node.getX()] + 1) {
                        crash[nextY][nextX] = crash[node.getY()][node.getX()] + 1;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }
        }
    }
}
