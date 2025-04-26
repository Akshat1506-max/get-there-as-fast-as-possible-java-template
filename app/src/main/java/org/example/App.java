package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class App {

    public static int dijkstra(Map<Integer, List<int[]>> graph, int start, int end) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();

        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        minHeap.offer(new int[]{start, 0});

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (currentNode == end) return currentDistance;

            if (currentDistance > distances.get(currentNode)) continue;

            for (int[] neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDistance = currentDistance + weight;

                if (newDistance < distances.get(nextNode)) {
                    distances.put(nextNode, newDistance);
                    minHeap.offer(new int[]{nextNode, newDistance});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        graph.put(1, Arrays.asList(new int[]{2, 1}, new int[]{5, 1}));
        graph.put(2, Arrays.asList(new int[]{4, 1}));
        graph.put(4, Arrays.asList(new int[]{3, 1}));
        graph.put(3, Arrays.asList(new int[]{5, 1}));
        graph.put(5, new ArrayList<>());

        System.out.println(dijkstra(graph, 1, 2)); // Output: 1
        System.out.println(dijkstra(graph, 1, 5)); // Output: 1
        System.out.println(dijkstra(graph, 2, 5)); // Output: 3
        System.out.println(dijkstra(graph, 5, 1)); // Output: -1
        System.out.println(dijkstra(graph, 2, 1)); // Output: -1
    }
}