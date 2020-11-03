package com.raccon.backjoon.dfs_bfs.babyShark;

import java.util.*;

public class P16236 {

    private static final int[] mx = {0, -1, 1, 0};
    private static final int[] my = {-1, 0, 0, 1};

    private static int[] shark;      // {x, y, 크기}
    private static int huntingCount;

    public int solution(int[][] map){
        int n = map.length;
        int fishCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((map[i][j] >= 1) && (map[i][j] <= 6)) {
                    fishCount++;
                } else if (map[i][j] == 9) {
                    huntingCount = 0;
                    shark = new int[]{j, i, 2};
                    map[i][j] = 0;
                }
            }
        }

        int result = 0;
        while (fishCount != 0) {

            int[] temp = move(n, map);
            if (temp[2] == 0) {
                break;
            } else {
                result += temp[2];
                map[temp[1]][temp[0]] = 0;
                huntingCount++;
                fishCount--;

                if (huntingCount == shark[2]) {
                    shark[2]++;
                    huntingCount = 0;
                }

                shark[0] = temp[0];
                shark[1] = temp[1];
            }
        }

        return result;
    }

    private int[] move(int n, int[][] map) {
        Queue<int[]> nearQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                }

                return (o1[0] > o2[0]) ? 1 : -1;
            }
        });
        Queue<int[]> queue = new LinkedList<>(); // {x, y, moveCount}
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        queue.add(new int[]{shark[0], shark[1], 0});
        for (int i = 0; i < n; i++) {
            visited.put(i, new HashSet<>());
        }


        int distance = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            // 동일한 거리에서 우선 순위가 가장 높은 곳 찾기
            if (distance == point[2]) {
                while (!nearQueue.isEmpty()) {
                    int[] check = nearQueue.poll();
                    if (map[check[1]][check[0]] > 0 && map[check[1]][check[0]] < shark[2]) {
                        return check;
                    }
                }
                distance++;
            }

            visited.get(point[0]).add(point[1]);
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + mx[i];
                int ny = point[1] + my[i];

                if ((nx < 0) || (ny < 0) || (nx >= n) || (ny >= n)) {
                    continue;
                }

                if (!visited.get(nx).contains(ny) && (shark[2] >= map[ny][nx])) {
                    queue.add(new int[]{nx, ny, point[2] + 1});
                    visited.get(nx).add(ny);
                    if (distance == point[2] + 1) {
                        nearQueue.add(new int[]{nx, ny, point[2] + 1});
                    }
                }
            }
        }

        return new int[]{0, 0, 0};
    }
}
