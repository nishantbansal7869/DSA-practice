package com.practice.hackerRank;

import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class FrequencySort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] sArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            ArrayList<Pair<Integer, Integer>> ans = frequencySort(arr);
            for (Pair<Integer, Integer> p : ans) {
                int f = p.getValue();
                while (f > 0) {
                    bw.write(p.getKey() + " ");
                    f--;
                }
            }
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static ArrayList<Pair<Integer, Integer>> frequencySort(int[] arr) {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>(arr.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr){
            if (map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }
        Set<Integer> set = map.keySet();
        for (int i : set){
            list.add(new Pair<>(i, map.get(i)));
        }
        list.sort(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                if (o1.getValue() - o2.getValue() == 0)
                    return o1.getKey() - o2.getKey();
                return o1.getValue() - o2.getValue();
            }
        });
        return list;
    }
}
