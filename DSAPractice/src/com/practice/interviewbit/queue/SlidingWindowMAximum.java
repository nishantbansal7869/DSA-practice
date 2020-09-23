package com.practice.interviewbit.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMAximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int[] arr = new int[sArr.length];
        int b = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(sArr[i]);
        int[] ans = slidingWindowMax(arr, b);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] slidingWindowMax(int[] arr, int b) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[arr.length-b+1];
        int idx = 0;
        for (int i = 0; i < arr.length; i++){
            while (!deque.isEmpty() && arr[deque.getLast()] <= arr[i])
                deque.removeLast();
            deque.addLast(i);
            if (deque.getFirst() == i-b)
                deque.removeFirst();
            if (i >= b-1)
                ans[idx++] = arr[deque.getFirst()];
        }
        return ans;
    }
}
