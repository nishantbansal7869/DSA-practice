package com.practice.hackerRank;

import java.util.ArrayList;

public class Combinaitions {
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        boolean[] taken = new boolean[n];
        ArrayList<Integer> arr  = new ArrayList<>();
        combinations(arr,1,n, k, taken);
    }

    private static void combinations(ArrayList<Integer> arr, int idx, int n, int k, boolean[] taken) {
        if (k == 0){
            System.out.print(arr);
            System.out.println();
            return;
        }

        for (int i = idx; i <= n; i++){
            if (taken[i -1] == false){
                taken[i-1] = true;
                arr.add(i);
                combinations(arr, i+1, n, k-1, taken);
                arr.remove(arr.size()-1);
                taken[i-1] = false;
            }
        }
    }
}
