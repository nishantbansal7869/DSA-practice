package com.practice.hackerRank;

import java.util.Scanner;

public class LetterRepeatition {
    public static void main(String[] args) {
        //Scanner sc= new Scanner(System.in);
        //int n = sc.nextInt();
        //String s = modifiedString(n);
        long x = 1;
        long l = (1l<<63);
        System.out.println(l);
    }

    private static String modifiedString(int n) {
        String s = "G";
        for (int i = 0; i < n; i++){
            s = s + 'o';
        }
        s = s + 'd';
        return s;
    }
}
