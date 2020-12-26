package com.raccon.backjoon.dfs_bfs.logo;

import java.util.LinkedList;
import java.util.Queue;

public class Logo {
    public int solution(int[][] input) {
        int n = input.length;
        Rectangle[] rectangles = new Rectangle[n + 1];
        rectangles[0] = new Rectangle(0, 0, 0, 0);
        for (int i = 0; i < n; i++) {
            int x1 = input[i][0];
            int y1 = input[i][1];
            int x2 = input[i][2];
            int y2 = input[i][3];

            rectangles[i + 1] = new Rectangle(x1, y1, x2, y2);
        }

        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            if (rectangles[i].visited) {
                continue;
            }

            rectangles[i].visited = true;
            queue.add(i);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int j = 0; j <= n; j++) {
                    if ((current == j) || !isInclude(rectangles[current], rectangles[j]) || rectangles[j].visited) {
                        continue;
                    }

                    rectangles[j].visited = true;
                    queue.add(j);
                }
            }
            answer++;
        }

        return answer - 1;
    }

    private boolean isInclude(Rectangle current, Rectangle next) {
        if ((current.x1 < next.x1 && next.x2 < current.x2 && current.y1 < next.y1 && next.y2 < current.y2)
                || (current.x1 > next.x1 && next.x2 > current.x2 && current.y1 > next.y1 && next.y2 > current.y2)
                || current.x2 < next.x1 || current.x1 > next.x2 || current.y2 < next.y1 || current.y1 > next.y2) {
            return false;
        }

        return true;
    }
}

class Rectangle {
    int x1;
    int y1;
    int x2;
    int y2;
    boolean visited;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.visited = false;
    }
}
