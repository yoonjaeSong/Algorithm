package com.raccon.backjoon.dfs_bfs.virus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Virus {

    private Set<Integer> set = new LinkedHashSet<>();

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());

        int[][] map = new int[computers][computers];
        for (int i = 0; i < pair; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]) - 1, b = Integer.parseInt(inputs[1]) - 1;

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(map, 0);
        return set.size();
    }

    private void dfs(int[][] map, int computer) {

        for (int i = 1; i < map.length; i++) {
            if (map[computer][i] == 1 && !set.contains(i)) {
                set.add(i);
                dfs(map, i);
            }
        }
    }
}
