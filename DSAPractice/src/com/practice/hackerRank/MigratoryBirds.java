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
        int arr1[] = new int[6];
        for(int i = 0; i < arr.size(); i++){
            arr1[arr.get(i)]  = (arr1[arr.get(i)]+1)%10000007;
        }
        int maxCount = arr1[0];
        int index = 0;
        for(int i = 0; i < 6; i++){
            if(arr1[i] > maxCount){
                maxCount = arr1[i];
                index = i;
            }
        }
        return index;
    }
}
