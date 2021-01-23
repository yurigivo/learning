package io.github.yurigivo.learning.algorithm;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;
import java.util.Map.Entry;

import static java.util.Collections.unmodifiableMap;

public class TopologicalSorting {
    private final Map<String, String> edges;

    public TopologicalSorting(List<Entry<String, String>> edges) {
        Map<String, String> mappedEdges = new LinkedHashMap<>(edges.size());
        for (Entry<String, String> edge : edges)
            mappedEdges.put(edge.getKey(), edge.getValue());
        this.edges = unmodifiableMap(mappedEdges);
    }

    public List<Entry<String, String>> getReconstructedGraph() {
        Set<String> visited = new HashSet<>();
        Stack<String> graph = new Stack<>();
        for (String fromNode : this.edges.keySet()) {
            Stack<String> subGraph = new Stack<>();
            String node = fromNode;
            while (node != null && !visited.contains(node)) {
                subGraph.push(node);
                visited.add(node);
                node = this.edges.get(node);
            }
            while (!subGraph.empty())
                graph.push(subGraph.pop());
        }

        List<Entry<String, String>> result = new ArrayList<>(this.edges.size());
        while (!graph.empty()) {
            String from = graph.pop();
            String to = this.edges.get(from);
            if (to != null)
                result.add(new SimpleEntry<>(from, to));
        }
        return result;
    }
}
