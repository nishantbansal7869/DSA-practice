package com.practice.hackerRank.heap;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MAxPairSum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            String[] s2 = br.readLine().split(" ");
            int[] arr = new int[n];
            int[] arr1 = new int[n];
            String[] s3 = br.readLine().split(" ");
            for (int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(s2[i]);
                arr1[i] = Integer.parseInt(s3[i]);
            }
            ArrayList<Integer> ans = maxPairSum(arr, arr1, k);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static ArrayList<Integer> maxPairSum(int[] arr, int[] arr1, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (!p.isEmpty() && p.size() == k)
                {
                    if (p.peek() < arr[i] + arr1[j]) {
                        p.poll();
                        p.add(arr[i] + arr1[j]);
                    }
                }
                else
                    p.add(arr[i] + arr1[j]);
            }
        }
        while (!p.isEmpty())
            list.add(p.poll());
        Collections.reverse(list);
        return list;
    }
}
