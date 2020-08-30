package com.practice.hackerRank;

import java.util.*;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] brr = new int[m];
        for (int i = 0; i < m; i++)
            brr[i] = sc.nextInt();
        int[] ans = findMissingNumber(arr, brr);
        Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
    }

    private static int[] findMissingNumber(int[] arr, int[] brr) {
       HashMap<Integer, Integer> mapArr = new HashMap<>();
       HashMap<Integer, Integer> mapBrr = new HashMap<>();
       HashSet<Integer> set = new HashSet<>();
       for (int i : arr){
           if(mapArr.containsKey(i))
               mapArr.put(i, mapArr.get(i)+1);
           else
               mapArr.put(i, 1);
       }
       for (int i : brr){
           if (mapBrr.containsKey(i))
               mapBrr.put(i, mapBrr.get(i)+1);
           else
               mapBrr.put(i, 1);
           set.add(i);
       }
       ArrayList<Integer> temp = new ArrayList<>();
       for (int i : set){
           int count1 = 0;
           if (mapArr.containsKey(i))
               count1 = mapArr.get(i);
           int count2 = mapBrr.get(i);
           if (count1 == 0)
               temp.add(i);
           else if (count1 < count2)
               temp.add(i);
       }

       int[] ans = new int[temp.size()];
       int j = 0;
       for (int i : temp)
           ans[j++] = i;
       return ans;
    }
}
