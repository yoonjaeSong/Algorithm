package com.raccon.backjoon.samsung.snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static int UP = 0;
    private static int DOWN = 2;
    private static int LEFT = 3;
    private static int RIGHT = 1;

    private static int[] mx = {0, 1, 0, -1};
    private static int[] my = {-1, 0, 1, 0};

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 지도 만들기
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];


        // 지도에 사과 표시
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] line = br.readLine().split(" ");
            map[Integer.parseInt(line[0]) - 1][Integer.parseInt(line[1]) - 1] = true;
        }

        // 방향 정보 배열로 저장
        int L = Integer.parseInt(br.readLine());
        Turn[] array = new Turn[L];
        for (int i = 0; i < L; i++) {
            String[] line = br.readLine().split(" ");
            array[i] = new Turn(Integer.parseInt(line[0]), line[1]);
        }

        int time = 0, index = 0;
        boolean flag = true;

        List<Information> snake = new LinkedList<>();
        snake.add(new Information(0, 0, RIGHT));

        while (true) {
            time++;

            // 머리이동
            Information head = snake.get(0);
            head.y += my[head.direction];
            head.x += mx[head.direction];

            // 머리 경계 검사
            if (head.x < 0 || head.x >= N || head.y < 0 || head.y >= N) {
                flag = false;
                break;
            }

            // 이동
            int previousDirection = snake.get(0).direction;
            int skip = 0;
            for (Information item : snake) {
                if (skip == 0) {
                    skip++;
                    continue;
                }

                // 머리와 몸이 겹치는지 확인
                if ((head.x == item.x) && (head.y == item.y)) {
                    flag = false;
                    break;
                }

                item.y += my[item.direction];

                int temp = item.direction;
                item.direction = previousDirection;
                previousDirection = temp;
            }

            // 탈출
            if (!flag) {
                break;
            }

            // 사과 확인
            Information tail = snake.get(snake.size() - 1);
            if (map[head.y][head.x]) {
                if (tail.direction == UP) {
                    snake.add(new Information(tail.x, tail.y + 1, tail.direction));
                } else if (tail.direction == DOWN) {
                    snake.add(new Information(tail.x, tail.y - 1, tail.direction));
                } else if (tail.direction == LEFT) {
                    snake.add(new Information(tail.x + 1, tail.y, tail.direction));
                } else {
                    snake.add(new Information(tail.x - 1, tail.y, tail.direction));
                }

                map[head.y][head.x] = false;
            }

            if (index < L && time == array[index].time) {
                if (array[index].direction.equals("D")) {
                    head.direction = (head.direction + 1) % 4;
                } else {
                    head.direction = (head.direction - 1 + 4) % 4;
                }

                index++;
            }
        }

        return time;
    }
}

class Information {
    int x;
    int y;
    int direction;

    public Information(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
}

class Turn {
    int time;
    String direction;

    public Turn(int time, String direction) {
        this.time = time;
        this.direction = direction;
    }
}