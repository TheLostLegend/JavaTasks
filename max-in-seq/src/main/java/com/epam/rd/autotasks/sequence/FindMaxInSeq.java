package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        // Put your code here
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int max = a;
        a = scanner.nextInt();
        while (a != 0){
            if (max < a) max = a;
            a = scanner.nextInt();
        }


        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
