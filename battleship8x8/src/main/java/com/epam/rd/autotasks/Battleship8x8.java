package com.epam.rd.autotasks;

import java.math.BigInteger;
import java.util.Arrays;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
        this.shots = ships;
    }

    private static long parseLong(String s, int base) {
        return new BigInteger(s, base).longValue();
    }

    public boolean shoot(String shot) {
        StringBuilder field = new StringBuilder(Long.toBinaryString(shots));
        String field2 = Long.toBinaryString(ships);
        if(field.length()<64) while(field.length() < 64) field.insert(0, "0");
        char[] letters = field.toString().toCharArray();
        char[] shot1 = shot.toCharArray();
        int b = 0;
        int a = shot1[1]-49;
        switch (shot1[0]){
            case ('A'): {b = 0; break;}
            case ('B'): {b = 1; break;}
            case ('C'): {b = 2; break;}
            case ('D'): {b = 3; break;}
            case ('E'): {b = 4; break;}
            case ('F'): {b = 5; break;}
            case ('G'): {b = 6; break;}
            case ('H'): {b = 7; break;}
        }

        if (letters[a*8+b] == '1') {
            letters[a*8+b] = '0';
            StringBuilder builder = new StringBuilder();
            for(char s : letters) {
                builder.append(s);
            }
            field = new StringBuilder(builder.toString());
            shots = parseLong(field.toString(), 2);
            return true;}
        else {
            letters[a*8+b] = '1';
            StringBuilder builder = new StringBuilder();
            for(char s : letters) {
                builder.append(s);
            }
            field = new StringBuilder(builder.toString());
            shots = parseLong(field.toString(), 2);
            return false;}

    }

    public String state() {
        StringBuilder field1 = new StringBuilder(Long.toBinaryString(shots));
        if(field1.length()<64) while(field1.length() < 64) field1.insert(0, "0");
        char[] field3 = field1.toString().toCharArray();
        StringBuilder field2 = new StringBuilder(Long.toBinaryString(ships));
        if(field2.length()<64) while(field2.length() < 64) field2.insert(0, "0");
        char[] field4 = field2.toString().toCharArray();
        char[] result = new char[field1.length() + 7];
        int i = 0;
        for(int j=0; j<result.length; j++){
            if (j%9 == 8) {result[j] = '\n'; continue;}
            if (field3[i] == field4[i]){
                if (field3[i] == '1') result[j] = '☐';
                else result[j] = '.';
            }
            else if (field3[i] == '1') result[j] = '×';
            else result[j] = '☒';
            i++;
        }
        StringBuilder builder = new StringBuilder();
        for(char s : result) {
            builder.append(s);
        }
        return builder.toString();
    }
}
