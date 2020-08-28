package com.raccon.programmers.hash;

import java.util.HashMap;

public class Camouflage {

    private HashMap<String, Integer> clothesMap;

    public Camouflage() {
        clothesMap = new HashMap<>();
    }

    public int solution(String[][] clothesList) {

        // 옷의 종류(type)별로 개수 세기
        // [의상 이름, 의상 종류]
        for(String[] clothes : clothesList){
             clothesMap.put(clothes[1], clothesMap.getOrDefault(clothes[1], 0) + 1);
        }

        // 계산
        // 각 의상 종류의 의상 개수 + 1만큼 더한뒤 모든 수를 곱한뒤 -1하면 된다.
        // -1의 의미 : 모든 의상 종류를 선택하지 않은 경우
        // A type - n개, B type - m개, C type - l개 라면
        // (n+1)*(m+1)*(l+1) - 1
        int result = 1;
        for(int clothCount : clothesMap.values()){
            result *= (clothCount + 1);
        }

        return result -1;
    }
}
