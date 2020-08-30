package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class DiffK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int k = sc.nextInt();
        int ans = diffK(list, k);
        System.out.println(ans);
    }

    private static int diffK(ArrayList<Integer> list, int k) {
        if (list.size() == 1)
            return 0;
        int i = 0;
        int j = 1;
        while (i < list.size() && j < list.size()){
            if (i == list.size()-1 && j == list.size()-1)
                break;
            if (i == j)
            j++;
            if (list.get(j) - list.get(i) == k)
                return 1;
            if (list.get(j) - list.get(i) < k )
                j++;
            else
                i++;
        }
        return 0;
    }
}
