package com.practice.hackerRank;

import java.util.Scanner;

public class TimeOfTheYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int seconds = sc.nextInt();
            String day = findDay(seconds);
            System.out.println(day);
            test--;
        }
    }

    private static String findDay(int seconds) {
        int year = 1996;
        if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
            System.out.println("Specified year is a leap year");
        else System.out.println("Non leap");
        int day = 24*3600;
        int days = seconds/day;
        System.out.println(days/365);
        System.out.println(days%365);
        return "";
    }
}
