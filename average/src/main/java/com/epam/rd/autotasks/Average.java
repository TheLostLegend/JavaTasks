package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        int i = 0;
        int sum = 0;
        int a = scanner.nextInt();
        while (a != 0){
            sum += a;
            a = scanner.nextInt();
            i++;
        }
        System.out.println((sum/i));

    }

}