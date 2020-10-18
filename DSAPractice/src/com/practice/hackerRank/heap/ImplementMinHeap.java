package com.practice.hackerRank.heap;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ImplementMinHeap {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap();
        while (test > 0){
            String s = br.readLine();
            implement(s, minHeap);
            test--;
        }
        bw.flush();
    }

    private static void implement(String s, MinHeap minHeap)throws IOException {
        String[] arr = s.split(" ");
        if (arr[0].equals("insert"))
            minHeap.insert(Integer.parseInt(arr[1]));
        else if(arr[0].equals("getMin")) {
            bw.write(minHeap.getMin());
            bw.newLine();
        }
        else
            minHeap.delMin();
    }
}

class MinHeap{
    ArrayList<Integer> list;
    int idx;
    MinHeap(){
        list = new ArrayList<>();
        idx = -1;
    }

    void insert(int val){
        idx++;
        list.add(val);
        int c = idx;
        int temp = idx;
        while (c != 0){
            if (c == 1)
                c = 0;
            else
                c = (c-1)/2;
            if (list.get(temp) < list.get(c))
                Collections.swap(list, temp, c);
            temp = c;
        }
    }

    String getMin(){
        if (idx != -1)
            return Integer.toString(list.get(0));
        return "Empty";
    }

    void delMin(){
        if (idx == -1)
            return;
        list.set(0, list.get(idx));
        list.remove(idx);
        idx--;
        int p = 0;
        while (2*p+1 <= idx){
            int child1 = 2*p+1;
            int child2 = 2*p+2;
            int idx = child1;
            if (child2 <= idx && list.get(child2) < list.get(child1))
                idx = child2;
            if (list.get(0) > list.get(idx)){
                Collections.swap(list, p, idx);
            }
            else
                break;
            p = idx;
        }
    }
}