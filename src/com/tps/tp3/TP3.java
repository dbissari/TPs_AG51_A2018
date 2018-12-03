/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp3;

import java.util.Random;

/**
 *
 * @author dbissari
 */
public class TP3 {
    
    private static final int MAX = 10000000;
    private static final int SAMPLES = 1000;
    
    public static void run () {
    
        Chrono arrayChrono = new Chrono();
        Chrono hashTableChrono = new Chrono();
        Random r = new Random();
        
        System.out.format("%15s%15s%15s%15s%15s\n", "Type", "Taille", "Insertion", "Recherche", "Suppression");
        
        for(int i = 10; i <= MAX; i*=10) {
            long startTime;
            
            Array array = new Array(i);
            ElementsTable hashTable = new ElementsTable(i);
            
            for(int j = 0; j < SAMPLES; j++) {
                
                // Array
                
                startTime = System.nanoTime();
                array.add((Math.abs(r.nextInt()))%i);
                arrayChrono.addInsertTime(System.nanoTime() - startTime);
                
                startTime = System.nanoTime();
                array.search((Math.abs(r.nextInt()))%i);
                arrayChrono.addSearchTime(System.nanoTime() - startTime);

                startTime = System.nanoTime();
                array.remove((Math.abs(r.nextInt()))%i);
                arrayChrono.addDeleteTime(System.nanoTime() - startTime);
                
                // HashTable
                
                startTime = System.nanoTime();
                hashTable.insert((Math.abs(r.nextInt()))%i);
                hashTableChrono.addInsertTime(System.nanoTime() - startTime);
                
                startTime = System.nanoTime();
                hashTable.search((Math.abs(r.nextInt()))%i);
                hashTableChrono.addSearchTime(System.nanoTime() - startTime);

                startTime = System.nanoTime();
                hashTable.remove((Math.abs(r.nextInt()))%i);
                hashTableChrono.addDeleteTime(System.nanoTime() - startTime);
                
            }
            
            System.out.format("%15s%15d%15g%15g%15g\n", "Tableau", i, 
                    arrayChrono.getInsertTime()/(SAMPLES*1000000000.0), 
                    arrayChrono.getSearchTime()/(SAMPLES*1000000000.0), 
                    arrayChrono.getDeleteTime()/(SAMPLES*1000000000.0));
            
            System.out.format("%15s%15d%15g%15g%15g\n", "Hachage", i, 
                    hashTableChrono.getInsertTime()/(SAMPLES*1000000000.0), 
                    hashTableChrono.getSearchTime()/(SAMPLES*1000000000.0), 
                    hashTableChrono.getDeleteTime()/(SAMPLES*1000000000.0));
        }
        
    }
    
}
