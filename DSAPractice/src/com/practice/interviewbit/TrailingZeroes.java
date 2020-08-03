package com.practice.interviewbit;

import java.util.Scanner;

public class TrailingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = trailingZeros(n);
        System.out.print(count);
    }

    private static int trailingZeros(int n) {
        if (n == 0)
            return 32;
        int count = 0;
        while (n != 0){
            if ((n&1) == 0)
                count++;
            else
                break;
            n = n>>1;
        }
        return count;
    }
}
