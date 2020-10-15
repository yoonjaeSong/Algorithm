package com.raccon.samsung.securityCode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class P1240 {
    public int solution(int n, int m, int[][] array) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);

            int[] code = new int[m];
            int[] answer = new int[8];
            for (int[] line : array) {
                for (int j = 0; j < m; j++) {
                    code[j] = code[j] | line[j];
                }
            }

            int end = 0;
            for (int i = m - 1; i >= 0; i--) {
                if (code[i] == 1) {
                    end = i;
                    break;
                }
            }

            for (int index = 0; index < 8; index++) {
                int result = convert(map, code, end-6);
                answer[index] = result;
                end -= 7;
            }

            return check(answer);
    }

    private int check(int[] array) {
        int result = 0;
        for (int i = 7; i >= 0; i--) {
            if (i % 2 == 1) {
                result = result + array[i] * 3;
            } else {
                result = result + array[i];
            }
        }

        if(result % 10 == 0){
            int answer = 0;
            for(int value : array){
                answer += value;
            }

            return answer;
        }else{
            return 0;
        }
    }

    private static int convert(Map<String, Integer> map, int[] code, int start) {
        StringBuilder sb = new StringBuilder();

        for (int i = start; i < start + 7; i++) {
            sb.append(code[i]);
        }

        return map.getOrDefault(sb.toString(), -1);
    }
}
