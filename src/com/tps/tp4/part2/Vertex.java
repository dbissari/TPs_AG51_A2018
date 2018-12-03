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
class Vertex {
    
    private final int id;

    Vertex(int id) {
            this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Vertex)
            return id == ((Vertex) o).id;
        else
            return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    int getId() {
        return id;
    }
}
