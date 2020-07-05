package com.practice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int arr[] = new int[]{30,40,10,80,5,12,70};
        int k = 4;
        bucketSort(arr,k);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void bucketSort(int[] arr, int k)
    {
        int n = arr.length;
        int max = arr[0];
        for(int i = 0; i < n; i++){
            max = Math.max(arr[i],max);
        }
        max++;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        for(int i = 0; i < k; i++){
            bucket.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            int bi = (arr[i]*k)/max;
            bucket.get(bi).add(arr[i]);
        }
        for(int i = 0; i < k; i++){
            Collections.sort(bucket.get(i));
        }
        int index = 0;
        for(int i = 0; i < k; i++){
            for(int j = 0; j < bucket.get(i).size(); j++){
                arr[index++] = bucket.get(i).get(j);
            }
        }
    }
}
