package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String test = br.readLine();
        int testCases = 0;
        if(test == null || test.isEmpty())
            testCases = 0;
        else
            testCases = Integer.parseInt(test);
        while (testCases > 0){
            String s1 = br.readLine();
            int num1, num2;
            if(s1 == null|| s1.isEmpty()){
                num1 = 0;
                num2 = 0;
            }
            else {
                String[] str = s1.split(" ");
                num1 = Integer.parseInt(str[0]);
                num2 = Integer.parseInt(str[1]);
            }
            System.out.println(num1 + num2);
            testCases--;
        }
    }
}
