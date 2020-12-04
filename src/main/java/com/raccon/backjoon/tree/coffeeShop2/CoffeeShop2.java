package com.raccon.backjoon.tree.coffeeShop2;

public class CoffeeShop2 {
    public long[] solution(int[] array, int[][] input) {
        long[] answer = new long[input.length];

        SegmentTree segmentTree = new SegmentTree(array);
        for (int i = 0; i < input.length; i++) {
            int x = input[i][0];
            int y = input[i][1];
            int index = input[i][2];
            int value = input[i][3];

            int left = Math.min(x, y), right = Math.max(x, y);

            answer[i] = segmentTree.sum(left, right);
            segmentTree.update(index, value);
        }

        return answer;
    }
}

class SegmentTree {

    private Node root;
    private int start;
    private int end;

    public SegmentTree(int[] array) {
        this.root = new Node();
        this.start = 0;
        this.end = array.length - 1;
        init(this.root, array, start, end);
    }

    private void init(Node node, int[] array, int start, int end) {
        if (start == end) {
            node.value = array[start];
            return;
        }

        node.left = new Node();
        node.right = new Node();
        int mid = (start + end) / 2;

        init(node.left, array, start, mid);
        init(node.right, array, mid + 1, end);

        node.value = node.left.value + node.right.value;
    }

    public long sum(int left, int right) {
        return sum(root, start, end, left - 1, right - 1);
    }

    private long sum(Node node, int start, int end, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return node.value;
        }

        int mid = (start + end) / 2;
        return sum(node.left, start, mid, left, right) + sum(node.right, mid + 1, end, left, right);
    }

    public void update(int index, int value) {
        update(root, start, end, index - 1, value);
    }

    private void update(Node node, int start, int end, int index, int value) {
        if ((start == index) && (end == index)) {
            node.value = value;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            update(node.left, start, mid, index, value);
        } else {
            update(node.right, mid + 1, end, index, value);
        }

        node.value = node.left.value + node.right.value;
    }
}

class Node {

    long value;
    Node left;
    Node right;

    public Node() {
    }
}