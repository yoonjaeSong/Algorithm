package com.raccon.samsung.factorization;

public class Factorization {
    public void solution(int[] array) {
        for (int i = 1; i <= array.length; i++) {
            System.out.println("#" + i + " " + arrayToString(factorization(array[i - 1])));
        }
    }

    private int[] factorization(int number) {
        int[] base = {2, 3, 5, 7, 11};
        int[] answer = new int[5];

        int index = 0, count = 0;
        for (int b : base) {
            count = 0;
            while (number % b == 0) {
                if (number == 0) {
                    break;
                }

                count++;
                number /= b;
            }

            answer[index++] = count;
        }

        return answer;
    }

    private String arrayToString(int[] array) {
        int iMax = array.length - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; ; i++) {
            sb.append(array[i]);
            if (i == iMax) {
                break;
            }
            sb.append(" ");
        }

        return sb.toString();
    }
}
