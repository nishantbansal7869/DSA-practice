package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class AddOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            arr.add(i,sc.nextInt());
        ArrayList<Integer> res = addOne(arr);
        System.out.println(res);
    }

    private static ArrayList<Integer> addOne(ArrayList<Integer> arr) {
        if (arr.size() == 1 && arr.get(0) == 0){
            arr.set(0, 1);
            return arr;
        }
        int k = 0;
        while (k < arr.size()){
            if (arr.get(k) == 0)
                arr.remove(k);
            else
                break;
        }
        for (int i = arr.size()-1; i >= 0; i--){
            if (arr.get(i) == 9){
                arr.set(i,0);
                if (i == 0)
                {
                    arr.add(i, 1);
                }
            }
            else{
                arr.set(i, arr.get(i)+1);
                break;
            }
        }
        return arr;
    }
}
