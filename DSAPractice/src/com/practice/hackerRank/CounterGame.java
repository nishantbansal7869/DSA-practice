package com.practice.hackerRank;

import java.util.Scanner;

public class CounterGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++){
            long n = sc.nextLong();
            String winner = counterGame(n);
            System.out.print(winner);
        }
    }

    private static String counterGame(long n) {
        if (n == 1)
            return "Richard";
        long flag = 0;
        while (n >= 1){
            int bit = findMSB(n);
            long num = 1l<<bit;
            if (n == num) {
                n = n>>1;
            }
            else {
                n -= num;
            }
            boolean check = checkVal(n);
            if (check){
                break;
            }
            flag += 1;
        }
        if (flag % 2 == 0)
            return "Louise";
        else
            return "Richard";
    }

    private static boolean checkVal(long n) {
        if (n == 1l)
            return true;
        return false;
    }

    private static int findMSB(long n) {
        int bit = 0;
        for (int i = 0; i < 64; i++){
            if ((n&(1l<<i)) != 0)
                bit = i;
        }
        return bit;
    }
}
