package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseANum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int testCases;
        if (s == null || s.isEmpty())
            testCases = 0;
        else
            testCases = Integer.parseInt(s);
        while (testCases > 0){
            String str = br.readLine();
            int n;
            if(str == null || str.isEmpty())
                n = 0;
            else
                n = Integer.parseInt(str);
            int num = reverse(n);
            System.out.println(num);
            testCases--;
        }
    }

    private static int reverse(int n) {
        int reverse = 0;
        while (n > 0){
            reverse = (reverse * 10) + (n % 10);
            n /= 10;
        }
        return reverse;
    }
}
