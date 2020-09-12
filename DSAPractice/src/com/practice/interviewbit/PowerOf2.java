package com.practice.interviewbit;

import java.util.Scanner;

public class PowerOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = powerOf2(s);
        System.out.println(ans);
    }

    private static int powerOf2(String s) {
        if (s.equals("1"))
            return 0;
        String divisor = "0";
        while (!divisor.equals("1")) {
            divisor = divide(s, 2);
            s = divisor;
            if (!divisor.equals("1") && (divisor.charAt(divisor.length()-1) - '0') % 2 != 0)
                return 0;
        }
        return 1;
    }

    private static String divide(String s, int dividend) {
        StringBuilder divisor = new StringBuilder("");
        int i = 0;
        int carry = 0;
        while (i < s.length()){
            int num = (carry * 10 + (s.charAt(i)-'0'))/dividend;
            divisor.append(num);
            carry = (carry * 10 + (s.charAt(i)-'0'))%dividend;
            i++;
        }
        for (int j = 0; j < divisor.length(); j++){
            if (divisor.charAt(j) != '0')
                return divisor.substring(j);
        }
        return "";
    }
}
