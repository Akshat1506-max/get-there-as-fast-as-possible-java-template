package org.example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testDijkstra() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        graph.put(1, Arrays.asList(new int[]{2, 1}, new int[]{5, 1}));
        graph.put(2, Arrays.asList(new int[]{4, 1}));
        graph.put(4, Arrays.asList(new int[]{3, 1}));
        graph.put(3, Arrays.asList(new int[]{5, 1}));
        graph.put(5, new ArrayList<>());

        assertEquals(1, App.dijkstra(graph, 1, 2));
        assertEquals(1, App.dijkstra(graph, 1, 5));
        assertEquals(3, App.dijkstra(graph, 2, 5));
        assertEquals(-1, App.dijkstra(graph, 5, 1));
        assertEquals(-1, App.dijkstra(graph, 2, 1));
    }
}