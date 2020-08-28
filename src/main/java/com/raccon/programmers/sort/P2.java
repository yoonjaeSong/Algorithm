package com.raccon.programmers.sort;

public class P2 {
    public String solution(int[] numbers) {
        String answer = "";

        mergeSort(numbers, 0, numbers.length-1);

        for (int number : numbers) {
            answer = answer + number;
        }

        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (int) (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        combine(array, start, mid, end);
    }

    private void combine(int[] array, int start, int mid, int end) {
        int[] temp = new int[(end - start + 1)];
        int left = start, right = mid + 1, index = 0;

        while (left <= mid && right <= end) {
            String a = String.valueOf(array[left]);
            String b = String.valueOf(array[right]);
            int check = (a + b).compareTo((b + a));
            if (check > 0) { // 우선순위 a > b
                temp[index++] = array[left++];
            } else if (check < 0) { // a < b
                temp[index++] = array[right++];
            } else { // a == b
                temp[index++] = array[left++];
                temp[index++] = array[right++];
            }
        }

        while(left <= mid){
            temp[index++] = array[left++];
        }

        while(right <= end){
            temp[index++] = array[right++];
        }

        for (int i = 0; i < index; i++) {
            array[start+i] = temp[i];
        }
    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
