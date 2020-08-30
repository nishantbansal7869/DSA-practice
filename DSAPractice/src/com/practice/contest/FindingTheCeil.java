/*
* Given an array, you have to find the ceil of a number x. The ceil of a number x is nothing but the smallest number
* in the array greater than or equal to x.

Input Format

First line of input contains N - size of the array. The next line contains N integers, the elements of the array.
* The next line contains Q - number of queries. Each of the next Q lines contains a single integer X, for which you
* have to find the ceil of X in the given array.

Constraints

30 points
1 <= N <= 105
1 <= Q <= 102
-108 <= ar[i] <= 108

70 points
1 <= N <= 105
1 <= Q <= 105
-108 <= ar[i] <= 108

Output Format

For each query, print the ceil of X, separated by newline. If ceil not found, print the value of "INT_MAX

Sample Input 0

6
-6 10 -1 20 15 5
5
-1
10
13
25
-10
Sample Output 0

-1
10
15
2147483647
-6
* */
package com.practice.contest;

import java.util.Arrays;
import java.util.Scanner;

public class FindingTheCeil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int q = sc.nextInt();
        while(q > 0){
            int k = sc.nextInt();
            int ans = findCeil(arr, k);
            System.out.println(ans);
            q--;
        }
    }

    static int findCeil(int[] arr, int k){
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < k)
                low = mid + 1;
            else{
                ans = arr[mid];
                high = mid-1;
            }
        }
        return ans;
    }
}
