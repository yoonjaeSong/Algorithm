package com.raccon.backjoon.tree.p5052;

public class P5052 {
    public boolean solution(String[] phones){
        boolean result = true;
        Trie trie = new Trie();

        for (String phoneNumber : phones) {
            result = trie.insert(phoneNumber);
            if (!result) {
                break;
            }
        }

        return result;
    }
}

class Trie {

    private static final char STANDARD = '0';
    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public boolean insert(String word) {
        Node current = root;

        for (char s : word.toCharArray()) {
            int index = toInteger(s);
            if (!current.isExisted(index)) {
                current.add(index);
            }

            current = current.getChild(index);
            if (current.isLeaf()) {
                return false;
            }
        }

        current.setLeaf(true);
        for(int i=0; i<10; i++){
            if(current.getChild(i) != null){
                return false;
            }
        }

        return true;
    }

    private int toInteger(char s) {
        return s - STANDARD;
    }
}

class Node {

    private static final int NUMBER = 10;

    private boolean isLeaf;
    private Node[] children;

    public Node() {
        this.children = new Node[NUMBER];
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
