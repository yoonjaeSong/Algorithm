package com.raccon.backjoon.greedy.p1541;

public class P1541 {
    public int solution(String input){
        String[] list = input.split("-");

        int result = calculate(list[0]);
        for(int i=1; i<list.length; i++){
            result -= calculate(list[i]);
        }

        return result;
    }

    private int calculate(String str){
        String[] list = str.split("\\+");

        int result = 0;
        for(String s : list){
            int number = Integer.parseInt(s);
            result += number;
        }

        return result;
    }
}
