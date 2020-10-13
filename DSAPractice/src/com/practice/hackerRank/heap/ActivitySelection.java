package com.practice.hackerRank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] start = new int[n];
            int[] end = new int[n];
            String[] arr = br.readLine().split(" ");
            String[] arr1 = br.readLine().split(" ");
            for (int i = 0; i < n; i++){
                start[i] = Integer.parseInt(arr[i]);
                end[i] = Integer.parseInt(arr[i]);
            }
            int ans = maxNonOverlapping(start, end);
            System.out.println(ans);
            test--;
        }
    }

    private static int maxNonOverlapping(int[] start, int[] end) {
        int i = 1;
        int j = 0;
        int cur = 1;
        int res = 1;
        Arrays.sort(start);
        Arrays.sort(end);
        while (i < start.length && j < end.length){
            if (start[i] <= end[j]){
                cur++;
                i++;
            }
            else
            {
                cur--;
                j++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
