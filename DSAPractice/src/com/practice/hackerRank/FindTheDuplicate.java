package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindTheDuplicate {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int duplicate = findDuplicate(arr,n);
        System.out.print(duplicate);
    }
    public static int findDuplicate(int[] arr, int n){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(set.contains(arr[i]))
                return arr[i];
            else {
                set.add(arr[i]);
            }
        }
        return -1;
    }
}
