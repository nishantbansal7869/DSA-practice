package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;


public class HammingDistance {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int dist = findHammingDistance(list);
        System.out.println(dist);
    }

    private static int findHammingDistance(ArrayList<Integer> list) {
        int m = (int)1e9+7;
        long ans = 0;
        for (int i = 0; i < 31; i++){
            int set = 0;
            for (int j : list){
                if (checkBit(j,i) > 0){
                    set++;
                }
            }
            ans += ((long)set*(list.size()-set))%m;
        }
        return (int)(ans*2%m);
    }

    private static int checkBit(int j, int i) {
        return j&(1<<i);
    }
}
