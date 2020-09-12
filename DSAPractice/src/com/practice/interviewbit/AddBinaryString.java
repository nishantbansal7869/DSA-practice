package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBinaryString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        String a = arr[0];
        String b = arr[1];
        String ans = binaryString(a,b);
        System.out.println(ans);
    }

    private static String binaryString(String a, String b) {
     StringBuilder s1 = new StringBuilder(a);
     StringBuilder s2 = new StringBuilder(b);
     int l1 = s1.length();
     int l2 = s2.length();
     int diff = Math.abs(l1 - l2);
     if (l1 > l2){
         while (diff > 0) {
             s2.insert(0, '0');
             diff--;
         }
     }
     else {
         while (diff > 0){
             s1.insert(0, '0');
             diff--;
         }
     }

     StringBuilder ans = new StringBuilder("");
     int sum = 0;
     int carry = 0;
     int i = s1.length()-1;
     while (i >= 0){
         sum = (carry + (s1.charAt(i)-'0') + (s2.charAt(i) - '0'))%2;
         ans.insert(0, sum);
         carry = (carry + (s1.charAt(i)-'0') + (s2.charAt(i) - '0'))/2;
         i--;
     }
     if (carry == 1)
         ans.insert(0, carry);
     return ans.toString();
    }
}
