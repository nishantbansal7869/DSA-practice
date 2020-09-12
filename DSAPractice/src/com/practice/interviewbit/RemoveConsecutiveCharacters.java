package com.practice.interviewbit;

import java.util.Scanner;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int b = sc.nextInt();
        String ans = removeChars(s, b);
        System.out.println(ans);
    }

    private static String removeChars(String s, int b) {
        StringBuilder sb = new StringBuilder(s);
        int count = 1;
        int i = 0;
        int j = 1;
        while (sb.length() > 1 & j < sb.length()){
            if (sb.charAt(i) == sb.charAt(j)){
                count++;
                j++;
            }
            else if (count == b){
                sb.delete(i, j);
                count = 1;
                if (i > 0){
                    j = i + 1;
                }
                else
                    j = 1;
            }
            else {
                i++;
                j++;
            }
        }
        if (count == b)
            sb.delete(i, j);
        return sb.toString();
    }
}
