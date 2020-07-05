package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestSort {
    public static void main(String[] args) {
       // int arr[] = new int[]{-20 ,-3916237, -357920, -3620601, 7374819, -7330761 ,30 ,6246457, -6461594, 266854, -520, -470  };
        int[] arr = new int[]{1,2,3,4,5};
        ArrayList<Integer> list = closestSort(arr,arr.length);
        //System.out.print(list);
    }

    private static ArrayList<Integer> closestSort(int[] arr, int length) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < length-1; i++){
            minDiff = Math.min(minDiff, arr[i+1] - arr[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < length-1; i++){
            if(arr[i+1] - arr[i] == minDiff){
                list.add(arr[i]);
                list.add(arr[i+1]);
            }
        }
        return list;
    }
}
