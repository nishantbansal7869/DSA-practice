package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class LeadersInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            arr.add(i, sc.nextInt());
        ArrayList<Integer> res = findLeader(arr);
        System.out.println(res);
    }

    private static ArrayList<Integer> findLeader(ArrayList<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = arr.get(arr.size()-1);
        res.add(max);
        for (int i = arr.size()-2; i >= 0; i--){
            if (arr.get(i) > max){
                max = arr.get(i);
                res.add(arr.get(i));
            }
        }
        return res;
    }
}
