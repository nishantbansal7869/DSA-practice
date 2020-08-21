package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class FindingFrequencies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int query = sc.nextInt();
            int count = countFrequency(arr, n, query);
            System.out.println(count);
        }
    }

    private static int countFrequency(int[] arr, int n, int query) {
        Arrays.sort(arr);
        int leftIndex = findLeftIndex(arr, n, 0, n-1, query);
        if (leftIndex ==-1)
            return 0;
        int rightIndex = findRightIndex(arr, n, 0 , n-1, query);
        int count = (rightIndex - leftIndex)+1;
        return count;
    }

    private static int findRightIndex(int[] arr, int n, int low, int high, int query) {
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] < query)
                low = mid + 1;
            else if (arr[mid] == query){
                index = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return index;
    }

    private static int findLeftIndex(int[] arr, int n, int low, int high, int query) {
        int index = -1;
        while (low <= high){
            int mid = (low + high)/2;
            if (arr[mid] < query){
                low = mid + 1;
            }
            else if (arr[mid] == query){
                index = mid;
                high = mid - 1;
            }
            else
                high = mid - 1;
        }
        return index;
    }
}
