/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author dbissari
 */
class Graph {
    
    private final Collection<Edge> edges = new HashSet<>();
    private final Set<Vertex> vertices = new HashSet<>();
    private final Map<Vertex, Map<Vertex, Integer>> adjacencies = new HashMap<>();

    Graph(int size) {
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            Vertex u = new Vertex(i);
            Vertex v = new Vertex(i);
            int weight =r.nextInt();
            vertices.add(u);
            vertices.add(v);
            edges.add(new Edge(u, v, weight));

            if (!adjacencies.containsKey(u))
                adjacencies.put(u, new HashMap<>());
            adjacencies.get(u).put(v, weight);

            if (!adjacencies.containsKey(v))
                adjacencies.put(v, new HashMap<>());
            adjacencies.get(v).put(u, weight);
        }
    }

    Collection<Edge> getEdgeList() {
        return edges;
    }

    Set<Vertex> getVertices() {
        return vertices;
    }

    Map<Vertex, Integer> getAdjacencies(Vertex u) {
        return adjacencies.get(u);
    }
}
