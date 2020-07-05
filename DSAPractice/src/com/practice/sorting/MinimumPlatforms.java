package com.practice.sorting;

import java.util.Arrays;

public class MinimumPlatforms {
    public static void main(String[] args) {
        int[] arr = new int[]{900,940,950,1100,1500,1800};
        int[] dep = new int[]{910,1200,1120,1130,1900,2000};
        int platforms = minimumPlatforms(arr,dep,arr.length);
        System.out.print(platforms);
    }
    static int minimumPlatforms(int[] arr, int[] dep, int n){
        int curr = 1;
        int res = 0;
        int i = 1;
        int j = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while (i < n && j < n){
            if(arr[i] <= dep[j]){
                curr++;
                i++;
            }
            else {
                curr--;
                j++;
            }
            res = Math.max(res,curr);
        }
        return res;
    }
}
