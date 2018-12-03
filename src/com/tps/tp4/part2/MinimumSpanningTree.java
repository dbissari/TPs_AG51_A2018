/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author dbissari
 */
class MinimumSpanningTree {
    
    /**
     * Using Disjoint set(s), run Kruskal's algorithm on the given graph and return the MST, return
     * null if no MST exists for the graph
     * 
     * @param g
     *          The graph, g will never be null
     * @return the MST of the graph, null if no valid MST exists
     */
    Collection<Edge> kruskals(Graph g) {
    	if (g==null || g.getEdgeList().size() < (g.getVertices().size()-1))
            return null;
        ArrayList<Edge> edgeList =  new ArrayList<>(g.getEdgeList());
        ArrayList<Edge> finalEdges = new ArrayList<>();
        DisjointSets<Vertex> disjointSet = new DisjointSets<>(g.getVertices());
        Collections.sort(edgeList);
        edgeList.forEach((min) -> {
            Vertex a = min.getU();
            Vertex b = min.getV();
            if (!disjointSet.sameSet(a, b)) {
                disjointSet.merge(a, b);
                finalEdges.add(min);
            }
        });
        
        return finalEdges;
    }

    /**
     * Run Prim's algorithm on the given graph and return the minimum spanning tree
     * If no MST exists, return null
     * 
     * @param g 
     * 		The graph to be processed.  Will never be null
     * @return the MST of the graph, null if no valid MST exists
     */
    Collection<Edge> prims(Graph g) {
    	Vertex startVertex = new Vertex(0);
    	Vertex currentVertex = startVertex;
    	Collection<Edge> finalEdges = new ArrayList();
    	Collection<Edge> edgeList = g.getEdgeList();
    	ArrayList<Vertex> visited = new ArrayList();
    	visited.add(startVertex);
    	PriorityQueue<Edge> pq = new PriorityQueue<>();
    	Map<Vertex, Integer> map = g.getAdjacencies(startVertex);
        
    	Set<Vertex> set = map.keySet();
        set.forEach((Vertex v) -> {
            pq.add(new Edge(startVertex, v, map.get(v)));
        });
    	while(visited.size()!= g.getVertices().size() && !pq.isEmpty()) {
            Edge min = pq.poll();
            if(!visited.contains(min.getU()) || !visited.contains(min.getV())) {
                finalEdges.add(min);
                if(!visited.contains(min.getU()))
                    currentVertex = min.getU();
                else if(!visited.contains(min.getV()))
                    currentVertex = min.getV();
                map.putAll(g.getAdjacencies(currentVertex));
                visited.add(currentVertex);
                set = map.keySet();
                for(Vertex v:set) {
                    if(edgeList.contains(new Edge(currentVertex,v, map.get(v))))
                        pq.add(new Edge(currentVertex,v, map.get(v)));
                }
            }
    	}
    	if (pq.isEmpty())
            return null;
        
        return finalEdges;
    }
}
