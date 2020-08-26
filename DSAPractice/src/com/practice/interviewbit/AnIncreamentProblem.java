package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AnIncreamentProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        ArrayList<Integer> res = increament(list);
        System.out.println(res);
    }

    private static ArrayList<Integer> increament(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++){
            if (map.containsKey(list.get(i))){
                int idx = map.get(list.get(i));
                int temp = list.get(i);
                list.set(idx, list.get(idx)+1);
                map.remove(temp);
                map.put(temp+1,idx);
            }
                map.put(list.get(i), i);
        }
        return list;
    }
}
