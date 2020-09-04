package com.practice.hackerRank;

import java.util.Scanner;

public class PallindromeIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0){
            String s = sc.next();
            int ans = pallindrome(s);
            System.out.println(ans);
            n--;
        }
    }

    private static int pallindrome(String s) {
        if (s.length() == 1)
            return -1;
        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1))
                return 1;
            return 0;
        }
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                int k = i;
                int l = j-1;
                boolean flag = false;
                while (k < l){
                    if (s.charAt(k) != s.charAt(l)) {
                        flag = true;
                        break;
                    }
                    k++;
                    l--;
                }
                if (flag)
                    return i;
                return j;
            }
            i++;
            j--;
        }
        return -1;
    }
}
