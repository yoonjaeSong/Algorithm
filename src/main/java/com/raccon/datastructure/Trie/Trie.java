package com.raccon.datastructure.Trie;

public class Trie {

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node current = root;

        for (char s : word.toCharArray()) {
            int index = toInteger(s);
            if (!current.isExisted(index)) {
                current.add(index);
            }

            current = current.getChild(index);
        }

        current.setLeaf(true);
    }

    public boolean find(String word) {
        Node current = root;

        for (char s : word.toCharArray()) {
            int index = toInteger(s);
            if (!current.isExisted(index)) {
                return false;
            }

            current = current.getChild(index);
        }

        return current.isLeaf();
    }

    private int toInteger(char s) {
        return s - 'a';
    }

    public boolean delete(String word) {
        return delete(word, 0, root);
    }

    private boolean delete(String word, int lenght, Node node) {
        int index = toInteger(word.charAt(lenght));
        Node child = node.getChild(index);

        if (child == null) {
            return false;
        }

        if (lenght == word.length() - 1) {
            boolean result = child.isLeaf();
            child.setLeaf(false);
            return result;
        } else {
            return delete(word, lenght + 1, child);
        }
    }
}

class Node {

    private static final int ALPHABETS = 26;

    private boolean isLeaf;
    private Node[] children;

    public Node() {
        this.children = new Node[ALPHABETS]; // 영어 소문자 기준
    }

    public boolean isExisted(int index) {
        return children[index] != null;
    }

    public void add(int index) {
        children[index] = new Node();
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public Node getChild(int index) {
        return children[index];
    }
}
