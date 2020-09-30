package com.raccon.inflearn.binarySearch;

public class CutLANCable {
    public int solution(int[] cables, int k){
        int sum = 0;
        for(int cable : cables){
            sum += cable;
        }

        int length = sum / k;
        int count = -1;
        while(true){
            count = 0;
            for(int cable : cables){
                count += cable / length;
            }

            if(count == k){
                break;
            }

            length--;
        }

        return length;
    }
}
