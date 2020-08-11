package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingSquareRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        while (test > 0){
            String s = br.readLine();
            if (s != null && !s.isEmpty()){
                int n = Integer.parseInt(s);
                int root = findRoot(n);
                System.out.println(root);
            }
            test--;
        }
    }

    private static int findRoot(int n) {
        return (int)Math.sqrt(n);
    }
}
