package com.raccon.backjoon.dfs_bfs.hideAndSeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class HideAndSeek {
    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> pair = new HashMap<>();

        queue.add(n);
        pair.put(n, 0);
        while (true) {
            int value = queue.poll();
            if (value == k) {
                break;
            }

            if ((value - 1) >= 0 && !pair.containsKey(value - 1)) {
                queue.add(value - 1);
                pair.put(value - 1, pair.get(value) + 1);
            }

            if ((value + 1) <= 100000 && !pair.containsKey(value + 1)) {
                queue.add(value + 1);
                pair.put(value + 1, pair.get(value) + 1);
            }

            if ((value * 2) <= 100000 && !pair.containsKey(value * 2)) {
                queue.add(2 * value);
                pair.put(value * 2, pair.get(value) + 1);
            }
        }

        return pair.get(k);
    }
}
