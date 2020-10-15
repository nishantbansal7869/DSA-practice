package com.practice.hackerRank.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class QHeap1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        while (q > 0){
            String[] arr = br.readLine().split(" ");
            if (Integer.parseInt(arr[0]) == 1)
                p1.add(Integer.parseInt(arr[1]));
            else if (Integer.parseInt(arr[0]) == 2)
                p1.remove(Integer.parseInt(arr[1]));
            else
                System.out.println(p1.peek());
            q--;
        }
    }
}
