package com.practice.hackerRank;

import java.util.Scanner;

public class DivisorsOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            int n = sc.nextInt();
            int res = divOfN(n);
            System.out.println(res);
            t--;
        }
    }

    private static int divOfN(int n) {
        if (n == 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= (int)Math.sqrt(n); i++){
            if (n%i == 0)
                count++;
        }
        if(Math.sqrt(n) * Math.sqrt(n) == n)
            return 2*count-1;
        return 2*count;
    }
}
