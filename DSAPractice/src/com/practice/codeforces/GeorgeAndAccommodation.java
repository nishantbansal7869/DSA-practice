package com.practice.codeforces;

import java.util.Scanner;

public class GeorgeAndAccommodation {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++){
            int p = sc.nextInt();
            int q = sc.nextInt();
             isEmpty(p, q);
        }
        System.out.print(count);
        count = 0;
    }

    private static void isEmpty(int p, int q) {
        if (q-p >= 2)
            count++;
    }
}
