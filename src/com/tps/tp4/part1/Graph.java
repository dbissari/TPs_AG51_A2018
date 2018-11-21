/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author bright
 */
public class Graph {
    static private final int ROOT = 0;
    /* Adjacency matrix. If an element is different from 0, then we have a
     * link between these two nodes. The value is the weight of the edge */
    private final int[][] adjacency;
    private ArrayList visited;
    private final int size;
    private int nbEdges;

    public Graph(int M) {
        this.size = M;
        this.nbEdges = 0;
        this.adjacency = new int[M][M];
        this.visited = new ArrayList();
    }

    public Graph(int M, double probability) {
        this.size = M;
        this.nbEdges = 0;
        this.adjacency = new int[M][M];
        this.visited = new ArrayList<>();

        ArrayList<Integer> notConnected = new ArrayList<>();
        ArrayList<Integer> connected = new ArrayList<>();
        Random r = new Random();

        connected.add(0);
        for(int i = 1; i < size; i++)
            notConnected.add(i);

        while(!notConnected.isEmpty()) {
            int nodeIndex = Math.abs(r.nextInt()%notConnected.size());
            int node = notConnected.get(nodeIndex);

            int mountIndex = Math.abs(r.nextInt()%connected.size());
            int mountPoint = connected.get(mountIndex);

            int weight = Math.abs(r.nextInt()%100)+1;

            this.adjacency[node][mountPoint] = weight;
            this.adjacency[mountPoint][node] = weight;
            this.nbEdges += 2;

            if (r.nextFloat() > probability) {
                connected.add(node);
                notConnected.remove(nodeIndex);
            }
        }
    }

    public void setEdges(int[]... edges) {
        for(int[] edge: edges) {
            if(edge[2] >= 100 || edge[2] < 0)
                throw new IndexOutOfBoundsException("Priority not in bounds");

            this.adjacency[edge[0]][edge[1]] = edge[2];
            this.adjacency[edge[1]][edge[0]] = edge[2];
            this.nbEdges += 2;
        }
    }

    public ArrayList<Integer> getNeighbours(int node) {
        ArrayList<Integer> ngbh = new ArrayList<>();
        for(int i = 0; i < this.size; ++i)
            if(this.adjacency[node][i] != 0)
                ngbh.add(i);
        
        return ngbh;
    }

    /* Implements a breadth first search algorithm, using a queue.
     * While we have something in queue, every child node is queued,
     * while a node is polled. This way, we ensure to always go to
     * "brothers" first, and then to childnodes */
    public void bfs() {
        this.visited = new ArrayList<>();
        ArrayBlockingQueue queue = new ArrayBlockingQueue(this.nbEdges);
        queue.add(Graph.ROOT);
        while(queue.size() > 0) {
            int node = (Integer)queue.poll();
            this.visited.add(node);
            this.getNeighbours(node).stream().filter((child) -> (!this.visited.contains(child))).forEachOrdered((child) -> {
                queue.add(child);
            });
        }
    }

    /* Implements a depth first search algorithm, using a stack.
     * While we have something in stack, every child node is pushed,
     * while a node is poped. This way, we ensure to always go to
     * childnodes first, and then to "brothers" */
    public void dfs() {
        this.visited = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(Graph.ROOT);
        while(stack.size() > 0) {
            int node = (Integer)stack.pop();
            this.visited.add(node);
            this.getNeighbours(node).stream().filter((child) -> (!this.visited.contains(child))).forEachOrdered((child) -> {
                stack.push(child);
            });
        }
    }

    /* Returns a list of every nodes linked to the given node
     * returned lists are [weight, linked node, given node]
     */
    public ArrayList<ArrayList<Integer>> getEdges(int node) {
        ArrayList<ArrayList<Integer>> ngbh = new ArrayList<>();
        for(int i = 0; i < this.size; ++i) {
            if(this.adjacency[node][i] != 0) {
                ArrayList tmp = new ArrayList<>();
                tmp.add(this.adjacency[node][i]);
                tmp.add(i);
                tmp.add(node);
                ngbh.add(tmp);
            }
        }
        
        return ngbh;
    }

    /* Get the lowest weighted neighbour for a given node */
    public ArrayList<Integer> getLowestEdge(int node) {
        ArrayList<Integer> lowest = new ArrayList<>();
        lowest.add(100);
        lowest.add(null);
        for(ArrayList<Integer> child: this.getEdges(node))
            if(child.get(0) < lowest.get(0)) {
                lowest.set(0, child.get(0));
                lowest.set(1, child.get(1));
            }
        
        return lowest;
    }

    /* We here sort the edges by priority and return a list of couples
     * (priority, node associated). A more efficient sort would probably
     * be much better on dense graphs, but we here process very small
     * (probably <10) amount of data, so selection sort fits well. */
    public void sortEdges(ArrayList<ArrayList<Integer>> toSort) {
        for(int i = 0; i < toSort.size(); ++i) {
            int min = i;
            for(int j = i+1; j < toSort.size(); ++j)
                if((toSort.get(j).get(0)) < (toSort.get(min).get(0)))
                    min = j;
            if(min != i) {
                ArrayList swap = toSort.get(i);
                toSort.set(i, toSort.get(min));
                toSort.set(min, swap);
            }
        }
    }

    /* Implements a minimum spanning tree algorithm. We are using a greedy
     * algorithm, the Prim's algorithm. For uniqueness reason with others
     * algorithms, we use a adjacency matrix (complexity O(n^2), n being the
     * number of vertices, but a binary heap or a Fibonacci heap used with
     * an adjacency list would drop the complexity to a logarithmic one. */
    public ArrayList mst() {
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        ArrayList<Integer> vertices = new ArrayList<>();

        /* We add the starting node */
        vertices.add(Graph.ROOT);

        /* While all the vertices aren't linked by the tree */
        while(vertices.size() < this.size) {
            int i;
            ArrayList<ArrayList<Integer>> availEdges = new ArrayList<>();
            vertices.forEach((Integer node) -> {
                availEdges.addAll(this.getEdges(node));
            });
            this.sortEdges(availEdges);

            for(i = 0; i < availEdges.size(); ++i) {
                if(!vertices.contains(availEdges.get(i).get(1)))
                    break;
            }
            if(i < availEdges.size()) {
                vertices.add(availEdges.get(i).get(1));
                edges.add(availEdges.get(i));
            }
        }

        return edges;
    }

    public ArrayList<Integer> djikstra() {
        this.visited = new ArrayList<>();
        ArrayList<Integer> dist = new ArrayList<>();

        /* Initialize the arrays */
        for(int i = 0; i < this.size; ++i)
            dist.add(Integer.MAX_VALUE);

        /* The distance from the source to itself is nil */
        dist.set(Graph.ROOT, 0);
        //visit all edges before exit
        while(this.visited.size() < this.size) {
            ArrayList<ArrayList<Integer>> availEdges;
            int toExplore = -1;
            int minDistance = Integer.MAX_VALUE;

            for(int i=0; i < dist.size(); ++i)
                if(dist.get(i) < minDistance && !visited.contains(i)) {
                    minDistance = dist.get(i);
                    toExplore = i;
                }

            availEdges = this.getEdges(toExplore);
            this.visited.add(toExplore);
            for(ArrayList<Integer> child : availEdges)
                if(dist.get(child.get(1)) > minDistance + child.get(0))
                    dist.set(child.get(1), minDistance + child.get(0));

        }
        
        return dist;
    }
}
