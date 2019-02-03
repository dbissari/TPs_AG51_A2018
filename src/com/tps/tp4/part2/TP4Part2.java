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
public class TP4Part2 {
    private static final int MAX=200;
    public static final int SAMPLES=20;
    
    public static void run () {
        System.out.format("%15s%15s%15s\n", "Taille", "Kruskal", "Prim");
        for(int i = 10; i <= MAX; i+=10) {
            Chrono chrono = new Chrono();
            long start;
            Graph graph = new Graph(i);
            MinimumSpanningTree mst = new MinimumSpanningTree();
            
            for(int j=0; j<SAMPLES; ++j) {
                
                // Kruskal
                start = System.nanoTime();
                mst.kruskals(graph);
                chrono.addKruskalTime(System.nanoTime() - start);
                
                // Prim
                start = System.nanoTime();
                mst.prims(graph);
                chrono.addPrimTime(System.nanoTime() - start);
                
            }
            
            System.out.format("%15d%15g%15g\n", i, 
                    chrono.getKruskalTime()/(SAMPLES*1000000000.0), 
                    chrono.getPrimTime()/(SAMPLES*1000000000.0));
        }
    }
}
