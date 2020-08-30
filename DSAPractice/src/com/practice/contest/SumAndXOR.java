/*
* Given a integer N, find the number of positive integers X such that X<=N and N+X = N^X (N xor X).

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N.

Constraints

20 points
1 <= T <= 103
0 <= N <= 103

80 points
1 <= T <= 104
0 <= N <= 1018

Output Format

For each test case, print the count of X's, separated by new line.

Sample Input 0

2
5
10
Sample Output 0

1
3
Explanation 0

Test Case 1
Possible values: 5+2 = 5^2.

Test Case 2
Possible values: 10+1 = 10^1, 10+4=10^4, 10+5=10^5
* */
package com.practice.contest;

import java.util.Scanner;

public class SumAndXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            long n = sc.nextLong();
            long ans = sumAndXor(n);
            System.out.println(ans);
            test--;
        }
    }

    static long sumAndXor(long n){
        int count = 0;
        int msb = findMSB(n);
        //System.out.println(msb);
        for(int i = 0; i < msb; i++){
            if((n&(1l<<i)) == 0)
                count++;
        }
        return (long)Math.pow(2,count)-1l;
    }

    static int findMSB(long n){
        for(int i = 63; i >= 0; i--){
            if((n&(1l<<i)) >= 1)
                return i;
        }
        return 0;
    }
}
