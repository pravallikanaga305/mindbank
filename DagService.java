package com.mindbank.dag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


@Service
public class DagService {
    private final Map<Vertex, List<Vertex>> graph = new HashMap<>();

    // Map to store the longest path from each vertex (memoization)
    private final Map<Vertex, Integer> longestPathMap = new HashMap<>();

    public void addEdge(Edge edge) {
        graph.computeIfAbsent(edge.from, k -> new ArrayList<>()).add(edge.to);
    }

    public int findLongestPath(Vertex start) {
        // If the result is already computed, return it
        if (longestPathMap.containsKey(start)) {
            return longestPathMap.get(start);
        }

        // Base case: if there are no outgoing edges from the current vertex
        if (!graph.containsKey(start) || graph.get(start).isEmpty()) {
            longestPathMap.put(start, 0);
            return 0;
        }

        int maxLength = 0;

        // Explore all outgoing edges from the current vertex
        for (Vertex neighbor : graph.get(start)) {
            int currentLength = 1 + findLongestPath(neighbor);
            maxLength = Math.max(maxLength, currentLength);
        }

        // Store the result in the map before returning
        longestPathMap.put(start, maxLength);
        return maxLength;
    }
}
