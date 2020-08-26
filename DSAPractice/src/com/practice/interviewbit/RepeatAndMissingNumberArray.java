package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RepeatAndMissingNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        ArrayList<Integer> res = findRepeatAndMissing(list);
        System.out.println(res);
    }

    private static ArrayList<Integer> findRepeatAndMissing(ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>(2);
        int xorList = 0;
        int xorN = 0;
        for (int i : list)
            xorList = xorList ^ i;
        for (int i = 1; i <= list.size(); i++)
            xorN = xorN ^ i;
        int temp = xorList ^ xorN;
        int bit = findFirstSetBit(temp);
        int A = 0;
        int B = 0;
        for (int i : list){
            if((i&(1<<bit)) > 0)
                A = A ^ i;
            else
                B = B ^ i;
        }
        for (int i = 1; i <= list.size(); i++){
            if ((i&(1<<bit)) > 0)
                A = A ^ i;
            else
                B = B ^ i;
        }
        if (list.contains(A)){
            res.add(A);
            res.add(B);
        }
        else {
            res.add(B);
            res.add(A);
        }

        return res;
    }

    private static int findFirstSetBit(int temp) {
        for (int i = 0; i < 31; i++)
        {
            if((temp&(1<<i))>0)
                return i;
        }
        return 0;
    }
}
