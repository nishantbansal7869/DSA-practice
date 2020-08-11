package com.practice.codeforces;

import java.util.Scanner;

public class Hulk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = hulkSays(n);
        System.out.print(result);
    }

    private static String hulkSays(int n) {
        String says = "";
        String[] arr = {"hate", "love"};
        for (int i = 0; i < n-1; i++){
            says = says + "I " + arr[i % 2] + " that ";
        }
        says = says + "I " + arr[(n-1)%2] + " it";
        return says;
    }
}
