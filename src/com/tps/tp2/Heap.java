/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp2;

/**
 *
 * @author bright
 */
public class Heap {
    
    int[] array;
    int elementsNumber;
    
    Heap(int size) {
        elementsNumber = 0;
        array = new int[size];
    }
    
    void add(int element) {
        int index = elementsNumber;
        elementsNumber += 1;
        while (index > 0 && array[(index-1)/2] <= element) {
            array[index] = array[(index-1)/2];
            index = (index-1)/2;
        }
        array[index] = element;
    }
    
    void remove() {
        int element = array[0] = array[--elementsNumber];
        int i = 0;
        while (2*i+1 < elementsNumber) {
            int j = 2 * i + 1;
            if (j + 1 < elementsNumber && array[j+1] > array[j])
                j++;
            if (element >= array[j])
                break;
            array[i] = array[j];
            i = j;
        }
        array[i] = element;
    }
    
    int maximum() {
        return array[0];
    }
}
