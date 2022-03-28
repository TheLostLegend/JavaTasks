package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < 0) System.out.println("Bill total amount cannot be negative");
        else if (b <=0) System.out.println("Number of friends cannot be negative or zero");
        else System.out.println((int) (a * 1.1 / b));
    }
}
