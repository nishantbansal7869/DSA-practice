package com.practice.interviewbit;

import java.util.Scanner;

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = reverseInt(n);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }

    private static int reverseInt(int n) {
        int res = 0;
        boolean negSign = n < 0;
        if (negSign)
            n = -1 * n;
        while ( n > 0){
            int rem = n % 10;
            if (res * 10/10 != res)
                return 0;
            res = res * 10 + rem;
            n /= 10;
        }
        if (negSign)
            res = -1 * res;
        return res;
    }
}
//A : -1146467285