package com.raccon.backjoon.binray.semiconductor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 반도체 설계 (2352)
public class Semiconductor {
    public int solution(int[] ports){
        int index = 0;
        int[] memory = new int[ports.length];
        List<Integer> list = new ArrayList<>();

        // 초기 세팅
        list.add(ports[0]);
        memory[0] = 1;

        for(int i=1; i<ports.length; i++){
            if(list.get(list.size()-1) > ports[i]){
                index = lowerBoundary(list, ports[i]);
                list.set(index, ports[i]);
                memory[i] = index + 1;
                continue;
            }

            list.add(ports[i]);
            memory[i] = list.size();
        }

        return list.size();
    }

    private  int lowerBoundary(List<Integer> list, int target){
        int start = 0, end = list.size() - 1;

        while(start < end){
            int mid = (start + end) / 2;
            if(list.get(mid) >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        return end;
    }
}
