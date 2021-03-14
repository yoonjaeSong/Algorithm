package com.raccon.backjoon.tree.구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer stz;

    private int N, M, K;

    private long[] tree;
    private int leafStart;

    public void solution(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());

        init();
        print();

        long answer = 0;
        for (int i = 0; i < (M + K); i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            long c = Long.parseLong(stz.nextToken());

            if (a == 1) {
                update(b, c);
                print();
            } else {
                answer = sum(b, c);
                System.out.println(answer);
            }
        }
    }

    private void print(){
        for(int i=1; i<tree.length; i++){
            System.out.print(tree[i]  + " ");
        }
        System.out.println();
    }

    private long sum(int left, long right) {
        long result = 0;

        left = leafStart + left - 1;
        right = leafStart + right - 1;

        while (left <= right) {
            if (left % 2 == 1) {
                result += tree[left];
                left++;
            }

            if (right % 2 == 0) {
                result += tree[(int) right];
                right--;
            }

            left /= 2;
            right /= 2;
        }

        return result;
    }

    private void update(int index, long value) {
        index = leafStart + index - 1;

        tree[index] = value;
        index /= 2;
        while (index > 0) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
            index /= 2;
        }
    }

    private void init() throws IOException {
        tree = new long[N * 4];

        leafStart = 1;
        while (N > leafStart) {
            leafStart *= 2;
        }

        for (int i = 0; i < N; i++) {
            tree[leafStart + i] = Long.parseLong(br.readLine());
        }

        for (int i = leafStart - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }
}
