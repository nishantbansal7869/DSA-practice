package com.practice.hashing;

import java.util.HashSet;

public class UnionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {15,20,5,15};
        int[] arr2 = {15,15,15,20,10};
        int n = arr1.length;
        int m = arr2.length;
        int count = union(arr1,arr2,n,m);
        System.out.print(count);
    }

    private static int union(int[] arr1, int[] arr2, int n, int m) {
        HashSet<Integer> set = new HashSet<>(m+n);
        for(int i : arr1){
            set.add(i);
        }
        for (int i : arr2){
            set.add(i);
        }
        return set.size();
    }
}
