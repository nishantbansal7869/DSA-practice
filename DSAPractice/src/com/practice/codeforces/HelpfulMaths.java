package com.practice.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String updatedStr = changeStr(s);
        System.out.println(updatedStr);
    }

    private static String changeStr(String s) {
        String str = s.replace('+', ' ');
        String[] arr = str.split(" ");
        Arrays.sort(arr);
        String result = "";
        for(int i = 0; i < arr.length; i++){
            result = result + "+" + arr[i];
        }
        return result.substring(1);
    }
}
