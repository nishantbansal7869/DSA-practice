package com.practice.interviewbit;

import java.util.Scanner;

public class ReverseTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }

    private static String reverseString(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        String[] reversed = reverseArray(arr);
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < reversed.length; i++)
            sb.append(reversed[i] + " ");
        return sb.toString().trim();
    }

    private static String[] reverseArray(String[] arr) {
        int p1 = 0;
        int p2 = arr.length-1;
        while (p1 < p2){
            String temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
        return arr;
    }

}
