package com.practice.OCAExam;

import java.util.ArrayList;
import java.util.Collections;

public class LongTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        int a = 1;
        int b = 2;
        ArrayList<Integer> res = threeWayPartition(arr, a, b);
        System.out.print(res);
    }

    public static ArrayList<Integer> threeWayPartition(ArrayList<Integer> arr, int a, int b) {
        //add code here.
        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;
        int cases = 0;
        while (mid <= high) {
            if (arr.get(mid) < a) {
                cases = 0;
            } else if (arr.get(mid) > b) {
                cases = 2;
            } else if (arr.get(mid) >= a && arr.get(mid) <= b) {
                cases = 1;}

                switch (cases) {
                    case 0:
                        Collections.swap(arr, low, mid);
                        low++;
                        mid++;
                        break;
                    case 1:
                        mid++;
                        break;
                    case 2:
                        Collections.swap(arr, high, mid);
                        high--;
                        break;
                }
            }

        return arr;
    }
}