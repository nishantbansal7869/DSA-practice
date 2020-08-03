package com.practice.interviewbit;

import java.util.Scanner;

public class CountTotalSetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        int result  = countSetBits(n);
        System.out.print(result);
    }

    private static int countSetBits(Integer n) {
       long val1, val2, sum;
       sum = 0;
       for (int i = 1; i < 32; i++){
           val1 = (int)((n+1)/Math.pow(2,i));
           val2 = (int)((n+1)%Math.pow(2,i));
           if (val2 > Math.pow(2,i-1))
               val2 = val2 - (int)Math.pow(2,i-1);
           else
               val2 = 0;
           sum = sum + (int)(val1 * Math.pow(2,i-1)) + val2;
       }
       return (int)(sum % 1000000007);
    }
}

/*
*   long val1,val2,cnt;
        cnt = 0;
        for(int i = 1;i<32;i++){
            val1 = (int)((A+1)/Math.pow(2,i));
            val2 = (int)((A+1)%Math.pow(2,i));
            if(val2 > Math.pow(2,i-1))
                val2 = val2 - (int)Math.pow(2,i-1);
            else
                val2 = 0;
            cnt = cnt + (int)(val1*Math.pow(2,i-1)) + val2;
        }

       return (int)(cnt%1000000007);
* */