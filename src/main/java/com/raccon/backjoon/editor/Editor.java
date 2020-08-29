package com.raccon.backjoon.editor;

import java.util.Stack;

public class Editor {

    private Stack<String> leftStack;
    private Stack<String> rightStack;

    public Editor(String text) {
        this.leftStack = new Stack<>();
        this.rightStack = new Stack<>();

        for(int i=0; i<text.length(); i++){
            this.leftStack.push(String.valueOf(text.charAt(i)));
        }
    }

    public void moveLeft(){
        if(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
    }

    public void moveRight(){
        if(!rightStack.isEmpty()){
            leftStack.push(rightStack.pop());
        }
    }

    public void delete(){
        if(!leftStack.isEmpty()){
            leftStack.pop();
        }
    }

    public void insert(String word){
        leftStack.push(word);
    }

    public String getText() {
        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }

        while(!rightStack.isEmpty()){
            sb.append(rightStack.pop());
        }

        return sb.toString();
    }
}
