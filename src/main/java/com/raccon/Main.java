package com.raccon;

import com.raccon.backjoon.editor.Editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        Editor editor = new Editor(text);

        int count = Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            String command = br.readLine();
            switch (command) {
                case "L":
                    editor.moveLeft();
                    break;
                case "D":
                    editor.moveRight();
                    break;
                case "B":
                    editor.delete();
                    break;
                default:
                    String word = command.split(" ")[1];
                    editor.insert(word);
                    break;
            }

        }

        System.out.println(editor.getText());
    }
}
