package com.raccon.backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class WordSort {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();

        for (int i=0; i<count;i++){
            String word = br.readLine();
            int length = word.length();

            if(!hashMap.containsKey(length)){
                hashMap.put(length, new ArrayList<>());
            }

            hashMap.get(length).add(word);
        }

        for(int key : hashMap.keySet()){
            ArrayList<String> list = hashMap.get(key);
            Collections.sort(list);

            for(String word : list){
                System.out.println(word);
            }
        }
    }
}
