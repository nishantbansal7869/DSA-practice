package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SubsetOfAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> subset = new ArrayList<>();
            Arrays.sort(arr);
            printSubset(arr, n, subset, 0);
            System.out.println();
            test--;
        }
    }

    private static void printSubset(int[] arr, int n, ArrayList<Integer> subset, int idx) {
        if (idx == n)
            return;
        subset.add(arr[idx]);
        subset.stream().forEach(i -> System.out.print(i + " "));
        System.out.println();
        printSubset(arr, n, subset, idx+1);
        subset.remove(subset.size()-1);
        printSubset(arr, n, subset, idx+1);
    }
}
