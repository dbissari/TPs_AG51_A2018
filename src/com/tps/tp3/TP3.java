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
    
    public static final int MAX = 10000000;
    public static final int SAMPLES = 1000;
    
    public static void run () {
    
        Chrono arrayChrono = new Chrono();
        Chrono hashTableChrono = new Chrono();
        Random r = new Random();
        
        System.out.println("Temps moyens d'insertion, de recherche et de suppression en nanosecondes");
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
            
            System.out.format("%15s%15d%15d%15d%15d\n", "Tableau", i, 
                    arrayChrono.getInsertTime()/SAMPLES, 
                    arrayChrono.getSearchTime()/SAMPLES, 
                    arrayChrono.getDeleteTime()/SAMPLES);
            
            System.out.format("%15s%15d%15d%15d%15d\n", "Hachage", i, 
                    hashTableChrono.getInsertTime()/SAMPLES, 
                    hashTableChrono.getSearchTime()/SAMPLES, 
                    hashTableChrono.getDeleteTime()/SAMPLES);
        }
        
    }
    
}
