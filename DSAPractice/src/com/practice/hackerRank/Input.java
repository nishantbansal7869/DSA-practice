package com.practice.hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* InputStream inputStream = System.in;

		InputReader in = new InputReader(inputStream);

		// Read the number of test casese.
		int T = in.nextInt();
		while (T-- > 0) {
			// Read the numbers a and b.
			int a = in.nextInt();
			int b = in.nextInt();

			// Compute the sum of a and b.
			int ans = a + b;
			System.out.println(ans);
		}
* */

public class Input {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String sTest = br.readLine();
       if(sTest == null || sTest.isEmpty()){
           System.out.println(0);
       }
       else {
           int test = Integer.parseInt(sTest);
           while (test != 0){
               String s1 = br.readLine();
               String s2 = "";
               int a = 0;
               int b = 0;
               if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()){
                  System.out.println(0);
               }
               else {
                   a = Integer.parseInt(s1);
                   b = Integer.parseInt(s2);
                   System.out.println(a+b);
               }
               test--;
           }
       }
    }
}
