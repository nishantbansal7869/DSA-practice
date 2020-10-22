package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctNumbersInAWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        ArrayList<Integer> ans = distinctElInWindow(list, b);
        System.out.println(ans);
    }

    private static ArrayList<Integer> distinctElInWindow(ArrayList<Integer> list, int b) {
        if (b > list.size())
            return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < b; i++){
            if (map.containsKey(list.get(i)))
                map.put(list.get(i), map.get(list.get(i))+1);
            else
                map.put(list.get(i), 1);
        }
        ans.add(map.size());
        for (int i = b; i < list.size(); i++){
            map.put(list.get(i-b), map.get(list.get(i-b))-1);
            if (map.get(list.get(i-b)) == 0)
                map.remove(list.get(i-b));
            if (map.containsKey(list.get(i)))
                map.put(list.get(i), map.get(list.get(i))+1);
            else
                map.put(list.get(i), 1);
            ans.add(map.size());
        }
        return ans;
    }
}
