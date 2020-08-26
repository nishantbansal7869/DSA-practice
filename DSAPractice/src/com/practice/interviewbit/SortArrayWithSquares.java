package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;
//-963 -894 -810 -712 -684 -630 -352 -277 -271 -243 -222 -141 -58 35 40 264 446 529 741 805 842 890
public class SortArrayWithSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        ArrayList<Integer> res = sortWithSquare(list);
        System.out.println(res);
    }
    static int j = 0;
    private static ArrayList<Integer> sortWithSquare(ArrayList<Integer> list) {
        ArrayList<Integer> negativeNumList = new ArrayList<>();
        while (j < list.size()){
            if (list.get(j) < 0){
                negativeNumList.add(list.get(j));
                j++;
            }
            else
                break;
        }
        for (int i = 0; i < negativeNumList.size(); i++){
            negativeNumList.set(i, (int)Math.pow(negativeNumList.get(i), 2));
        }
        for (int i = j; i < list.size(); i++)
            list.set(i, (int)Math.pow(list.get(i),2));
        ArrayList<Integer> res = merge(negativeNumList, list);
        return res;
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> negativeNumList, ArrayList<Integer> list) {
        ArrayList<Integer> res = new ArrayList<>();
        int p1 = negativeNumList.size()-1;
        int p2 = j;
        while (p1 >= 0 && p2 < list.size()){
            if (negativeNumList.get(p1) > list.get(p2)){
                res.add(list.get(p2));
                p2++;
            }
            else {
                res.add(negativeNumList.get(p1));
                p1--;
            }
        }
        while (p1 >= 0) {
            res.add(negativeNumList.get(p1));
            p1--;
        }
        while (p2 < list.size()){
            res.add(list.get(p2));
            p2++;
        }
        return res;
    }
}
