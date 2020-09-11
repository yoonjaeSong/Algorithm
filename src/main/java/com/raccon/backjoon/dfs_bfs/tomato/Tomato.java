package com.raccon.backjoon.dfs_bfs.tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Tomato {

    private Queue<Position> queue = new ArrayDeque<>();

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]), n = Integer.parseInt(inputs[1]);

        int[][] box = new int[n][m];
        int totalTomato = n*m;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int tomato = Integer.parseInt(line[j]);
                box[i][j] = tomato;

                if (tomato == 1) {
                    queue.add(new Position(j, i));
                }else if (tomato == -1){
                    totalTomato--;
                }
            }
        }

        int day = 0, tomatoCount = 0;
        int count = 0, standard = queue.size();
        while (queue.size() > 0) {

            if (count == standard) {
                day++;
                count = 0;
                standard = queue.size();
            }

            Position position = queue.poll();
            bfs(box, position);

            count++;
            tomatoCount++;
        }

        return (totalTomato == tomatoCount) ? day : -1;
    }

    private void bfs(int[][] box, Position position) {

        //상
        if ((position.getY() - 1) >= 0 && box[position.getY() - 1][position.getX()] == 0) {
            queue.add(new Position(position.getX(), position.getY() - 1));
            box[position.getY() - 1][position.getX()] = 1;
        }

        // 하
        if ((position.getY() + 1) < box.length && box[position.getY() + 1][position.getX()] == 0) {
            queue.add(new Position(position.getX(), position.getY() + 1));
            box[position.getY() + 1][position.getX()] = 1;
        }

        //좌
        if ((position.getX() - 1) >= 0 && box[position.getY()][position.getX() - 1] == 0) {
            queue.add(new Position(position.getX() - 1, position.getY()));
            box[position.getY()][position.getX() - 1] = 1;
        }

        if ((position.getX() + 1) < box[0].length && box[position.getY()][position.getX() + 1] == 0) {
            queue.add(new Position(position.getX() + 1, position.getY()));
            box[position.getY()][position.getX() + 1] = 1;
        }
    }
}
