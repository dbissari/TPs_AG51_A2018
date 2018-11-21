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
public class Element {
    
    private final int value;
    private Element next;

    Element(int value, Element next){
        this.value = value;
        this.next = next;
    }

    int getValue() {
        return value;
    }

    Element getNext() {
        return next;
    }

    void setNext(Element next) {
        this.next = next;
    }
    
}
