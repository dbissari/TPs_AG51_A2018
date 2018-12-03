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
class Chrono {
    private long insertTime = 0;
    private long searchTime = 0;
    private long deleteTime = 0;
    
    void addInsertTime(long time) {
        this.insertTime += time;
    }
    
    void addSearchTime(long time) {
        this.searchTime += time;
    }
    
    void addDeleteTime(long time) {
        this.deleteTime += time;
    }

    long getInsertTime() {
        return insertTime;
    }

    long getSearchTime() {
        return searchTime;
    }

    long getDeleteTime() {
        return deleteTime;
    }
}
