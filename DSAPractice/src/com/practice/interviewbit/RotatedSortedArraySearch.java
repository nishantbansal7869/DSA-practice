package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            list.add(i, Integer.parseInt(arr[i]));
        }
        int b = Integer.parseInt(br.readLine());
        int ans = searchBinary(list, b);
        System.out.println(ans);
    }

    private static int searchBinary(ArrayList<Integer> list, int b) {
       int d = findRotatedPoint(list);
       int low = 0;
       int high = d-1;
       if (b < list.get(0)){
           low = d;
           high = list.size()-1;
       }
       while (low <= high){
           int mid = (low+high)/2;
           if (list.get(mid) == b)
               return mid;
           if (list.get(mid) > b)
               high = mid-1;
           else
               low = mid+1;
       }
       return -1;
    }

    private static int findRotatedPoint(ArrayList<Integer> list) {
        int x = 0;
        int low = 0;
        int high = list.size() - 1;
        while (low <= high){
            int mid = (low + high)/2;
            if (list.get(mid) < list.get(0))
                high = mid-1;
            else {
                x = mid;
                low = mid + 1;
            }
        }
        return x+1;
    }
}
