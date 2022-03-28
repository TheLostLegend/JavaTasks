package com.epam.rd.autotasks.meetstrangers;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner scanner = new Scanner(System.in);
        int Pass = scanner.nextInt();
        if(Pass < 0) System.out.println("Seriously? Why so negative?");
        else if (Pass == 0 ) System.out.println("Oh, it looks like there is no one here");
        else {
            int i = 0;
            DataInputStream in = new DataInputStream(System.in);
            String x = null;
            while (i < Pass){
                try {
                    x = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello, " + x);
                i++;
            }
        }
    }
}
