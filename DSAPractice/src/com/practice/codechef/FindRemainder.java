package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindRemainder {
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
            int n1,n2;
            if(s == null || s.isEmpty())
            {
                n1 = 0;
                n2 = 0;
            }
            else {
                String[] str = s.split(" ");
                n1 = Integer.parseInt(str[0]);
                n2 = Integer.parseInt(str[1]);
                int remainder = remainder(n1, n2);
                System.out.println(remainder);
            }
            testCases--;
        }
    }

    private static int remainder(int n1, int n2) {
        return n1 % n2;
    }
}
