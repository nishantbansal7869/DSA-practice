package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoodJoke {
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
                String[] arr = new String[n];
                for (int i = 0; i < n; i++){
                    arr[i] = br.readLine();
                }
                int res = findOutput(n);
                System.out.println(res);
            }
            test--;
        }
    }

    private static int findOutput(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++)
            res = res ^ i;
        return res;
    }
}
