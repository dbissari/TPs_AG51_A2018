/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp2;

import java.util.Random;

/**
 *
 * @author bright
 */
public class TP2 {
    
    public static void run () {
        
        int loops = 8;
        Random rand = new Random();
        
        System.out.format("%15s%15s%15s%15s%15s\n", "Taille", "Max tas", "Temps tas", "Max tableau", "Temps tableau");
        
        for (int i = 1; i <= loops; i++) {
            int size = (int) Math.pow(10, i);
            Heap heap = new Heap(size);
            int[] array = new int[size];
            
            for (int j = 0; j < size; j++){
                int tmp =  rand.nextInt(); 
                heap.add(tmp);
                array[j] = tmp;
            }
            
            long startTime, endTime;
            double[] durations = new double[2];
            int[] maximums = new int[2];
            
            startTime = System.nanoTime();
            maximums[0] = heap.maximum();
            endTime = System.nanoTime();
            durations[0] = (endTime - startTime) / 1000000000.0;
            
            startTime = System.nanoTime();
            maximums[1] = maximum(array, size);
            endTime = System.nanoTime();
            durations[1] = (endTime - startTime) / 1000000000.0;
            
            System.out.format("%15d%15d%15g%15d%15g\n", size, maximums[0], durations[0], maximums[1], durations[1]);
        }
        
    }
    
    private static int maximum(int[] array ,int size) {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            if(array[i] > max)
                max = array[i];
        }
        return max;
    }
    
}
