package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSubarrayWithDiff1 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(6);
        arr.add(5);
        arr.add(3);
        arr.add(3);
        arr.add(1);
        System.out.println(maxXubArray(arr));
    }

    public static int maxXubArray(List<Integer> arr){
        int res = 0;
        int count = 0;
        int sublength = Integer.MIN_VALUE;
        Collections.sort(arr);
        int i = 0;
        while(i < arr.size()){
            int el = arr.get(i);
            i++;
            while (i < arr.size() && (arr.get(i) == el || arr.get(i) == el+1)){
                count++;
                i++;
            }
            sublength = Math.max(sublength,count);
            count = 0;
        }
        return sublength+1;
    }

}
