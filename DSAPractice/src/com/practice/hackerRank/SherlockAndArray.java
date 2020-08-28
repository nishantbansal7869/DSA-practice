package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++)
                arr.add(i, sc.nextInt());
            String ans = balancedSums(arr);
            System.out.println(ans);
            test--;
        }
    }

    private static String balancedSums(List<Integer> arr) {
        int n = arr.size();
        if(arr.size() == 1)
            return "YES";
        int low = 0;
        int high = arr.size()-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(mid == 0 && sum(arr, mid+1, n-1) == 0)
                return "YES";
            if(mid == n-1 && sum(arr, 0, mid-1) == 0)
                return "YES";
            int leftSum = sum(arr, 0, mid-1);
            int rightSum = sum(arr, mid+1, n-1);
            System.out.println(leftSum + " " + rightSum);
            if(leftSum == rightSum)
                return "YES";
            if(leftSum > rightSum)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return "NO";
    }

    private static int sum(List<Integer> arr, int start, int end){
        int sum = 0;
        for(int i = start; i <= end; i++)
            sum += arr.get(i);
        return sum;
    }
}
