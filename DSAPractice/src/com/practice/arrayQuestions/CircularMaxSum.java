/*
* Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous
* subarray sum.

Input:
The first line of input contains a single integer T which denotes the number of test cases. The first line of each
* test case contains a single integer N which denotes the total number of
* elements. The second line of each test case contains N space-separated integers denoting the elements of the array.

Output:
For each test case print the maximum sum obtained by adding the consecutive elements.

User Task:
The task is to complete the function circularSubarraySum() which finds the circular subarray with maximum sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 101
1 <= N <= 106
-106 <= Arr[i] <= 106

Example:
Input:
3
7
8 -8 9 -9 10 -11 12
8
10 -3 -4 7 6 5 -4 -1
8
-1 40 -14 7 6 5 -4 -1

Output:
22
23
52

Explanation:
Testcase 1: Starting from the last element of the array, i.e, 12, and moving in a circular fashion,
*  we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.
* */

package com.practice.arrayQuestions;

public class CircularMaxSum {
    public static void main(String[] args) {
        int arr[] = new int[]{8,-4,3,-5,4};
        System.out.println(maxSum(arr, arr.length));
    }
    public static int maxSum(int arr[], int n){
        int max_normal = maxNornmal(arr,n);
        if(max_normal<0){
            return max_normal;
        }
        int arr_sum = 0;
        for(int i = 0; i < n; i++){
            arr_sum += arr[i];
            arr[i] = -arr[i];
        }
        int max_circular = arr_sum + maxNornmal(arr,n);
        return Math.max(max_circular,max_normal);
    }
    public static int maxNornmal(int arr[], int n){
        int res = 0;
        int maxEnding = arr[0];
        for(int i = 1; i < n; i++)
        {
            maxEnding = Math.max(maxEnding+arr[i],arr[i]);
            res = Math.max(res,maxEnding);
        }
        return res;
    }
}
