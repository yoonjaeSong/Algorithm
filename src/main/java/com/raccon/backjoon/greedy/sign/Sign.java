package com.raccon.backjoon.greedy.sign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sign {

    public String[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] answer = new String[2];
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        answer[0] = findMax(inputs);
        answer[1] = findMin(inputs);

        return answer;
    }

    private String findMin(String[] inputs) {
        int num = 0;
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(String sign : inputs){
            if(sign.equals("<")){
                result.append(num);
                while(!stack.empty()){
                    result.append(stack.pop());
                }
            }else{
                stack.add(num);
            }

            num++;
        }

        result.append(num);
        while(!stack.empty()){
            result.append(stack.pop());
        }

        return result.toString();
    }

    private String findMax(String[] inputs) {
        int num = 9;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (String sign : inputs) {
            if (sign.equals(">")) {
                sb.append(num);
                while(!stack.empty()){
                    sb.append(stack.pop());
                }
            }else{
                stack.add(num);
            }

            num--;
        }

        sb.append(num);
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
