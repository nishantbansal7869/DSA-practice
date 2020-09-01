package com.practice.hackerRank;

import java.util.Scanner;

public class StringModuloEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            String n = sc.next();
            String p = sc.next();
            long ans = findModulo(n, p);
            System.out.println(ans);
            test--;
        }
    }

    private static long findModulo(String n, String p) {
        int m = (int)1e9;
        long ans = 0;
        while (!n.equals("")){
            int a = Integer.parseInt(n.substring(0,m+1));
            ans = a % Integer.parseInt(p);
            n = n.substring(m+1);
        }
        return ans;
    }
}
