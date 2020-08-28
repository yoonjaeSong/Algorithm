package com.raccon.programmers.sort;

import java.util.Arrays;

public class P3 {
    public int solution(int[] citations) {
        int answer = 0;
        int index = 0;
        int quotation = 0;

        Arrays.sort(citations);
        while (index < citations.length) {
            if (quotation > citations[index]) {
                index++;
                continue;
            }

            if (quotation <= (citations.length - index)) {
                answer = quotation;
                quotation++;
            } else {
                break;
            }
        }

        return answer;
    }
}
