package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class AllocateBooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int ans = allocateBooks(list, b);
        System.out.println(ans);
    }

    private static int allocateBooks(ArrayList<Integer> list, int b) {
        if (b > list.size())
            return -1;
        if (b == list.size()){
            return list.stream().max(Integer :: compare).get();
        }
        long ans = -1;
        long low = 0;
        long high = list.stream().mapToInt(i -> i).sum();
        while (low <= high){
            long mid = (low+high)/2;
            if (valid(list, b, mid)){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return (int)ans;
    }

    private static boolean valid(ArrayList<Integer> list, int b, long mid) {
        long curSum = 0;
        int i = 0;
        while (i < list.size()){
            if (list.get(i)>mid)
                return false;
            curSum += list.get(i);
            if (curSum > mid){
                b--;
                curSum = list.get(i);
                if (b == 0)
                    break;
            }
            i++;
        }
        if (b == 0 && i != list.size())
            return false;
        return true;
    }
}
