/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps;

import com.tps.tp1.TP1;
import com.tps.tp2.TP2;
import com.tps.tp3.TP3;
import com.tps.tp4.TP4;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bright
 */
public class TPs {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        int input;
        do {
            System.out.print("Quel TP (1-4) voulez vous exécuter ? (0 pour quitter) ");
            Scanner in = new Scanner(System.in);
            try {
                input = Integer.parseInt(in.next());
            }
            catch (NumberFormatException ex) {
                input = -1;
            }
            switch (input) {
                case 1:
                    System.out.println("============================= TP1 =============================");
                    TP1.run();
                    break;
                case 2:
                    System.out.println("============================= TP2 =============================");
                    TP2.run();
                    break;
                case 3:
                    System.out.println("============================= TP3 =============================");
                    TP3.run();
                    break;
                case 4:
                    System.out.println("============================= TP4 =============================");
                    TP4.run();
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Revoyez votre saisie");
                    break;
            }
        } while (input != 0);
    }
    
}
