package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RemoveDuplicatesTwo {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> a = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replace("," , " ");
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++)
            a.add(Integer.parseInt(arr[i]));
        int newSize = removeDup(a);
        System.out.println(newSize);
    }

    private static int removeDup(ArrayList<Integer> a) {
        int i = 0;
        int count = 1;
        for (int j = 1; j < a.size(); j++){
            if (a.get(i).equals(a.get(j)) && count < 2) {
                a.set(++i, a.get(j));
                count++;
            }
            else if (a.get(i).equals(a.get(j)))
                count++;
            else{
                a.set(++i,a.get(j));
                count = 1;
            }
        }
        while (a.size() > i+1)
            a.remove(a.size()-1);
        return a.size();
    }
}
