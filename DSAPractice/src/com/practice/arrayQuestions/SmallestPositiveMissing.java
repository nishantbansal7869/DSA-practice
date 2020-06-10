package com.practice.arrayQuestions;/*
* You are given an array arr[] of N integers including 0. The task is to find the smallest positive
* number missing from the array.
Note: Expected solution in O(n) time using constant extra space (don't use hash maps or sorting
* algorithms in your solution).

Input:
First line consists of T test cases. First line of every test case consists of N, denoting the number
* of elements in array. Second line of every test case consists of elements in array.

Output:
Single line output, print the smallest positive number missing.

User Task:
The task is to complete the function missingNumber() which returns the smallest positive missing number in the array.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
5
1 2 3 4 5
5
0 -10 1 3 -20
Output:
6
2

Explanation:
Testcase 1: Smallest positive missing number is 6.
Testcase 2: Smallest positive missing number is 2.
* */

public class SmallestPositiveMissing {
    public static void main(String[] args) {
        int arr[] = new int[]{24,-20,26,-46,-31,6,-4,5,-11};
        System.out.println(smallestMissingEl(arr,arr.length));
    }
    public static int smallestMissingEl(int arr[], int n){
        int sum = 0;
        int sum1 = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            sum1 = sum1 + i + 1;
        }
        if(sum == sum1){
            return n+1;
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > 0 && arr[i] < n){
                int temp = arr[arr[i]];
                arr[arr[i]] = Integer.MIN_VALUE;
                while(temp > 0 && temp < n){
                    int temp1 = arr[temp];
                    if(temp < 0){
                        break;
                    }
                    arr[temp] = Integer.MIN_VALUE;
                    temp = temp1;
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(arr[i] != Integer.MIN_VALUE){
                res = i;
                break;
            }
        }
        if(res == 0){
            res = n;
        }
        return res;
    }
}
