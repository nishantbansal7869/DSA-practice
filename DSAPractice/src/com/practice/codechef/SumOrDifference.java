/*
* *
* Write a program to take two numbers as input and print their difference if the first number is greater than
* the second number otherwise print their sum.

Input:
First line will contain the first number (N1)
Second line will contain the second number (N2)
Output:
Output a single line containing the difference of 2 numbers (N1−N2) if the first number is greater than the
* second number otherwise output their sum (N1+N2).

Constraints
−1000≤N1≤1000
−1000≤N2≤1000
Sample Input:
82
28
Sample Output:
54
* */


package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SumOrDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int n1, n2;
        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty())
        {
            n1 = 0;
            n2 = 0;
        }
        else {
            n1 = Integer.parseInt(s1);
            n2 = Integer.parseInt(s2);
        }
        int result = sumOrDiff(n1, n2);
        System.out.println(result);
    }

    private static int sumOrDiff(int n1, int n2) {
        return n1 > n2 ? n1-n2 : n1+n2;
    }
}
