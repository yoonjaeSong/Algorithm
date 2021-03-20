package com.raccon.backjoon.dijkstra.p1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K번째최단경로찾기 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stz;

    private static int n, m, k;
    private static List<int[]>[] adj;

    public int[] solution() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());

        adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());

            adj[a].add(new int[]{b, c});
        }

        return dijkstra();
    }

    private int[] dijkstra() {
        int[] result = new int[n + 1];
        int[] visitedCount = new int[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });

        Arrays.fill(result, -1);

        int count = 0;
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            // x번 노드를 K번 이상 지나가지 않게 설정
            if (visitedCount[cur[0]] >= k) {
                continue;
            }

            visitedCount[cur[0]]++;
            if (visitedCount[cur[0]] == k) {
                result[cur[0]] = cur[1];
                count++;
            }

            // 탈출 조건
            if (count == n) {
                break;
            }

            for (int[] next : adj[cur[0]]) {
                pq.add(new int[]{next[0], next[1] + cur[1]});
            }
        }

        return result;
    }
}
