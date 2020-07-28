package com.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        while (n > 0){
            String str = br.readLine();
            String print = wayTooLongWord(str);
            System.out.println(print);
            n--;
        }
    }

    private static String wayTooLongWord(String str) {
        if(str.length() <= 10)
            return str;
        String s = "";
        s = s + str.charAt(0) + (str.length() - 2) + str.charAt(str.length()-1);
        return s;
    }
}
