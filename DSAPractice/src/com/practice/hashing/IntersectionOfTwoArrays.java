package com.practice.hashing;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {10,15,20,15,30,30,5};
        int[] arr2 = {30,5,30,80};
        int m = arr1.length;
        int n = arr2.length;
        int count = instersection(arr1,arr2,m,n);
        System.out.print(count);
    }

    private static int instersection(int[] arr1, int[] arr2, int m, int n) {
        HashSet<Integer>  set = new HashSet<>(m);
        for(int i : arr1){
            set.add(i);
        }
        //System.out.println(set);
        int res = 0;
        for(int j : arr2){
            if(set.contains((Integer)j)){
                res++;
                set.remove((Integer)j);
            }
        }
        return res;
    }
}
