/*
* You're given an integer N. Write a program to calculate the sum of all the digits of N.

Input
The first line contains an integer T, the total number of testcases. Then follow T lines, each line contains an integer N.

Output
For each test case, calculate the sum of digits of N, and display it in a new line.

Constraints
1 ≤ T ≤ 1000
1 ≤ N ≤ 1000000
Example
Input
3
12345
31203
2123
Output
15
9
8
* */

package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        int testCases;
        if(test == null || test.isEmpty())
            testCases = 0;
        else
            testCases = Integer.parseInt(test);
        while (testCases > 0){
            String num = br.readLine();
            int n;
            if(num == null || num.isEmpty())
                n = 0;
            else
                n = Integer.parseInt(num);
            int sumOfDigits = sumOfDigits(n);
            System.out.println(sumOfDigits);
            testCases--;
        }
    }

    private static int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
