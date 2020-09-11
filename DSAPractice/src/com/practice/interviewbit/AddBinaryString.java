package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String ans = binaryString(a,b);
        System.out.println(ans);
    }

    private static String binaryString(String a, String b) {
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int count = 0;
        StringBuilder sb = new StringBuilder("");
        while (i >= 0 && j >= 0){
            count = 0;
            int n =  carry ^ (a.charAt(i) - '0') ^ (b.charAt(j) - '0');
            sb.append(n);
            if (n == 0){
                if (carry == 1)
                    count++;
                if (a.charAt(i) - '0' == 1)
                    count++;
                if (b.charAt(j) - '0' == 1)
                    count++;
                if (count >= 2)
                    carry = 1;
            }
            else
                carry = 0;
            i--;
            j--;
        }
        while (i >= 0) {
            int n = carry ^ a.charAt(i) - '0';
            sb.append(n);
            if (n == 1) {
                carry = 0;
            }
            i--;
        }

        while (j >= 0) {
            int n = carry ^ b.charAt(j) - '0';
            sb.append(n);
            if (n == 1) {
                carry = 0;
            }
            j--;
        }

        if (carry == 1)
            sb.append(1);
        return sb.reverse().toString();
    }
}
