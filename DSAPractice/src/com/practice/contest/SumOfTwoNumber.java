/*
* Given an array, check if there exists 2 elements of the array such that their sum is equal to the sum of the
* remaining elements of the array.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N -
*  the size of the array. The second line contains a N integers - elements of the array.

Constraints

30 points
1 <= T <= 100
1 <= N <= 1000
-106 <= A[i] <= 106

70 points
1 <= T <= 500
1 <= N <= 10000
-106 <= A[i] <= 106

Output Format

For each test case, print "Yes" if such elements exists, "No" otherwise, separated by new line.

Sample Input 0

2
5
-3 5 8 2 -4
6
5 -10 8 4 2 -3
Sample Output 0

Yes
No
Explanation 0

Test Case 1
Possible values: 8+(-4) = (-3)+5+2.

Test Case 2
No 2 elements exists whose sum is equal to the sum of the remaining array elements.
* */
package com.practice.contest;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfTwoNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i= 0; i < n; i++)
                arr[i] = sc.nextInt();
            boolean check = sumOfTwo(arr);
            if(check)
                System.out.println("Yes");
            else
                System.out.println("No");
            test--;
        }
    }

    static boolean sumOfTwo(int[] arr){
        Arrays.sort(arr);
        int sum = 0;
        for(int i : arr)
            sum += i;
        if(sum % 2 != 0)
            return false;
        sum = sum/2;
        int p1 = 0;
        int p2 = arr.length - 1;
        while(p1 < p2){
            if(arr[p1] + arr[p2] == sum)
                return true;
            if(arr[p1] + arr[p2] > sum)
                p2--;
            else
                p1++;
        }
        return false;
    }
}
