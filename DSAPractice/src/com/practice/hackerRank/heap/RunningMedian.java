package com.practice.hackerRank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        while (test > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] sArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            double[] ans = medians(arr);
            for (double d : ans)
                System.out.println(d);
            test--;
        }
    }

    private static double[] medians(int[] arr) {
        double[] ans = new double[arr.length];
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
            if(i % 2 != 0){
                int a = l.peek();
                int b = r.peek();
                ans[i] = (double)(a+b)/2;
            }
            else
                ans[i] = l.peek();
        }
        return ans;

    }
}
