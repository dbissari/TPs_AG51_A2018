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
public class Array {
    
    private final int[] array;
    private int lastElementIndex;
    
    Array(int size) {
        //Random gen = new Random();
        array = new int[size];
        lastElementIndex = -1;
    }
    
    int search(int elementToFind) {
        if (lastElementIndex >= 0)
            for (int i = 0; i < array.length; ++i)
                if(array[i] == elementToFind)
                    return i;
        return -1;
    }

    void add(int value) {
        lastElementIndex += 1;
        array[lastElementIndex] = value;
    }

    void remove(int value) {
        int i = 0 ;
        while (array[i] != value && i < lastElementIndex)
            i++;

        for (int j = i; j < lastElementIndex; j++)
            array[j] = array[j+1];
        lastElementIndex -= 1;
    }
    
}
