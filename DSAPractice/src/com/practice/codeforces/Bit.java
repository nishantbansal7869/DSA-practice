package com.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bit {
    public static void main(String[] args) throws IOException {
        int x = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n;
        if(s == null || s.isEmpty())
            n = 0;
        else
            n = Integer.parseInt(s);
        while (n > 0){
            String str = br.readLine();
            if(str.charAt(1) == '+')
                ++x;
            else
                --x;
            n--;
        }
        System.out.println(x);
    }
}
