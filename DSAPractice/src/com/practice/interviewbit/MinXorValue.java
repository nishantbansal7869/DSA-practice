package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class MinXorValue {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(15);
        arr.add(5);
        arr.add(1);
        arr.add(10);
        arr.add(2);
        int val = findMin(arr);
        System.out.print(val);
    }

    private static int findMin(ArrayList<Integer> arr) {
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++){
            if ((arr.get(i-1)^arr.get(i)) < min)
                min = arr.get(i-1)^arr.get(i);
        }
        return min;
    }
}
