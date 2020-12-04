package com.raccon.backjoon.tree.traversal;

public class Traversal {

    private int[] preOrder;
    private int[] inOrder; // 길이 n + 1
    private int[] postOrder;
    int index = 0;

    public int[] solution(int[] inOrder, int[] postOrder) {
        this.inOrder = inOrder;
        this.postOrder = postOrder;
        this.preOrder = new int[inOrder.length - 1];

        int start = 1, end = inOrder.length - 1;
        findTree(start, end, start, end);

        return preOrder;
    }

    private void findTree(int inOrderStart, int inOrderEnd, int postOrderStart, int postOrderEnd) {
        int root = postOrder[postOrderEnd];

        preOrder[index++] = root;
        if (inOrderStart == inOrderEnd) {
            return;
        }

        int rootIndex = inOrder[root];
        int total = inOrderEnd - inOrderStart + 1;
        int leftCount = rootIndex - inOrderStart;

        // 왼쪽 sub tree
        if (leftCount > 0) {
            findTree(inOrderStart, rootIndex - 1, postOrderStart, postOrderStart + leftCount - 1);
        }

        int rightCount = total - leftCount - 1;
        if (rightCount > 0) {
            findTree(rootIndex + 1, inOrderEnd, postOrderEnd - rightCount, postOrderEnd - 1);
        }
    }
}
