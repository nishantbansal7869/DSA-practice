package com.practice.interviewbit;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Atoi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = atoi(s);
        System.out.println(ans);
    }

    private static int atoi(String s) {
        int i = 0;
        int base = 0;
        int sign = 1;
        while (s.charAt(i) == ' ')
            i++;

        if (s.charAt(i) == '-') {
            sign = -1 * sign;
            i++;
        }

        if (s.charAt(i) == '+'){
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if (base > Integer.MAX_VALUE/10 || base == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 7){
                if (sign == 1)
                    return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            base = base * 10 +(s.charAt(i) - '0');
            i++;
        }

        return base * sign;
    }
}
