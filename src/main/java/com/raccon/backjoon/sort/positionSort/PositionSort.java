package com.raccon.backjoon.sort.positionSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PositionSort {
    public void solution(int row, int[][] array){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int[] item : array) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], new ArrayList<>());
            }

            map.get(item[0]).add(item[1]);
        }

        for (int i = -100000; i <= 100000; i++) {
            if(!map.containsKey(i)){
                continue;
            }

            Collections.sort(map.get(i));
            for(int y : map.get(i)){
                System.out.println(i + " " + y);
            }
        }
    }
}
