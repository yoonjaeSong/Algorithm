package com.raccon.backjoon.editor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditorTest {

    @Test
    public void testcase1() {
        String text = "dmih";
        String[] commands = {"B", "B", "P x", "L", "B", "B", "B", "P y", "D", "D", "P z"};
        Editor editor = new Editor(text);
        for(String command : commands){
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

        assertEquals(editor.getText(), "yxz");
    }

    @Test
    public void testcase2() {
        String text = "abc";
        String[] commands = {"L", "L", "L", "L", "L", "P x", "L", "B", "P y"};
        Editor editor = new Editor(text);
        for(String command : commands){
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

        assertEquals(editor.getText(), "yxabc");
    }

    @Test
    public void testcase3() {
        String text = "abcd";
        String[] commands = {"P x", "L", "P y"};
        Editor editor = new Editor(text);
        for(String command : commands){
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

        assertEquals(editor.getText(), "abcdyx");
    }
}