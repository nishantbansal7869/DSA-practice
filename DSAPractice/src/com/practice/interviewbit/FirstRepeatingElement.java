package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int res = firstRepeatingElement(list);
        System.out.println(res);
    }

    private static int firstRepeatingElement(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>(2);
        temp.add(Integer.MAX_VALUE);
        temp.add(Integer.MAX_VALUE);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list.get(0), 0);
        for (int i = 1; i < list.size(); i++){
            if (map.containsKey(list.get(i))){
                int idx = map.get(list.get(i));
                if (idx < temp.get(1)){
                    temp.set(0, list.get(i));
                    temp.set(1, idx);
                }
            }
            else {
                map.put(list.get(i), i);
            }
        }
        return temp.get(0) != Integer.MAX_VALUE ? temp.get(0) : -1;
    }
}
