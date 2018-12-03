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
public class TP4Part1 {
    
    private static final int MAX=1000;
    private static final int SAMPLES=20;
    private static final double NB_EDGES=0.5;
    
    public static void run () {
        //System.out.format("%15s%15s%15s%15s%15s\n", "Taille", "BFS", "DFS", "MST", "Djikstra");
        System.out.format("%15s%15s%15s\n", "Taille", "BFS", "DFS");
        for(int i = 100; i <= MAX; i+=100) {
            Chrono chrono = new Chrono();
            long start;
            Graph graph = new Graph(i, 1/(NB_EDGES*i));

            for(int j = 0; j < SAMPLES; ++j) {
                
                // BFS
                start = System.nanoTime();
                graph.bfs();
                chrono.addBfsTime(System.nanoTime() - start);

                // DFS
                start = System.nanoTime();
                graph.dfs();
                chrono.addDfsTime(System.nanoTime() - start);
                
                /*
                // MST
                start = System.nanoTime();
                graph.mst();
                chrono.addMstTime(System.nanoTime() - start);

                // Djikstra
                start = System.nanoTime();
                graph.djikstra();
                chrono.addDjikstraTime(System.nanoTime() - start);
                */
            }

            System.out.format("%15d%15g%15g\n", i, 
                    chrono.getBfsTime()/(SAMPLES*1000000000.0), 
                    chrono.getDfsTime()/(SAMPLES*1000000000.0));
            /*
            System.out.format("%15d%15g%15g%15g%15g\n", i, 
                    chrono.getBfsTime()/(SAMPLES*1000000000.0), 
                    chrono.getDfsTime()/(SAMPLES*1000000000.0), 
                    chrono.getMstTime()/(SAMPLES*1000000000.0), 
                    chrono.getDjikstraTime()/(SAMPLES*1000000000.0));
            */
        }
    }
}
