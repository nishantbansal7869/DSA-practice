/*
* Write a program to obtain a number N and increment its value by 1 if the number is divisible by 4 otherwise
* decrement its value by 1.

Input:
First line will contain a number N.
Output:
Output a single line, the new value of the number.

Constraints
0≤N≤1000
Sample Input:
5
Sample Output:
4
EXPLANATION:
Since 5 is not divisible by 4 hence, its value is decreased by 1.
* */

package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IncreamentOrDecreament {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = 0;
        if(s == null || s.isEmpty())
            n = 0;
        else
            n = Integer.parseInt(s);
        int num = divideBy4(n);
        System.out.println(num);
    }

    private static int divideBy4(int n) {
        if(n == 0)
            return 0;
        return n % 4 == 0 ? n+1 : n-1;
    }
}
