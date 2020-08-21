/*
* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
* */
package com.practice.interviewbit;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-1);
        a.add(2);
        a.add(1);
        a.add(-4);
        int b = 1;
        int closestSum = findSum(a, b);
        System.out.println(closestSum);
    }

    private static int findSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        int output = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++){
            int c = b - a.get(i);
            int sum = findSumOfPairs(a, a.size(), i+1, c);
            if (sum + a.get(i) == c)
                return sum+a.get(i);
            if (sum != Integer.MIN_VALUE)
            {
                output = Math.min(output, sum + a.get(i));
            }
        }
        return output;
    }

    private static int findSumOfPairs(ArrayList<Integer> a, int size, int i, int c) {
        int p1 = i;
        int p2 = size - 1;
        while (p1 < p2){
            int sum = a.get(p1) + a.get(p2);
            if (sum == c || sum == c + 1 || sum == c - 1)
                return sum;
            if (sum > c)
                p2--;
            else
                p1++;
        }
        return Integer.MIN_VALUE;
    }
}
