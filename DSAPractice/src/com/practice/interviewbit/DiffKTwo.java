package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DiffKTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int k = sc.nextInt();
        int exist = findDiff(list, k);
        System.out.println(exist);
    }

    private static int findDiff(ArrayList<Integer> list, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : list){
            if (map.containsKey(i)){
                int count = map.get(i);
                map.put(i, count+1);
            }
            else
                map.put(i, 1);
        }
        for (int i : list){
            int b = k + i;
            if (map.containsKey(b)){
                if(i == b && map.get(b) > 1)
                    return 1;
                else if (i != b)
                    return 1;
            }
        }
        return 0;
    }
}
