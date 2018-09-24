/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author bright
 */
public class TP1 {

    public static void run () throws IOException {
        
        int[] sizes = new int[10];
        sizes[0] = 1000;
        sizes[1] = 5000;
        sizes[2] = 10000;
        sizes[3] = 15000;
        sizes[4] = 25000;
        sizes[5] = 40000;
        sizes[6] = 55000;
        sizes[7] = 70000;
        sizes[8] = 85000;
        sizes[9] = 100000;
        
        System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s\n", "Taille", "Insertion", "Selection", "Bulles", "Rapide", "Shell", "Fusion", "Tas");
        
        for (int size : sizes) {
            generateData(size);
            int[] data;
            long startTime, endTime;
            double[] durations = new double[7];
            
            
            data = getData(size);
            startTime = System.nanoTime();
            insertionSort(data, size);
            endTime = System.nanoTime();
            durations[0] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            selectionSort(data, size);
            endTime = System.nanoTime();
            durations[1] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            bubbleSort(data, size);
            endTime = System.nanoTime();
            durations[2] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            quickSort(data, 0, size-1);
            endTime = System.nanoTime();
            durations[3] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            shellSort(data, size);
            endTime = System.nanoTime();
            durations[4] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            mergeSort(data, 0, size-1);
            endTime = System.nanoTime();
            durations[5] = (endTime - startTime) / 1000000000.0;
            
            data = getData(size);
            startTime = System.nanoTime();
            heapSort(data, size);
            endTime = System.nanoTime();
            durations[6] = (endTime - startTime) / 1000000000.0;
            
            System.out.format("%15d%15g%15g%15g%15g%15g%15g%15g\n", size, durations[0], durations[1], durations[2], durations[3], durations[4], durations[5], durations[6]);
        }
        
        removeDataFile();
        
    }
    
    
    
    private static void generateData (int size) throws IOException {
        try (FileWriter fw = new FileWriter("tp1.txt", false)) {
            Random rand = new Random();
            
            for (int i = 0; i < size; i++) {
                fw.write(Integer.toString(rand.nextInt()));
                if (i < size-1) fw.write(System.lineSeparator());
            }
        }
    }
    
    private static int[] getData (int size) throws IOException {
        int[] data;
        try (BufferedReader br = new BufferedReader(new FileReader("tp1.txt"))) {
            data = new int[size];
            int i = 0;
            String line;
            while ((line = br.readLine()) != null && i < size) {
                data[i] = Integer.parseInt(line);
                i++;
            }
        }
        
        return data;
    }
    
    private static void removeDataFile () {
        File file = new File("tp1.txt");
        file.delete();
    }
    
    
    
    private static void insertionSort (int[] tab, int size) {
        int cpt, element;
        for (int i = 1; i < size; i++) {    
            element = tab[i];
            cpt = i - 1;
            while (cpt >= 0 && tab[cpt] > element) {
               tab[cpt + 1] = tab[cpt];
               cpt--;
            }
            tab[cpt + 1] = element;
        }
    }
    
    
    
    private static void selectionSort (int[] tab, int size) {
        int min, j, x;
        for(int i = 0; i < size - 1; i++) {
            min = i;
            for(j = i+1; j < size; j++)
                if(tab[j] < tab[min])
                    min = j;
            if(min != i) {
                x = tab[i];
                tab[i] = tab[min];
                tab[min] = x;
            }
        }
    }
    
    
    
    private static void bubbleSort (int[] tab, int size) {
        boolean permut;
        do {
            permut = false;
            for (int i = 0; i < size-1; i++) {
                if (tab[i] > tab[i+1]) {
                    int tmp = tab[i];
                    tab[i] = tab[i+1];
                    tab[i+1] = tmp;
                    permut=true;
                }
            }
        } while(permut);
    }
    
    
    
    public static void quickSort (int[] tab, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(tab, startIndex, endIndex);
            quickSort(tab, startIndex, pivotIndex-1);
            quickSort(tab, pivotIndex+1, endIndex);
        }
    }

    public static int partition (int[] t, int startIndex, int endIndex) {
        int valeurPivot = t[startIndex];
        int d = startIndex + 1;
        int f = endIndex;
        while (d < f) {
            while(d < f && t[f] >= valeurPivot) f--;
            while(d < f && t[d] <= valeurPivot) d++;
            int temp = t[d];
            t[d] = t[f];
            t[f] = temp;
        }
        if (t[d] > valeurPivot) d--;
        t[startIndex] = t[d];
        t[d] = valeurPivot;
        return d;
    }
    
    
    
    public static void shellSort (int[] tab,int size) {
        int step = 1;
        while(step < size/9) {
           step = step * 3 + 1;
        }
        while (step > 0) {
            for(int it = 0; it <= step-1; it ++) {
                int positionEltToInsert = it + step;

                while(positionEltToInsert < size) {
                    int elementToInsert = tab[positionEltToInsert];
                    int posElemCompared = positionEltToInsert - step;

                    while ((posElemCompared >= 0) && (elementToInsert < tab[posElemCompared])) {
                        tab[posElemCompared+step] = tab[posElemCompared];
                        posElemCompared -= step;
                    }
                    tab [posElemCompared + step] = elementToInsert;
                    positionEltToInsert += step;
                }
            }        
            step = step/3;
        }
    }
    
    
    
    public static void mergeSort (int[] tab, int start, int end) {
        int middle;
        if(start < end) {
            middle = (start+end) / 2;
            mergeSort(tab, start, middle);
            mergeSort(tab, middle + 1, end);
            merge(tab, start, middle, end);
        }
    }

    public static void merge (int tab[], int start, int middle, int end)
    {
        int [] old_tab = (int[]) tab.clone(); 
        // tab.clone est tres gourmand en temps d'execution surtout dans un algo recursif
        // il faudrait passer par un tableau temporaire pour stocker les données triées.
        // puis recopier la partie triée a la fin de la méthode.

        int i1 = start;
        int i2 = middle + 1;
        int i = start;

        while (i1 <= middle && i2 <= end) {
            if(old_tab[i1] <= old_tab[i2]) {
                tab[i] = old_tab[i1];
                i1++;
            }
            else {
                tab[i] = old_tab[i2];
                i2++;
            }
            i++;
        }
        if (i <= end) {
            while(i1 <= middle) {
                tab[i] = old_tab[i1];
                i1++;
                i++;
            }
            while(i2 <= end) {
                tab[i] = old_tab[i2];
                i2++;
                i++;
            }
        }
    }
    
    
    
    private static void heapSort (int[] tree, int size) {
        for (int i = size; i >= 0; i--)
            sift(tree, i, size - 1);

        for (int i = size-1; i >= 1; i--) {
            swap(tree[i], tree[0]);
            sift(tree, 0, i - 1);
        }
    }
    
    private static void sift (int[] tree, int node, int n) {
        int k = node;
        int j = 2 * k;
        while (j <= n) {
            if ((j < n) && (tree[j] < tree[j + 1]))
                j++;
            if (tree[k] < tree[j]) {
                swap(tree[k],tree[j]);
                k = j;
                j = 2 * k;
            }
            else
                break;
        }
    }
    
    private static void swap (int a,  int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    
}
