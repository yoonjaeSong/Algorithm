package com.raccon.backjoon.mst.p4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4386 {

    private class Edge implements Comparable<Edge> {
        int a, b;
        double distance;

        public Edge(int a, int b, double distance) {
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.distance > edge.distance ? 1 : (this.distance == edge.distance) ? 0 : -1;
        }
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stz;

    private static int n;
    private static double[][] star;
    private static Edge[] edges;
    private static int[] p;

    public double solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        star = new double[n][2];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(stz.nextToken());
            double y = Double.parseDouble(stz.nextToken());

            star[i][0] = x;
            star[i][1] = y;
        }

        edges = new Edge[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges[index++] = new Edge(i, j, getDistance(i, j));
            }
        }

        Arrays.sort(edges, 0, index);
        p = new int[index];
        for (int i = 0; i < index; i++) {
            p[i] = i;
        }

        double answer = 0.0;
        for (int i = 0; i < index; i++) {
            int aRoot = find(edges[i].a);
            int bRoot = find(edges[i].b);

            if (aRoot == bRoot) {
                continue;
            }

            p[aRoot] = bRoot;
            answer += edges[i].distance;
        }

        return Math.round(answer * 100) / 100.0;
    }

    private int find(int n) {
        if (p[n] == n) return n;
        return p[n] = find(p[n]);
    }

    private double getDistance(int a, int b) {
        double xx = star[a][0] - star[b][0];
        double yy = star[a][1] - star[b][1];

        return Math.sqrt(xx * xx + yy * yy);
    }
}
