/*
* We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example,
* f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit
*  differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that
*  1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) +
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
* */

package com.practice.interviewbit;

import java.util.ArrayList;

public class DifferenceBitsSumPAirWise {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        int result = findsum(arr);
        System.out.print(result);
    }

    private static int findsum(ArrayList<Integer> arr) {
        int[] count = new int[32];
        for (int a : arr){
            for (int i = 0; i < 32; i++){
                count[i] += a&1;
                a = a>>1;
            }
        }
        long res = 0;
        for (int i = 0; i < 32; i++){
            res += ((long)count[i] * (arr.size()-count[i]))%1000000007;
        }
        return (int)(2*res%1000000007);
    }

}
