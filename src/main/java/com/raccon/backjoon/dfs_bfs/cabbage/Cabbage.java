package com.raccon.backjoon.dfs_bfs.cabbage;

import java.util.LinkedList;
import java.util.Queue;

// 백준(10102) - 유기농 배추
public class Cabbage {

    private static final int[] moveX = {-1, 1, 0, 0};
    private static final int[] moveY = {0, 0, -1, 1};

    public int solution(int row, int column, int[][] inputs){
        Queue<int[]> queue = new LinkedList<>();
        int[][] map = new int[row][column];
        for (int[] input : inputs) {
            map[input[1]][input[0]] = -1;
            queue.add(input);
        }

        int area = 0;
        while(!queue.isEmpty()){
            int[] position = queue.poll();

            if(map[position[1]][position[0]] == -1){
                area++;
                findArea(map, position, area);
            }
        }

        return area;
    }

    private void findArea(int[][] map, int[] start, int area) {
        Queue<int[]> queue = new LinkedList<>();

        map[start[1]][start[0]] = area;
        queue.add(start);
        while(!queue.isEmpty()){
            int[] position = queue.poll();

            for(int i=0; i<4; i++){
                int nextY = position[1] + moveY[i];
                int nextX = position[0] + moveX[i];

                if((nextX < 0) || (nextX >= map[0].length) || (nextY < 0) || (nextY >= map.length)){
                    continue;
                }

                if(map[nextY][nextX] == -1) {
                    map[nextY][nextX] = area;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
