package com.epam.rd.autotasks.meetastranger;

import java.io.DataInputStream;
import java.io.IOException;

public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        DataInputStream in = new DataInputStream(System.in);
        String x = null;
        try {
            x = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello, "+ x);
    }
}
