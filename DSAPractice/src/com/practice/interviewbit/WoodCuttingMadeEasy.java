package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WoodCuttingMadeEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int ans = woodCut(list, b);
        System.out.println(ans);
    }

    private static int woodCut(ArrayList<Integer> list, int b) {
        long ans = 0;
        long low = 0;
        long high = Collections.max(list);
        while (low <= high){
            long mid = (low+high)/2;
            if (valid(list, b, mid)){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid - 1;
        }
        return (int)ans;
    }

    private static boolean valid(ArrayList<Integer> list, int b, long mid) {
        long sum = 0;
        for (int i : list){
            if (i - mid > 0)
                sum += i - mid;
        }
        return sum >= b;
    }
}
