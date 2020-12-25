package com.raccon.backjoon.text;

public class P9935 {
    public String solution(String text, String explosionWords) {
        char[] answer = new char[text.length()];
        int standardIndex = explosionWords.length() - 1;
        int index = 0;

        for (int i = 0; i < text.length(); i++) {
            answer[index++] = text.charAt(i);
            if (text.charAt(i) == explosionWords.charAt(standardIndex)) {
                if (run(answer, explosionWords, index)) {
                    index -= explosionWords.length();
                }
            }
        }

        if (index == 0) {
            return "FRULA";
        }

        return String.valueOf(answer, 0, index);
    }

    private boolean run(char[] answer, String explosionWords, int index) {
        if (index < explosionWords.length()) {
            return false;
        }

        int answerIndex = index - explosionWords.length();
        for (int i = 0; i < explosionWords.length(); i++) {
            if (explosionWords.charAt(i) != answer[answerIndex]) {
                return false;
            }

            answerIndex++;
        }

        return true;
    }
}
