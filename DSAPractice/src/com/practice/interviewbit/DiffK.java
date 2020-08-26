package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class DiffK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int exist = diffK(list, b);
        System.out.println(exist);
    }

    private static int diffK(ArrayList<Integer> list, int b) {
        int p1 = 0;
        int p2 = list.size()-1;
        while (p1 < p2){
            if (list.get(p2) - list.get(p1) == b)
                return 1;
            else if (list.get(p2) - list.get(p1) < b)
                return 0;
            else
                p2--;
        }
        return 1;
    }
}
