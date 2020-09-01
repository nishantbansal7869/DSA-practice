package com.practice.hackerRank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndValidStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String valid = findValid(s);
        System.out.println(valid);
    }

    private static String findValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i), 1);
        }

        Set<Character> set = map.keySet();
        for (Character c : set){

        }
        return "Yes";
    }
}
