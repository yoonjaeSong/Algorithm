package com.raccon.backjoon.tree.lca;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LowestCommonAncestor {
    public int[] solution(int n, int[][] input, int[][] problem) {
        Map<Integer, List<Integer>> information = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            information.put(i, new LinkedList<>());
        }

        for (int[] item : input) {
            information.get(item[0]).add(item[1]);
            information.get(item[1]).add(item[0]);
        }

        int[] parent = new int[n + 1];
        int[] depth = new int[n + 1];
        parent[1] = -1;
        depth[1] = 0;

        makeTree(information, parent, depth, 1);

        int index = 0;
        int[] answer = new int[problem.length];
        for (int[] item : problem) {
            answer[index++] = findAncestor(parent, depth, item[0], item[1]);
        }

        return answer;
    }

    private void makeTree(Map<Integer, List<Integer>> information, int[] nodes, int[] depth, int parent) {

        for (int child : information.get(parent)) {
            if (nodes[child] != 0) {
                continue;
            }

            nodes[child] = parent;
            depth[child] = depth[parent] + 1;
            makeTree(information, nodes, depth, child);
        }
    }

    private int findAncestor(int[] parent, int[] depth, int a, int b) {

        while (depth[a] > depth[b]) {
            a = parent[a];
        }

        while (depth[a] < depth[b]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
