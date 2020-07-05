package com.practice.sorting;

import java.util.Arrays;

public class MeetingTheMaximumGuest {
    public static void main(String[] args) {
        int arrival[] = new int[]{900,940,950,1100,1500,1800};
        int depart[] = new int[]{910,1200,1120,1130,1900,2000};
        System.out.println(maxGuest(arrival,depart,arrival.length,depart.length));
    }
    private static int maxGuest(int[] arrival, int[] depart, int n, int m){
        Arrays.sort(arrival);
        Arrays.sort(depart);
        int i = 1;
        int j = 0;
        int cur = 1;
        int res =  1;
        while (i < n && j < m){
            if(arrival[i] <= depart[j]){
                cur++;
                i++;
            }
            else {
                cur--;
                j++;
            }
            res = Math.max(res,cur);
        }
        return res;
    }
}
