package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
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
            if(s == null || s.isEmpty())
                n = 0;
            else
                n = Integer.parseInt(s);
            int fact = factorial(n);
            System.out.println(fact);
            testCases--;
        }
    }

    private static int factorial(int n) {
        int fact = 1;
        while (n > 0){
            fact = ((fact%1000000007) * n)%1000000007;
            n--;
        }
        return fact;
    }
}
