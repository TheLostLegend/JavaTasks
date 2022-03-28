package com.epam.rd.autotasks.meetautocode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        seconds %= 86400;
        int hour = seconds/3600;
        int min = seconds/60 - hour*60;
        int sec = seconds%60;
        SimpleDateFormat sdfDate = new SimpleDateFormat("mm:ss");
        Date now = new Date(2020, Calendar.APRIL, 3, hour, min, sec);
        String strDate = sdfDate.format(now);
        System.out.println(hour + ":" +strDate);


    }
}
