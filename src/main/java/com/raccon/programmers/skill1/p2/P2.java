package com.raccon.programmers.skill1.p2;

public class P2 {
    public boolean solution(String s) {
        int length = s.length();

        if((length != 4) && (length != 6)){
            return false;
        }

        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
