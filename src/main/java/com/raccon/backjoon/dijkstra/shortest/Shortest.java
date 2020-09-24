package com.raccon.backjoon.dijkstra.shortest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Shortest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int v = Integer.parseInt(line[0]), e = Integer.parseInt(line[1]);
        int start = Integer.parseInt(br.readLine()) - 1;

        Node[] nodeList = new Node[v];
        for (int i = 0; i < v; i++) {
            nodeList[i] = new Node(i);
        }

        for (int i = 0; i < e; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]) - 1, b = Integer.parseInt(inputs[1]) - 1, w = Integer.parseInt(inputs[2]);
            nodeList[a].getEdges().add(new Edge(b, w));
        }

        for (int n : dijkstra(nodeList, start)) {
            if (n == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(n);
            }
        }
    }

    private static int[] dijkstra(Node[] nodes, int start) {

        int[] dist = new int[nodes.length];
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getNode() > o2.getNode() ? 1 : -1;
            }
        });

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        queue.add(nodes[start]);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.isVisited()) {
                continue;
            }

            node.visit();
            for (Edge edge : node.getEdges()) {
                if (dist[edge.getDestination()] > edge.getWeight() + dist[node.getNode()]) {
                    dist[edge.getDestination()] = edge.getWeight() + dist[node.getNode()];
                    queue.add(nodes[edge.getDestination()]);
                }
            }
        }

        return dist;
    }
}

class Edge {

    private int destination;
    private int weight;

    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }
}

class Node {

    private int node;
    private List<Edge> edges;
    private boolean visited;

    public Node(int node) {
        this.node = node;
        this.visited = false;
        this.edges = new ArrayList<>();
    }

    public int getNode() {
        return node;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean isVisited() {
        return visited;
    }

    public void visit() {
        this.visited = true;
    }
}
