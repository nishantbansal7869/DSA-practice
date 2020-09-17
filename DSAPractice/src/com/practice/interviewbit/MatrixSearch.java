package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class MatrixSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            for (int j = 0; j < m; j++)
                list1.add(j, sc.nextInt());
            list.add(i, list1);
        }
        int b = sc.nextInt();
        int ans = matrixSearch(list, b);
        System.out.println(ans);
    }

    private static int matrixSearch(ArrayList<ArrayList<Integer>> list, int b) {
        int n = list.size();
        int m = list.get(0).size();
        int low = 0;
        int high = n*m-1;
        while (low <= high){
            int mid = (low + high)/2;
            int num = list.get(mid/m).get(mid%m);
            if (num == b)
                return 1;
            if (num > b)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return 0;
    }
}
