package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Divide {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split(" ");
        int a = Integer.parseInt(str[0]);
        int b = Integer.parseInt(str[1]);
        int result = divide(a, b);
        System.out.print(result);
    }

    private static int divide(int a, int b) {
        int sign = (a<0 ^ b<0) ? -1 : 1;
        long m = Math.abs((long)a);
        long n = Math.abs((long)b);
        long t = 0;
        long q = 0;
        for (int i = 31; i >=0; i--){
            if ((t + (n<<i)) <= m){
                t += (n<<i);
                q = (q|(1l<<i));
            }
        }

        if (sign<0) q=-q;
        System.out.println(q);
        if (q >= Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int)q;
    }
}
