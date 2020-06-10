/*
* Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be
* repeated or can be absent from the array. Your task is to count the frequency of all elements from 1 to N.

Input Format:
The first line of input contains an integer T denoting the number of test cases. For each test case, the first
* line contains an integer N denoting the size of the array. The second line contains N space-separated integers
* A1, A2, ..., AN denoting the elements of the array.

Output Format:
For each test case, output N space-separated integers denoting the frequency of each element from 1 to N.

Your Task:
You need to complete the function printfrequency and return frequency of each element. The new line is automatically
* added by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 <= A[i] <= 106

Example:
Input:
2
5
2 3 2 3 5
4
3 3 3 3

Output:
0 2 2 0 1
0 0 4 0

Explanation:
Testcase 1: Counting frequencies of each array element, we have:
1 occurring 0 times.
2 occurring 2 times.
3 occurring 2 times.
4 occurring 0 times.
5 occurring 1 time.
Testcase 2: Counting frequencies of each array element, we have:
1 occurring 0 times.
2 occurring 0 times.
3 occurring 4 times.
4 occurring 0 times.
* */

package com.practice.arrayQuestions;

import java.util.ArrayList;

public class Frequency {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,2,3,5};
        freq(arr,arr.length);
    }
    public static void freq(int arr[], int n){
        int arr1[] = new int[n];
        for(int i = 0; i < n; i++){
            arr1[arr[i]-1]++;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0; i < n; i++){
            a.add(i,arr1[i]);
        }

        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i));
        }
    }
}
