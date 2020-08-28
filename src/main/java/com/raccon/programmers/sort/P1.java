package com.raccon.programmers.sort;

import java.util.Arrays;

public class P1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for (int[] command : commands) {
            int from = command[0]-1;
            int to = command[1];
            int k = command[2]-1;
            int[] subArray = Arrays.copyOfRange(array, from, to);
            quickSort(subArray, 0, subArray.length-1);

            answer[index] = subArray[k];
            index++;
        }

        return answer;
    }

    public void quickSort(int[] array, int start, int end) {

        if ((end-start + 1) <= 1 ) {
            return;
        }

        int pivot = array[start];
        int leftIndex = start;
        int rightIndex = end;

        while (leftIndex < rightIndex) {
            // leftIndex 이동
            // pivot보다 큰 값이 나올 때까지
            while((pivot >= array[leftIndex]) && (leftIndex < end)){
                leftIndex++;
            }

            // rightIndex 이동
            // pivot 보가 작은 값이 나올 때 까지
            while((pivot < array[rightIndex]) && (rightIndex > start)){
                rightIndex--;
            }

            if(leftIndex < rightIndex){
                swap(array, leftIndex, rightIndex);
            }
        }

        swap(array, start, rightIndex);
        //left quick sort
        quickSort(array, start, rightIndex - 1);
        quickSort(array, rightIndex + 1, end);
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
