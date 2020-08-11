package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndOperators {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t!=null && !t.isEmpty())
            test = Integer.parseInt(t);
        for (int i = 0; i < test; i++){
            String val = br.readLine();
            if (val != null && !val.isEmpty()){
                String[] arr = val.split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                char res = findRelationalOp(a,b);
                System.out.println(res);
            }
        }
    }

    private static char findRelationalOp(int a, int b) {
        if (a < b)
            return '<';
        else if (a > b)
            return '>';
        else return '=';
    }
}
