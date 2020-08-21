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
        int b = 2;
        int newSize = removeElement(a, b);
        System.out.println(newSize);
    }

    private static int removeElement(ArrayList<Integer> a, int b) {
       int i = 0;
       for (int j = 1; j < a.size(); j++){
           if (!a.get(j).equals(b)){
               while (i < j){
                   if (a.get(i).equals(b)) {
                       a.set(i, a.get(j));
                       i++;
                       break;
                   }
                   i++;
               }
           }
       }
       while (a.size() > i+1)
           a.remove(a.size()-1);
       System.out.println(a);
       return a.size();
    }
}
