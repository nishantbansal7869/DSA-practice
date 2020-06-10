package com.practice.arrayQuestions;

/*
* Given an array arr[] of N distinct integers, check if this array is Sorted (non-increasing or non-decreasing)
* and Rotated counter-clockwise. Note that input array may be sorted in either increasing or decreasing order,
* then rotated.
A sorted array is not considered as sorted and rotated, i.e., there should be at least one rotation.

Input:
The first line of input contains number of testcases T. Each testcase contains 2 lines, the first line contains N,
* the number of elements in array, and second line contains N space separated elements of array.

Output:
Print "Yes" if the given array is sorted and rotated, else Print "No", without Inverted commas.

User Task:
The task is to complete the function checkRotatedAndSorted() which checks if an array is sorted and rotated clockwise.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
5
4
3 4 1 2
3
1 2 3
4
10 20 30 14
5
30 20 10 50 35
5
30 20 10 50 25

Output:
Yes
No
No
Yes
No

Explanation:
Testcase 1: The array is sorted (1, 2, 3, 4) and rotated twice (3, 4, 1, 2).
Testcase 2: The array is sorted (1, 2, 3) is not rotated.
Testcase 3: The array is sorted (10, 20, 30, 14) is not sorted and rotated as 14 is greater than 10.

* */
public class SortedAndRotated {
    public static void main(String[] args) {
        int arr[] = new int[]{55,87};
        System.out.println(sortedAndRotated(arr,arr.length));
    }
    public static boolean sortedAndRotated(int arr[], int n){
        if(n == 1)
            return false;
        if(n == 2){
            if(arr[0] != arr[1]){
                return true;
            }
        }
        int min_index = -1;
        int min_element = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(min_element > arr[i]){
                min_element = arr[i];
                min_index = i;
            }
        }
        boolean counter = true;
        for(int i = 1; i < min_index; i++){
            if(arr[i] < arr[i-1]){
                counter = false;
                break;
            }
        }
        boolean counter2 = true;
        for(int i = min_index+1; i < n;i++){
            if(arr[i] < arr[i-1]){
                counter2 = false;
                break;
            }
        }
        if(min_index == 0){
            return false;
        }

        if(counter && counter2 && arr[n-1] < arr[min_index-1]){
            return true;
        }
        else {
            counter = true;
            for (int i = 1; i <= min_index; i++) {
                if (arr[i] > arr[i - 1]) {
                    counter = false;
                    break;
                }
            }
            counter2 = true;
            for (int i = min_index + 1; i < n-1; i++) {
                if (arr[i] < arr[i + 1]) {
                    counter2 = false;
                    break;
                }
            }
            if (min_index == n - 1) {
                return false;
            }
            if (counter && counter2 && arr[n - 1] > arr[0]) {
                return true;
            }
        }
          return false;
    }
}
