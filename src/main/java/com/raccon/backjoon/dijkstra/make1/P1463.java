package com.raccon.backjoon.dijkstra.make1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class P1463 {
    public int bfs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        queue.add(number);
        int count = 0, turn = queue.size();
        int answer = 0;

        while (queue.size() != 0) {
            if (count == turn) {
                answer++;
                turn = queue.size();
                count = 0;
            }

            int front = queue.poll();
            if (front == 1) {
                break;
            }


            if (front % 3 == 0 && !set.contains(front / 3)) {
                queue.add(front / 3);
                set.add(front / 3);
            }

            if (front % 2 == 0 && !set.contains(front / 2)) {
                queue.add(front / 2);
                set.add(front / 2);
            }

            if (!set.contains(front - 1)) {
                queue.add(front - 1);
            }

            count++;
        }

        return answer;
    }

    public int dijkstra() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] array = new int[number + 1];
        array[1] = 0;

        for(int i=2; i<=number; i++){
            array[i] = array[i-1] + 1;
            if(i%2 == 0){
                array[i] = Math.min(array[i], array[i/2] + 1);
            }
            if(i%3 == 0){
                array[i] = Math.min(array[i], array[i/3] + 1);
            }
        }

        return array[number];
    }
}
