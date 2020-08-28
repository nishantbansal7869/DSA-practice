package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class IceCreamParlor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int[] ans = icecreamParlor(m, arr);
            Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
            System.out.println();
            test--;
        }
    }
    static int[] icecreamParlor(int m, int[] arr) {
        int[] arr1 = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            arr1[i] = arr[i];
        }
        Arrays.sort(arr);
        int[] ans = new int[2];
        for(int i = 0; i < arr.length; i++){
            int b = m - arr[i];
            int idx = BSI(arr, i+1, b);
            if(idx != -1){
                int idx1 = 0;
                for(int j = 0; j < arr1.length; j++){
                    if(arr[i] == arr1[j]){
                        idx1 = j;
                    break;}
                }
                for(int j = 0; j < arr1.length; j++){
                    if(b == arr1[j])
                        idx = j;
                }
                if (idx1 < idx)
                {
                    ans[0] = idx1 + 1;
                    ans[1] = idx + 1;
                }
                else {
                    ans[0] = idx+1;
                    ans[1] = idx1+1;
                }
                return ans;
            }
        }
        return ans;
    }

    static int BSI(int[] arr, int low, int k){
        int high = arr.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] == k)
                return mid;
            else if (arr[mid] > k)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
