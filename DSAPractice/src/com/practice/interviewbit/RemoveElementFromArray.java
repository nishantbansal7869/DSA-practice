package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class RemoveElementFromArray {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("," , " ");
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++)
            a.add(Integer.parseInt(arr[i]));
        int b = Integer.parseInt(br.readLine());
        int newSize = removeElement(a, b);
        System.out.println(newSize);
    }

    private static int removeElement(ArrayList<Integer> a, int b) {
      int p1 = 0;
      int p2 = 1;
      while (true){
          while (p1 < a.size() && a.get(p1) != b)
              p1++;
          if (p2 < p1)
              p2 = p1;
          while (p2 < a.size() && a.get(p2) == b)
              p2++;
          if (p1 == a.size() || p2 == a.size())
              break;
          Collections.swap(a, p1, p2);
      }
      while (a.size() > p1)
          a.remove(a.size()-1);
      return a.size();
    }
}
