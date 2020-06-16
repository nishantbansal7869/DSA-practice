/*
* Given a positive integer n and a string s consisting only of letters D or I, you have to find
*  any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]
* */
package com.practice.arrayQuestions;

import java.util.ArrayList;

public class FindPermutation {
    public static void main(String[] args) {
        int n = 5;
        String s = "IIII";
        findPermuation(n,s);
        res.stream().forEach(str->System.out.println(str));
    }
    public static ArrayList<Integer> res = new ArrayList<>();
    public static void findPermuation(int n, String s){
        int[] arr = new int[]{1,n};
        if(s.charAt(0) == 'D'){
            res.add(n);
            arr[1]--;
        }
        else if(s.charAt(0) == 'I'){
            res.add(1);
            arr[0]++;
        }
        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == 'D' && s.charAt(i+1) == 'D'){
                res.add(arr[1]);
                arr[1]--;
            }
            if(s.charAt(i) == 'D' && s.charAt(i+1) == 'I'){
                res.add(arr[0]);
                arr[0]++;
            }
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'D'){
                res.add(arr[1]);
                arr[1]--;
            }
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'I'){
                res.add(arr[0]);
                arr[0]++;
            }
        }
        res.add(arr[0]);
    }
}
