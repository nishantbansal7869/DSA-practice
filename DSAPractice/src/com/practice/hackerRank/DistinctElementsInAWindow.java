package com.practice.hackerRank;

import java.io.*;
import java.util.*;

public class DistinctElementsInAWindow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = Integer.parseInt(t);
        while (test > 0){
            String n = br.readLine();
            String[] s2 = n.split(" ");
            int size = Integer.parseInt(s2[0]);
            int k = Integer.parseInt(s2[1]);
            int[] arr = new int[size];
            String s = br.readLine();
            String[] s1 = s.split(" ");
            int i = 0;
            for (String string : s1)
                arr[i++] = Integer.parseInt(string);
            findDistinctElements(arr, k);
            write.newLine();
            test--;
        }
        write.flush();
    }
    static BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void findDistinctElements(int[] arr, int k) throws IOException{
        HashMap<Integer, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < k; i++){
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i], 1);
        }
        write.write(map.size()+" ");
        while (i < arr.length){
            if (map.get(arr[i-k]) == 1)
                map.remove(arr[i-k]);
            else
                map.put(arr[i-k], map.get(arr[i-k])-1);
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i])+1);
            else
                map.put(arr[i],1);
            write.write(map.size()+ " ");
            i++;
        }
    }

}
