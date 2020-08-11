package com.practice.codeforces;

import java.util.Scanner;

public class InSearchOfAnEasyProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int flag = 0;
        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            if (num == 1)
                flag = 1;
        }
        if (flag == 1)
            System.out.print("HARD");
        else
            System.out.print("EASY");
    }
}
