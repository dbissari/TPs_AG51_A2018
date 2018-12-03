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
class ElementsTable {
    
    private final Element table[];

    ElementsTable(int size) {
        table = new Element[size];
    }
    
    void insert(int value) {
	int key = hash(value);
        if (table[key] == null)
            table[key] = new Element(value, null) ; 
        else
            table[key] = new Element(value, table[key]);
    }
    
    private int hash (int value) {
        int key = value % 17 ;
        while (key > table.length) {
            key = key%17;
        }
        return key;
    }
    
    int search(int value) {
        int key = hash(value);
        Element e = table[key];
        while (e != null && e.getValue() != value)
            e = e.getNext();
        if (e != null)
            return key;
        return -1;
    }
    
    void remove(int value)  {
        int key = hash(value);
        if (table[key] != null) {
            Element e = table[key];
            if (e.getValue() == value)
                table[key] = e.getNext();
            else {
                while(e != null && e.getNext() != null) {
                    if (e.getNext().getValue() == value) {
                        e.setNext(e.getNext().getNext());
                        break;
                    }
                    e = e.getNext();
                }
            }
        }
            
            
            table[key]=null;
    }
    
}
