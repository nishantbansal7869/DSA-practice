package com.practice.hackerRank.heap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class AnyTimeMedian {
   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] sArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            medians(arr);
            test--;
            bw.newLine();
        }
        bw.flush();
    }

    private static void medians(int[] arr)throws IOException {
        PriorityQueue<Integer> l = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> r = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            if (l.isEmpty() || l.peek() > arr[i])
                l.add(arr[i]);
            else
                r.add(arr[i]);
            int sizeL = l.size();
            int sizeR = r.size();
            if (sizeR > sizeL)
                l.add(r.poll());
            else if (sizeL - sizeR > 1)
                r.add(l.poll());
            bw.write(l.peek()+" ");
        }
    }
}
