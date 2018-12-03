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
    //private long mstTime = 0;
    //private long djikstraTime = 0;
    
    void addBfsTime(long time) {
        this.bfsTime += time;
    }

    void addDfsTime(long time) {
        this.dfsTime += time;
    }

    /*
    void addMstTime(long time) {
        this.mstTime += time;
    }

    void addDjikstraTime(long time) {
        this.djikstraTime += time;
    }
    */

    long getBfsTime() {
        return bfsTime;
    }

    long getDfsTime() {
        return dfsTime;
    }

    /*
    long getMstTime() {
        return mstTime;
    }

    long getDjikstraTime() {
        return djikstraTime;
    }
    */
}
