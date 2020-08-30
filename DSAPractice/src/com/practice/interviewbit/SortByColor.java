package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class SortByColor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        sortByColors(list);
        System.out.println(list);
    }

    private static void sortByColors(ArrayList<Integer> list) {
        int i = 1;
        while (i < list.size()){
            int key = list.get(i);
            int j = i-1;
            while (j >= 0 && list.get(j) > key){
                list.set(j+1,list.get(j));
                j--;
            }
            list.set(j+1, key);
            i++;
        }
    }
}
