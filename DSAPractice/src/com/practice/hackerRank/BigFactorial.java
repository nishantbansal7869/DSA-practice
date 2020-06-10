package com.practice.hackerRank;

import java.math.BigInteger;

public class BigFactorial {
    public static void main(String[] args) {
        int n = 25;
        bigFactorial(n);
    }
    public static void bigFactorial(int n){
        BigInteger num = new BigInteger("1");
        for(int i = 2; i <= n; i++){
            num = num.multiply(BigInteger.valueOf(i));
        }
        System.out.println(num);
    }
}
