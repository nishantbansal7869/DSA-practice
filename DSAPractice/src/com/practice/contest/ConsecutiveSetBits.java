/*
* Given a number N, find the max number of consecutive set bits in the number.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each containing a single number N.

Constraints

1 <= T <= 10000
0 <= N <= 1018

Output Format

For each test case, print the max number of consecutive set bits, separated by newline.

Sample Input 0

3
5
15
13
Sample Output 0

1
4
2
Explanation 0

Test Case 1
Binary Representation of 5: 101
Maximum Consecutive Set Bits: 1

Test Case 2
Binary Representation of 15: 1111
Maximum Consecutive Set Bits: 4

Test Case 3
Binary Representation of 13: 1101
Maximum Consecutive Set Bits: 2
* */

package com.practice.contest;

import java.util.Scanner;

public class ConsecutiveSetBits {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            long n = sc.nextLong();
            int count = setbits(n);
            System.out.println(count);
            test--;
        }
    }

    static int setbits(long n){
        int ans = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < 63; i++){
            if((n&(1l<<i)) >= 1)
                count += 1;
            else{
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        return ans;
    }
}
