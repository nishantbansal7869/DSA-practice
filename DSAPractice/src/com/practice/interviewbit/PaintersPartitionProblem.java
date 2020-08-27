package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int a = sc.nextInt();
        int b = sc.nextInt();
        int ans = partition(a, b, list);
        System.out.println(ans);
    }

    private static int partition( int a, int b, ArrayList<Integer> list) {
        int m = 10000003;
        long ans = 0;
        long low = 0;
        long high = list.stream().mapToInt(i -> i).sum();
        while (low <= high){
            long mid = (low+high)/2;
            if (valid(list, a, mid)){
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        long res = ((ans%m)*(b%m))%m;
        return (int)res;
    }

    private static boolean valid(ArrayList<Integer> list, int a, long mid) {
        long curSum = 0;
        int i = 0;
        while (i < list.size()){
            if (list.get(i) > mid)
                return false;
            curSum += list.get(i);
            if (curSum > mid){
                curSum = list.get(i);
                a--;
                if (a == 0)
                    break;
            }
            i++;
        }
        if (a == 0 && i != list.size())
            return false;
        return true;
    }
}
