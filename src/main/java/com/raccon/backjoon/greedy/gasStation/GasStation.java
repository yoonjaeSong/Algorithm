package com.raccon.backjoon.greedy.gasStation;

public class GasStation {
    public long solution(long[] distance, long[] gasStation){
        long result = 0L;
        long money = gasStation[0];
        for(int i=0; i<distance.length; i++){
            money = Math.min(money, gasStation[i]);
            result += money*distance[i];
        }

        return result;
    }
}