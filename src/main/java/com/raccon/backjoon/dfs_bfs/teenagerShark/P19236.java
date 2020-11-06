package com.raccon.backjoon.dfs_bfs.teenagerShark;

import java.util.LinkedList;
import java.util.List;

public class P19236 {

    private static final int[] mx = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] my = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[][] map;
    private static Fish[] fishList;

    public int solution(int[][] input) {
        map = new int[4][4];
        fishList = new Fish[17];

        fishList[0] = new Fish(0, -1, 0, 0, false);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = input[i][j * 2];
                int direction = input[i][j * 2 + 1] - 1;
                map[i][j] = num;
                fishList[num] = new Fish(num, direction, j, i, false);
            }
        }

        Shark shark = new Shark(0, 0, 0);
        int[] start = {0, 0};

        return dfs(start, shark);
    }

    private int dfs(int[] location, Shark shark) {
        // 물고기 사냥
        int target = map[location[1]][location[0]];
        shark.eat(fishList[target]);
        fishList[target].isEaten = true;

        // 복구를 위한 조치 1) 상어 정보 2) 물고기 위치(map) 정보 3) 물고기 정보(fishList)
        Shark temp = new Shark(shark.x, shark.y, shark.direction);

        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        Fish[] copyFishList = new Fish[17];
        for (int i = 0; i < 17; i++) {
            copyFishList[i] = new Fish(fishList[i].num, fishList[i].direction, fishList[i].x, fishList[i].y, fishList[i].isEaten);
        }

        // 물고기 이동
        moveFish(shark);

        // 이동할 수 있는 칸 찾기
        List<int[]> list = findNextLocation(shark);

        // dfs()
        int max = 0;
        if (list != null) {
            for (int[] item : list) {
                max = Math.max(max, dfs(item, shark));
            }
        }

        // 복구 1) fishList 2) map 3) 상어 복구
        for (int i = 0; i < 17; i++) {
            fishList[i] = copyFishList[i];
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = copyMap[i][j];
            }
        }

        shark = temp;
        fishList[target].isEaten = false;

        return target + max;
    }

    private void moveFish(Shark shark) {
        for (int i = 1; i < fishList.length; i++) {
            Fish fish = fishList[i];
            if (fish.isEaten) {
                continue;
            }

            // 방향 찾기
            for (int j = 0; j < 8; j++) {
                if (movableOfFish(fish, shark)) {
                    break;
                }

                fish.direction = (fish.direction + 1) % 8;
            }

            // swap
            int nx = fish.x + mx[fish.direction];
            int ny = fish.y + my[fish.direction];
            Fish target = fishList[map[ny][nx]];
            swap(fish, target);
        }
    }

    private void swap(Fish a, Fish b) {
        // map
        int temp = map[a.y][a.x];
        map[a.y][a.x] = map[b.y][b.x];
        map[b.y][b.x] = temp;

        // fishList
        int tempX = a.x, tempY = a.y;
        a.x = b.x;
        a.y = b.y;
        b.x = tempX;
        b.y = tempY;
    }

    private List<int[]> findNextLocation(Shark shark) {
        List<int[]> list = new LinkedList<>();
        int nx = shark.x;
        int ny = shark.y;

        while (true) {
            nx += mx[shark.direction];
            ny += my[shark.direction];

            // 경계
            if ((nx < 0) || (ny < 0) || (nx >= 4) || (ny >= 4)) {
                break;
            }

            // 물고기가 없는 칸 = 이미 먹힌 물고기
            if (fishList[map[ny][nx]].isEaten) {
                continue;
            }

            list.add(new int[]{nx, ny});
        }

        return list.size() == 0 ? null : list;
    }

    private boolean movableOfFish(Fish fish, Shark shark) {
        int x = fish.x, y = fish.y;
        int nx = x + mx[fish.direction];
        int ny = y + my[fish.direction];

        // 경계
        if ((nx < 0) || (ny < 0) || (nx >= 4) || (ny >= 4)) {
            return false;
        }

        // 상어
        if ((nx == shark.x) && (ny == shark.y)) {
            return false;
        }

        return true;
    }
}

class Shark {
    int x;
    int y;
    int direction;

    public Shark(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void eat(Fish fish) {
        direction = fish.direction;
        x = fish.x;
        y = fish.y;
    }
}

class Fish {
    int num;
    int direction;
    int x;
    int y;
    boolean isEaten;

    public Fish(int num, int direction, int x, int y, boolean isEaten) {
        this.num = num;
        this.direction = direction;
        this.x = x;
        this.y = y;
        this.isEaten = isEaten;
    }
}