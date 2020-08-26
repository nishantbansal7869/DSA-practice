package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchForARange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            list.add(i, sc.nextInt());
        }
        int b = sc.nextInt();
        ArrayList<Integer> res = range(list, b);
        System.out.println(res);
    }

    private static ArrayList<Integer> range(ArrayList<Integer> list, int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int leftMostIndex = leftIndex(list, n, 0, n-1);
        if (leftMostIndex == -1){
            res.add(-1);
            res.add(-1);
            return res;
        }
        int rightMostIndex = rightIndex(list, n, 0, n-1);
        res.add(leftMostIndex);
        res.add(rightMostIndex);
        return res;
    }

    private static int rightIndex(ArrayList<Integer> list, int n, int low, int high) {
        int idx = -1;
        while (low <= high){
            int mid = (high+low)/2;
            if (list.get(mid) < n){
                low = mid+1;
            }
            else if (list.get(mid) > n)
                high = mid - 1;
            else{
                idx = mid;
                low = mid+1;
            }
        }
        return idx;
    }

    private static int leftIndex(ArrayList<Integer> list, int n, int low, int high) {
        int idx = -1;
        while (low <= high){
            int mid = (low+high)/2;
            if (list.get(mid) > n)
                high = mid - 1;
            else if (list.get(mid) < n){
                low = mid +1;
            }
            else {
                idx = mid;
                high = mid - 1;
            }
        }
        return idx;
    }
}
