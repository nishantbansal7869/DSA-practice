package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PermutationOfAString {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++){
            String a = sc.next();
            String b = sc.next();
            char[] result = new char[a.length()+b.length()];
            interleave(a, b, result, 0, 0, 0, a.length(), b.length());
            Collections.sort(list);
            System.out.println("Case #"+i);
            list.stream().forEach(j -> System.out.println(j));
            list.clear();
        }
    }

    private static void interleave(String a, String b, char[] result, int idxA, int idxB, int idx, int lengthA, int lengthB)
    {
        if (idx == lengthA + lengthB){
            String s = new String(result);
            list.add(s);
            return;
        }
        if (idxA < lengthA){
            result[idx] = a.charAt(idxA);
            interleave(a, b, result, idxA+1, idxB, idx+1,lengthA, lengthB);
        }
        if (idxB < lengthB){
            result[idx] = b.charAt(idxB);
            interleave(a, b, result, idxA, idxB+1, idx+1, lengthA, lengthB);
        }
    }
}
