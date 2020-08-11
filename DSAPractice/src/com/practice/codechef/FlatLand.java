package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FlatLand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        while (test > 0){
            String s = br.readLine();
            int n = 0;
            if (s != null && !s.isEmpty()){
                n = Integer.parseInt(s);
                int output = findCircles(n);
                System.out.println(output);
            }
            test--;
        }
    }

    private static int findCircles(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (n == 3)
            return 3;
        int count = 0;
        int num;
        while (n != 0){
            if (n == 1){
                count++;
                return count;
            }
            num = (int)Math.sqrt(n);
            count++;
            n -= num*num;
        }
    return count;
    }
}
