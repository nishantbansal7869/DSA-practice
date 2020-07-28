package com.practice.OCAExam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;

public class DateTimeUse {
    //static int i = 1;
    public static void main(String[] args) {
        //DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        LocalDate date = LocalDate.of(2019,11,23);
        date = date.plus(Period.of(2,3,4));
        System.out.println(date.plusDays(389));
        LocalTime time = LocalTime.parse("12:12:12.000012");
        //String s = formatter.format(date);
        System.out.println(Period.parse("p43y2w5d"));
        System.out.print(date);
        int x = 1;
        final int j = x;
        x = 3;
        //System.out.print(j + " " + x);
        StringBuilder str = new StringBuilder(5);
       // StringBuilder s3 = new StringBuilder(str.substring(2));
        //str.subSequence(2,4);
        System.out.println("Str: "+str);
        int[] arr;
        int[] carr = new int[]{'a','b'};
        arr = carr;
        ArrayList<Long> lsit = new ArrayList<>();
        lsit.add(10L);
        double bill = 1000.09;
        int dis = (int) (bill > 1000 ? bill-900 : bill-100);
        System.out.println(1>2 ? "a" : "b");
        if(1 > 2){
            System.out.println("true");
        }
        {
            System.out.println("Block");
        }
        System.out.println("Out");
    }
    static int add(int a, int b){
        long sum = a+b;
        return  (int)sum;
    }
}
