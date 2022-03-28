package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int f = rows -1;
        int w = columns -1;

        int c = 0;
        int i = 0;
        int j = 0;
        int p = 0;


        int [][] mas = new int [rows][columns];

        while (c != rows * columns && c != rows * columns -1){

            while (j < w) {
                mas[i][j] = ++c;
                j++;
            }

            while (i < f) {
                mas[i][j] = ++c;
                i++;
            }

            while (j > p) {
                mas[i][j] = ++c;
                j--;
            }

            f--;
            w--;
            p++;
            while (i > p) {
                mas[i][j] = ++c;
                i--;
            }

        }
        if(c == rows * columns -1){
            mas[i][j] = ++c;
        }
        return mas;
    }
}
