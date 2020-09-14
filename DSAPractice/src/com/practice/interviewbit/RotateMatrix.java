package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            mat.add(a);
        }


        rotate(mat);
    }

    public static void rotate(ArrayList<ArrayList<Integer>> A) {
        transpose(A);
        for (int i = 0; i < A.size(); i++){
            Collections.reverse(A.get(i));
        }
    }
   static void transpose(ArrayList<ArrayList<Integer>> arr) {
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.get(0).size(); j++) {
                int temp = arr.get(j).get(i);
                arr.get(j).set(i,arr.get(i).get(j));
                arr.get(i).set(j,temp);
            }
        }
    }
}
