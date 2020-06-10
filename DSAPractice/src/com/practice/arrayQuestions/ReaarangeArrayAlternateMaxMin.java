package com.practice.arrayQuestions;/*
* Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively
* i.e first element should be max value, second should be min value, third should be second max,
* fourth should be second min and so on.

Note: O(1) extra space is allowed. Also, try to modify the input array as required.

Input:
First line of input conatins number of test cases T. First line of test case contain an integer
* denoting the array size N and second line of test case contain N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, Output the modified array with alternated elements.

User Task:
The task is to complete the function rearrange() which rearranges elements and shouldn't print anything.
* Printing of the modified array will be handled by driver code.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 107

Example:
Input:
2
6
1 2 3 4 5 6
11
10 20 30 40 50 60 70 80 90 100 110

Output:
6 1 5 2 4 3
110 10 100 20 90 30 80 40 70 50 60

Explanation:
Testcase 1: Max element = 6, min = 1, second max = 5, second min = 2, and so on... Modified array is : 6 1 5 2 4 3.
Testcase 2: Max element = 110, min = 10, second max = 100, second min = 20, and so on...
* Modified array is : 110 10 100 20 90 30 80 40 70 50 60.
* */


public class ReaarangeArrayAlternateMaxMin {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6};
        rearrangeMaxMin(arr,arr.length);
    }
    public static void rearrangeMaxMin(int arr[], int n){
        int min_index = 0;
        int max_index = n-1;
        int max_element = arr[n-1]+1;
        for(int i = 0; i < n; i++){
            if(i%2==0){
                arr[i] += (arr[max_index]%max_element)*max_element;
                max_index--;
            }
            else {
                arr[i] += (arr[min_index]%max_element)*max_element;
                min_index++;
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] = arr[i]/max_element;
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
