package com.practice.arrayQuestions;/*
* Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.

Input Format:
The first line of input contains a single integer T denoting the number of test cases.
* Then T test cases follow. Each test case consist of two lines of input. The first line of each
* test case consists of an integer N(size of array) and an integer K separated by a space.
* The second line of each test case contains N space separated integers denoting the array elements.

Output Format:
For each test case, in a new line, print the modified array.

User Task:
The task is to complete the function reverseInGroups() which reverses elements of the array
* in groups and returns the array. The printing of array is done by drivercode.

Constraints:
1 ≤ T ≤ 200
1 ≤ N, K ≤ 107
1 ≤ A[i] ≤ 1018

Example:
Input
4
5 3
1 2 3 4 5
4 3
5 6 8 9
4 7
5 6 8 9
8 3
1 2 3 4 5 6 7 8

Output
3 2 1 5 4
8 6 5 9
9 8 6 5
3 2 1 6 5 4 8 7

Explanation:
Testcase 1: Reversing groups in size k = 3, first group consists of elements 1, 2, 3.
* Reversing this group, we have elements in order as 3, 2, 1.
Testcase 2: Our array is 5 6 8 9. The value of k is 3. So we reverse it in groups of 3.
* After reversing, it becomes 8 6 5 9.
Testcase 3: Our array is 5 6 8 9. The value of k is 7. After reversing, it becomes 9 8 6 5.
Testcase 4: Our array is 1 2 3 4 5 6 7 8. The value of k is 3. After reversing, it becomes 3 2 1 6 5 4 8 7.
* */

import java.util.ArrayList;
import java.util.Collections;

public class ReverseArrayInGroup {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            arr.add(i,i+1);
        }
        reverseArr(arr,arr.size(),4);
    }
    public static void reverseArr(ArrayList<Integer> mv, int n, int k){
        for(int i = 0; i < n; i+=k){
            int s = i;
            int e = (i+k)-1;
            if(e > n-1)
                e = n-1;
            while(s<=e){
                Collections.swap(mv,s,e);
                s++;
                e--;
            }
        }
        for(int p = 0;p < n; p++){
            System.out.println(mv.get(p));
        }
    }
}
