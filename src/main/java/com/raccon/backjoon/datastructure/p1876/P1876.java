package com.raccon.backjoon.datastructure.p1876;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1876 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            // pop작업
            while(!stack.empty() && (stack.peek() == array[index])){
                stack.pop();
                result.add("-");
                index++;
            }

            // push작업
            stack.push(i);
            result.add("+");
        }

        while(!stack.empty()){
            if(stack.peek() == array[index]) {
                stack.pop();
                result.add("-");
                index++;
            }else{
                flag = false;
                break;
            }
        }

        if(flag){
            for(String s : result){
                System.out.println(s);
            }
        }else{
            System.out.println("NO");
        }
    }
}
