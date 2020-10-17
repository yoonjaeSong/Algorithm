package com.raccon.backjoon.dfs_bfs.diameterOfTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 원리 - https://lmcoa15.tistory.com/56

public class DiameterOfTree {

    private static Map<Integer, List<int[]>> map;
    private static boolean[] visited;

    public int solution(int n, int[][] inputs){
        map = new HashMap<>();
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            map.put(i, new LinkedList<>());
        }

        for (int[] input : inputs) {
            map.get(input[0]).add(new int[] {input[1], input[2]});
            map.get(input[1]).add(new int[] {input[0], input[2]});
        }

        visited[1] = true;
        int[] leafNode = dfs(1, 0);
        visited[1] = false;
        visited[leafNode[0]] = true;
        int[] result = dfs(leafNode[0], 0);

        return result[1];
    }

    private int[] dfs(int node, int weight){
        int[] result = {node, weight};

        for(int[] edge : map.get(node)){
            if(!visited[edge[0]]) {
                visited[edge[0]] = true;
                int[] temp = dfs(edge[0], weight + edge[1]);
                if(result[1] < temp[1]){
                    result = temp;
                }

                visited[edge[0]] = false;
            }
        }

        return result;
    }
}
