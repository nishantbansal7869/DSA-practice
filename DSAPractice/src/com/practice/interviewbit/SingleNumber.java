package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        List<Integer>  arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(3);
        arr.add(3);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(1);
        arr.add(1);
        int num = repeating(arr);
        System.out.print(num);
    }

    private static int repeating(List<Integer> arr) {
        int a = 0;
        for (int i : arr){
            a = a^i;
        }
        return a;
    }
}
