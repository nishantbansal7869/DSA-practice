package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Scanner;

public class StringInList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.next());
        String s = "smartinterviews";
        boolean exist = solve(list, s, list.size(), 0);
        System.out.println(exist);
    }

    private static boolean solve(ArrayList<String> list, String s, int size, int idx) {
        if (idx == size)
            return true;
        for (int i = idx; i < size; i++){
            if (list.contains(s.substring(idx, i+1))){
                if (solve(list, s, size, i+1))
                    return true;
            }
        }
        return false;
    }
}
