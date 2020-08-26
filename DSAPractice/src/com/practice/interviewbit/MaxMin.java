package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i < n; i++)
            list.add(i, sc.nextInt());
        int sum = maxMinSum(list);
        System.out.println(sum);
    }

    private static int maxMinSum(ArrayList<Integer> list) {
        int m = (int)1e9+7;
        Collections.sort(list);
        int sum = ((list.get(0)%m)+(list.get(list.size()-1)%m))%m;
        return sum;
    }
}
