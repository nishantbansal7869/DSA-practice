package com.practice.arrayQuestions;/*
* Given an array arr[] of size N where every element is in the range from 0 to n-1.
* Rearrange the given array so that arr[i] becomes arr[arr[i]].

Input Format:
First-line contains an integer denoting the test cases 'T'. The first line of each
* test case contains an integer value depicting the size of array 'N' and the next line contains
* N space-separated integers denoting the elements of the array.

Output Format:
Print all elements of the array after rearranging, each separated by a space,
* in a separate line for each test case.

User Task:
The task is to complete the function arrange() which arranges the elements in the array.
* The printing is done automatically done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 107
0 <= Arr[i] < N

Example:
Input:
3
2
1 0
5
4 0 2 1 3
4
3 2 0 1

Output:
0 1
3 4 2 0 1
1 0 3 2

Explanation:
Testcase 1: arr[0] = 1 and arr[arr[0]] = 0.
* Also, arr[1] = 0 and arr[arr[1]] = 1. So, rearranging elements, we get array as, 0 1.
Testcase 2: arr[0] = 4 and arr[arr[0]] = 3.
* Also, arr[1] = 0 and arr[arr[1]] = 4 and so on. So, rearranging elements, we get array as 3 4 2 0 1.
Testcase 3: arr[0] = 3 and arr[arr[0]] = 1.
* Also, arr[1] = 2 and arr[arr[1]] = 0 and so on. So, rearranging elements, we get array as 1 0 3 2.
* */


public class RearrangeArray {
    public static void main(String[] args) {
        long arr[] = new long[]{5,0,3,7,1,4,6,2};
        rearrangeArray(arr,arr.length);
    }
    public static void rearrangeArray(long arr[], int n){
        long max_element = arr[0];
        for(int i = 1; i < n; i++){
            max_element = Math.max(max_element, arr[i]);
        }
        max_element++;
        for(int i = 0; i < n; i++){
            arr[i] += (arr[(int)(arr[i]%max_element)]%max_element)*max_element;
        }
        for(int i = 0; i < n; i++){
            arr[i] /= max_element;
        }
        for(int i = 0;i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
