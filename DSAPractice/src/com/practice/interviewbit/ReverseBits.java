package com.practice.interviewbit;

import java.util.Scanner;

public class ReverseBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long reverse = reverseBit(n);
        System.out.print(reverse);
    }

    private static long reverseBit(long n) {
        int i= 0;
        int j = 31;
        long n1 = 0;
        for (; i < 32; i++){
            if ((n&(1<<i)) > 0){
                n1 = n1 | 1l<<j;
            }
            j--;
        }
        return n1;
    }
}
