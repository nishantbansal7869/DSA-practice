package com.practice.hackerRank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FindingFrequenciessecond {
    static HashMap<Integer, Integer> count = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        countFrequency(arr, n);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            if (count.containsKey(query))
                System.out.println(count.get(query));
            else
                System.out.println(0);
        }
    }

    private static void countFrequency(int[] arr, int n) {
        for (int i = 0; i < n; i++){
            if (count.containsKey(arr[i])){
                int current = count.get(arr[i]);
                count.put(arr[i],current+1);
            }
            else
                count.put(arr[i], 1);
        }
    }
}
