package com.practice.codeforces;

import java.util.Scanner;

public class Magnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.next();
        }
        int groups = findGroups(arr, n);
        System.out.print(groups);
    }

    private static int findGroups(String[] arr, int n) {
        int groups = 1;
        for (int i = 1; i < n; i++){
            if (!(arr[i].equals(arr[i-1])))
                groups++;
        }
        return groups;
    }
}
