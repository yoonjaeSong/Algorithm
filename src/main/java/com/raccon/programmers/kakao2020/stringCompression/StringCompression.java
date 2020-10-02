package com.raccon.programmers.kakao2020.stringCompression;

public class StringCompression {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int length = 1; length <= (int) s.length() / 2; length++) {
            StringBuilder sb = new StringBuilder();
            String before = s.substring(0, length);
            String word = null;
            int temp = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i += length) {
                int end = Math.min(i + length, s.length());
                word = s.substring(i, end);

                //연속성
                if (before.equals(word)) {
                    count++;
                } else {
                    if (count != 1) {
                        temp += 1;
                        sb.append(count);
                    }

                    temp += length;
                    sb.append(before);
                    before = word;
                    count = 1;
                }
            }

            if (count != 1) {
                temp += 1;
                sb.append(count);
            }

            temp += word.length();
            sb.append(before);

            answer = Math.min(answer, temp);
        }

        return answer;
    }
}
