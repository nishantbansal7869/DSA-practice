package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOf4 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        int testCases;
        if (test == null || test.isEmpty())
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
            int countOf4 = countOf4(n);
            System.out.println(countOf4);
            testCases--;
        }
    }

    private static int countOf4(int n) {
        int count = 0;
        while (n > 0){
            int rem = n % 10;
            if (rem == 4)
                count++;
            n /= 10;
        }
        return count;
    }
}
