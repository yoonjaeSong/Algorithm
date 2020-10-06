package com.raccon.backjoon.dfs_bfs.project;

public class Project {

    private boolean[] visited;
    private boolean[] finished;

    public int[] solution(int[][] testcase) {
        int[] answer = new int[testcase.length];

        int index = 0;
        for (int[] students : testcase) {
            int count = 0;
            visited = new boolean[students.length];
            finished = new boolean[students.length];
            for (int j = 0; j < students.length; j++) {
                if (!visited[j]) {
                    count += dfs(students, j);
                }
            }

            answer[index] = students.length - count;
            index++;
        }

        return answer;
    }

    private int dfs(int[] students, int now) {
        int count = 0;

        visited[now] = true;
        int next = students[now] - 1;

        if (!visited[next]) {
            count = dfs(students, next);
        } else if (!finished[next]) {
            count++;
            int i = now;
            while ((students[i] - 1) != now) {
                count++;
                i = students[i]-1;
            }
        }

        finished[now] = true;
        return count;
    }
}
