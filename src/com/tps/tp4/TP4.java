/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tps.tp4;

import com.tps.tp4.part1.TP4Part1;
import java.util.Scanner;

/**
 *
 * @author bright
 */
public class TP4 {
    public static void run () {
        int input;
        do {
            System.out.print("Quelle partie (1/2) du TP4 voulez vous exécuter ? (0 pour quitter) ");
            Scanner in = new Scanner(System.in);
            try {
                input = Integer.parseInt(in.next());
            }
            catch (NumberFormatException ex) {
                input = -1;
            }
            switch (input) {
                case 1:
                    System.out.println("========================= TP4 - Part1 =========================");
                    TP4Part1.run();
                    break;
                case 2:
                    System.out.println("========================= TP4 - Part2 =========================");
                    
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Revoyez votre saisie");
                    break;
            }
        } while (input != 0);
    }
}
