package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PairsWithGivenXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int count = pairs(list, b);
        System.out.println(count);
    }

    private static int pairs(ArrayList<Integer> list, int b) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++){
            int a = b ^ list.get(i);
            if(set.contains(a)){
                if (!set.contains(list.get(i))){
                    count++;
                }
            }
                set.add(list.get(i));
        }
        return count;
    }
}
