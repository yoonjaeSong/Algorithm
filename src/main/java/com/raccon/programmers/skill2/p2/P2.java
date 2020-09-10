package com.raccon.programmers.skill2.p2;

import java.util.PriorityQueue;

public class P2 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;

        for (int value : scoville) {
            heap.add(value);
        }

        while (heap.size() > 1) {
            int a = heap.poll();
            int b = heap.poll();

            answer++;
            int newScoville = makeScovelle(a, b);
            heap.add(newScoville);
            if (K <= heap.peek()) {
                return answer;
            }

        }

        return -1;
    }

    private int makeScovelle(int a, int b) {
        return a + (b * 2);
    }
}
