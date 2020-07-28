package com.practice.hackerRank;

import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int weight = sc.nextInt();
        String s = isEven(weight);
        System.out.println(s);
    }
    static String isEven(int weight){
        if (weight <= 3){
            return "NO";
        }
        if(weight % 2 == 0)
            return "YES";
        return "NO";
    }
}
