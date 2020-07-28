/*
* If Give an integer N . Write a program to obtain the sum of the first and last digits of this number.

Input
The first line contains an integer T, the total number of test cases. Then follow T lines, each line contains
*  an integer N.

Output
For each test case, display the sum of first and last digits of N in a new line.

Constraints
1 ≤ T ≤ 1000
1 ≤ N ≤ 1000000
Example
Input
3
1234
124894
242323

Output
5
5
5
* */

package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FirstAndLastDigit {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        int testCases;
        if(test == null || test.isEmpty())
            testCases = 0;
        else
            testCases = Integer.parseInt(test);
        while (testCases > 0){
            String s = br.readLine();
            int n;
            if (s == null || s.isEmpty())
                n = 0;
            else
                n = Integer.parseInt(s);
            int sum = firstAndLast(n);
            System.out.println(sum);
            testCases--;
        }
    }

    private static int firstAndLast(int n) {
        if(n / 10 == 0)
            return n;
        int firstDigit = n % 10;
        int lasDigit = 0;
        while (n > 0){
            if (n / 10 == 0)
               lasDigit = n % 10;
            n /= 10;
        }
        return firstDigit + lasDigit;
    }
}
