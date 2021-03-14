package com.raccon.backjoon.tree.최소최대값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소최대값 {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer stz;

    private int N, M;

    private Node[] tree;
    private int leafStart;

    public void solution() throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        init();

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());

            int[] result = find(1, a, b);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    private int[] find(int index, int left, int right) {

        if (tree[index].left > right || tree[index].right < left) {
            return new int[]{1_000_000_001, 0};
        }

        if (left <= tree[index].left && tree[index].right <= right) {
            return new int[]{tree[index].minimum, tree[index].maximum};
        }

        int[] leftNode = find(index * 2, left, right);
        int[] rightNode = find(index * 2 + 1, left, right);

        return new int[]{Math.min(leftNode[0], rightNode[0]), Math.max(leftNode[1], rightNode[1])};
    }

    private void init() throws IOException {
        leafStart = 1;
        while (N > leafStart) {
            leafStart *= 2;
        }

        tree = new Node[N * 4];
        for (int i = 0; i < N * 4; i++) {
            tree[i] = new Node();
        }

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            tree[leafStart + i].insert(value);
            tree[leafStart + i].left = i + 1;
            tree[leafStart + i].right = i + 1;
        }

        for (int i = leafStart - 1; i > 0; i--) {
            for (int j = 0; j < 2; j++) {
                tree[i].insert(tree[i * 2 + j].minimum);
                tree[i].insert(tree[i * 2 + j].maximum);
                tree[i].updateRange(tree[i * 2 + j]);
            }
        }
    }
}

class Node {
    int minimum, maximum;
    int left, right;

    public Node() {
        this.minimum = 1_000_000_001;
        this.maximum = 0;
        this.left = 1_000_000_001;
        this.right = 0;
    }

    public void insert(int value) {
        if (value == 0 || value == 1_000_000_001) {
            return;
        }

        minimum = Math.min(minimum, value);
        maximum = Math.max(maximum, value);
    }

    public void updateRange(Node node) {
        this.left = Math.min(this.left, node.left);
        this.right = Math.max(this.right, node.right);
    }
}