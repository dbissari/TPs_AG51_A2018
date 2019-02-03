/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part2;

/**
 *
 * @author bright
 */
public class Chrono {
    private long primTime = 0;
    private long kruskalTime = 0;
    
    void addPrimTime(long time) {
        this.primTime += time;
    }

    void addKruskalTime(long time) {
        this.kruskalTime += time;
    }

    long getPrimTime() {
        return primTime;
    }

    long getKruskalTime() {
        return kruskalTime;
    }
}
