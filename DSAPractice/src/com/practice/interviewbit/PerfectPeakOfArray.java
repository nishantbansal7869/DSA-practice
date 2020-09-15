package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class PerfectPeakOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int ans = peakOfArray(list);
        System.out.println(ans);
    }

    private static int peakOfArray(ArrayList<Integer> list) {
        int n = list.size();
        int[] min = new int[n];
        min[n-1] = list.get(n-1);
        for (int i = n-2; i >= 0; i--){
            min[i] = Math.min(min[i+1], list.get(i));
        }

        int max = list.get(0);
        for (int i = 1; i < n-1; i++){
            max = Math.max(max, list.get(i));
            if (max == min[i])
                return 1;
        }
        return 0;
    }
}
