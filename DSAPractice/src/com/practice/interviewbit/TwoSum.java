package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i,sc.nextInt());
        int sum = sc.nextInt();
        ArrayList<Integer> res = findPair(list, sum);
        System.out.println(res);
    }

    private static ArrayList<Integer> findPair(ArrayList<Integer> list, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            int a = sum - list.get(i);
            if (map.containsKey(a)){
                res.add(map.get(a)+1);
                res.add(i+1);
                return res;
            }
            else {
                if (!map.containsKey(list.get(i))){
                    map.put(list.get(i), i);
                }
            }
        }
        return res;
    }
}
