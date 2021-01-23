package io.github.yurigivo.learning.algorithm;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;

public class TopologicalSortingTest {
    @Test public void reconstructsGraph() {
        List<Entry<String, String>> nodes = Arrays.asList(
                new AbstractMap.SimpleEntry<>("C", "D"),
                new AbstractMap.SimpleEntry<>("A", "B"),
                new AbstractMap.SimpleEntry<>("D", "E"),
                new AbstractMap.SimpleEntry<>("B", "C"),
                new AbstractMap.SimpleEntry<>("E", "F")
        );
        List<Entry<String, String>> graph = new TopologicalSorting(nodes).getReconstructedGraph();
        assertEquals(5, graph.size());
        assertEquals(new AbstractMap.SimpleEntry<>("A", "B"), graph.get(0));
        assertEquals(new AbstractMap.SimpleEntry<>("B", "C"), graph.get(1));
        assertEquals(new AbstractMap.SimpleEntry<>("C", "D"), graph.get(2));
        assertEquals(new AbstractMap.SimpleEntry<>("D", "E"), graph.get(3));
        assertEquals(new AbstractMap.SimpleEntry<>("E", "F"), graph.get(4));
    }
}