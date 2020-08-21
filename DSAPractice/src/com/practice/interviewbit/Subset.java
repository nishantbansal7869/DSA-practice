package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class Subset {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        subset(arr);
    }

    private static void subset(ArrayList<Integer> arr) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();
        subsets.add(new ArrayList<>(subset));
        printSubset(arr, subset, subsets, 0, arr.size());
        System.out.println(subsets);
    }

    private static void printSubset(ArrayList<Integer> arr, ArrayList<Integer> subset,
                                    ArrayList<ArrayList<Integer>> subsets, int idx, int size) {
        if (idx == size)
            return;

        subset.add(arr.get(idx));
        subsets.add(new ArrayList<>(subset));
        printSubset(arr, subset, subsets, idx+1, size);
        subset.remove(subset.size()-1);
        printSubset(arr, subset, subsets, idx+1, size);
    }
}
