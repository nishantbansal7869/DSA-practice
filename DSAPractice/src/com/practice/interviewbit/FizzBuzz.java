package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> res = fizzBuzz(n);
        System.out.println(res);
    }

    private static ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<>();
        int a = 3;
        int b = 5;
        for (int i = 1; i <= n; i++){
            StringBuilder s = new StringBuilder();
            if (i == a){
                a = a+3;
                s.append("Fizz");
            }
            if (i == b){
                b += 5;
                s.append("Buzz");
            }
            else if (i != a-3 && i != b-5)
                s.append(i);
            res.add(s.toString());
        }
        return res;
    }
}
