/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part2;

/**
 *
 * @author dbissari
 */
public final class Edge implements Comparable<Edge> {
    private Vertex u, v;
    private int weight;

    /**
     * Comparable edge class based on weight. Order of u and v does not matter.
     * 
     * @param u
     * @param v
     * @param weight
     */
    Edge(Vertex u, Vertex v, int weight) {
        setU(u);
        setV(v);
        setWeight(weight);
    }

    @Override
    public int hashCode() {
        return (u == null ? 0 : u.hashCode()) ^ (v == null ? 0 : v.hashCode()) ^ weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Edge) {
            Edge e = (Edge) o;
            return weight == e.weight 
                    && ((u.equals(e.u) && v.equals(e.v)) || (u.equals(e.v) && v.equals(e.u)));
        } 
        else
            return false;
    }

    @Override
    public int compareTo(Edge e) {
        return weight - e.getWeight();
    }

    int getWeight() {
        return weight;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    Vertex getU() {
        return u;
    }

    void setU(Vertex u) {
        this.u = u;
    }

    Vertex getV() {
        return v;
    }

    void setV(Vertex v) {
        this.v = v;
    }
}
