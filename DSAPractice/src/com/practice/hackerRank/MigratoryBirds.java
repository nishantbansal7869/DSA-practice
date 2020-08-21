package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class MigratoryBirds {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(5);
        arr.add(5);
        System.out.println(migratoryBirds(arr,arr.size()));
    }
    public static int migratoryBirds(List<Integer> arr, int n){
        int temp[] = new int[6];
        for (int i : arr){
            temp[i]++;
        }
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 1; i <= 5; i++){
            if (max < temp[i])
            {
                max = temp[i];
                idx = i;
            }
        }
        return idx;
    }
}
