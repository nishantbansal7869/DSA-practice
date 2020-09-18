package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CountingSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            list.add(i, Integer.parseInt(arr[i]));
        int b = Integer.parseInt(br.readLine());
        int ans = countSubarray(list, b);
        System.out.println(ans);
    }

    private static int countSubarray(ArrayList<Integer> list, int b) {
      int count = 0;
      int sum = 0;
      int p1 = 0;
      for (int i = 0; i < list.size(); i++){
          sum += list.get(i);
          while (sum >= b && p1 <= i)
              sum -= list.get(p1++);
          count += i - p1 + 1;
      }
      return count;
    }
}
