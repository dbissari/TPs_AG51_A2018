/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4.part1;

/**
 *
 * @author bright
 */
public class Chrono {
    private long bfsTime = 0;
    private long dfsTime = 0;
    private long mstTime = 0;
    private long djikstraTime = 0;
    
    public void addBfsTime(long time) {
        this.bfsTime += time;
    }

    public void addDfsTime(long time) {
        this.dfsTime += time;
    }

    public void addMstTime(long time) {
        this.mstTime += time;
    }

    public void addDjikstraTime(long time) {
        this.djikstraTime += time;
    }

    public long getBfsTime() {
        return bfsTime;
    }

    public long getDfsTime() {
        return dfsTime;
    }

    public long getMstTime() {
        return mstTime;
    }

    public long getDjikstraTime() {
        return djikstraTime;
    }
}
