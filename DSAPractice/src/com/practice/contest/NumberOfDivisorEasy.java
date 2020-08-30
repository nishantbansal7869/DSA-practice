/*
* Given a number, find the number of divisors of that number.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each containing a single number N.

Constraints

30 points
1 <= T <= 100
1 <= N <= 106

70 points
1 <= T <= 100
1 <= N <= 109

Output Format

For each test case, print the number of divisors of N, separated by newline.

Sample Input 0

5
8
16808
9
23
97158
Sample Output 0

4
16
3
2
8
* */
package com.practice.contest;

import java.util.Scanner;

public class NumberOfDivisorEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            int n = sc.nextInt();
            int count = noOfDivisors(n);
            System.out.println(count);
            test--;
        }
    }
    static int noOfDivisors(int n){
        int count = 0;
        int m = (int)Math.sqrt(n);
        for(int i = 1; i <= m; i++){
            if(n % i == 0)
                count++;
        }
        if(m*m == n)
            return (2*count)-1;
        return 2*count;
    }
}
