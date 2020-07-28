package com.practice.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class PositiveNegativePair {
    public static void main(String[] args) {
        int[] arr = {1,3,6,-2,-1,-3,2,7};
        int n = arr.length;
        ArrayList<Integer> list = positiveNegativePair(arr, n);
    }

    private static ArrayList<Integer> positiveNegativePair(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(Math.abs(arr[i]))){

            }
        }
        return list;
    }
}
