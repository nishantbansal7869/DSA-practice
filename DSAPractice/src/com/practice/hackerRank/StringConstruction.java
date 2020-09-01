package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class StringConstruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            String s = sc.next();
            int cost = findCost(s);
            System.out.println(cost);
            test--;
        }
    }

    private static int findCost(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        return set.size();
    }
}
