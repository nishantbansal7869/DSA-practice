package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class KthPermutationSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String ans = kThPermutation(n,k);
        System.out.print(ans);
    }

    private static String kThPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        if (k > factorial(n))
            return "";
        return permutationKth(list, k-1);
    }

    private static String permutationKth(ArrayList<Integer> list, int k) {
        int n = list.size();
        if (n == 0)
            return "";
        int fact = factorial(n-1);
        int index = k/fact;
        int num = list.get(index);
        list.remove(index);
        k %= fact;
        return num + permutationKth(list, k);
    }

    private static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }


}
