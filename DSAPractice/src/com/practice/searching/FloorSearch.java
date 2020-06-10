/*
* Given a sorted array arr[] of size N without duplicates, and given a value x. Find the
* floor of x in given array. Floor of x is defined as the largest element K in arr[] such that
* K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains
* number of elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1 (0 based Indexing).

User Task:
The task is to complete the function findFloor() which finds the floor of x.
Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

Example:
Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3

Explanation:
Testcase 1: No element less than 0 is found. So output is "-1".
Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
Testcase 3: Number less than or equal to 10 is 10 and its index is 3.
* */

package com.practice.searching;

public class FloorSearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,8,10,11,12,19};
        System.out.println(floorSearch(arr,0,arr.length-1,1));
    }
    public static int floorSearch(int arr[], int low, int high, int x){
        if(low > high || x == 0)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] <= x && (mid == arr.length-1 || arr[mid+1] > x)){
            return mid;
        }
        if(arr[mid] > x){
            return floorSearch(arr,low, mid-1,x);
        }
        else
            return floorSearch(arr,mid+1,high,x);
    }
}
