/*
* Given an array A, check if there is any subset of array A in which if we do BITWISE AND of all elements of that subset,
*  the result is a power of two (1,2,4,8,16 and so on ).

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - size of
*  array A and the next line contains N space separated integers.

Constraints

50 points
1 <= T <= 100
1 <= N <= 15
0 <= arr[i] <= 109

150 points
1 <= T <= 1000
1 <= N <= 1000
0 <= arr[i] <= 109

Output Format

For each test case, print "YES" if such a subset exists, otherwise print "NO", separated by a new line.

Sample Input 0

3
3
1 2 3
2
10 20
5
5 20 11 14 15
Sample Output 0

YES
NO
YES
Explanation 0

Test Case 1
The subset {2} gives AND result of 2, or the subset {3,1} gives AND result of 1, both are powers of 2.

Test Case 2
The subset {5,14,15} gives AND result of 4, which is a power of 2.
* */

package com.practice.contest;

import java.util.Scanner;

public class PowerfulSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            boolean check = powerfulSubset(arr);
            if (check)
                System.out.println("YES");
            else
                System.out.println("NO");
            test--;
        }
    }

    private static boolean powerfulSubset(int[] arr) {
        for (int i = 0; i < 31; i++){
          int num = (1<<31)-1;
            for (int j : arr){
                if (checkBit(j,i) >= 1)
                    num = num & j;
            }
            if (setBits(num) == 1)
                return true;
        }
        return false;
    }

    private static int setBits(int num) {
        int count = 0;
        for (int i = 0; i < 31; i++){
            if ((num&(1<<i)) >= 1)
                count++;
        }
        return count;
    }

    private static int checkBit(int j, int i) {
        return (j&(1<<i));
    }
}
