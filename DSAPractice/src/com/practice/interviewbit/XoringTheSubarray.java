package com.practice.interviewbit;

import java.util.ArrayList;

public class XoringTheSubarray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(5);
        //arr.add(5);
        int res = xor(arr);
        System.out.print(res);
    }

    private static int xor(ArrayList<Integer> arr) {
        int res = 0;
        for (int i = 0; i < arr.size(); i++){
            int occurance = (i + 1)* (arr.size() - i);
            if (occurance % 2 != 0)
                res = res ^ arr.get(i);
        }
        return res;
    }
}
