/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp3;

/**
 *
 * @author bright
 */
public class Chrono {
    private long insertTime = 0;
    private long searchTime = 0;
    private long deleteTime = 0;
    
    public void addInsertTime(long time) {
        this.insertTime += time;
    }
    
    public void addSearchTime(long time) {
        this.searchTime += time;
    }
    
    public void addDeleteTime(long time) {
        this.deleteTime += time;
    }

    public long getInsertTime() {
        return insertTime;
    }

    public long getSearchTime() {
        return searchTime;
    }

    public long getDeleteTime() {
        return deleteTime;
    }
}
