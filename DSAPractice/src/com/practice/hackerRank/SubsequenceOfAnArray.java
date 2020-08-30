package com.practice.hackerRank;

import java.util.ArrayList;

public class SubsequenceOfAnArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        ArrayList<Integer> list = new ArrayList<>();
        printSubsequence(arr, arr.length, 0, list);
    }

    private static void printSubsequence(int[] arr, int length, int idx, ArrayList<Integer> list) {
        if (idx == length)
            return;

        list.add(arr[idx]);
        System.out.println(list);
        printSubsequence(arr, length, idx+1, list);
        list.remove(list.size()-1);
        printSubsequence(arr, length, idx+1, list);
    }
}
