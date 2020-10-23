package com.practice.hackerRank.heap;

import java.io.*;
import java.util.*;
import javafx.util.Pair;

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
            for (int i : ans)
                bw.write(i+" ");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static ArrayList<Integer> maxPairSum(int[] arr, int[] arr1, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr1);
        int n = arr.length-1;
        PriorityQueue<Pairs> p = new PriorityQueue<>(Collections.reverseOrder(new Compare()));
        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        p.add(new Pairs(arr[n]+arr1[n], n, n));
        set.add(new Pair<>(n, n));
        while (!p.isEmpty() && list.size() != k){
            Pairs temp = p.poll();
            list.add(temp.sum);
            if (temp.i-1 >= 0) {
                Pairs p1 = new Pairs(arr[temp.i - 1] + arr1[temp.j], temp.i - 1, temp.j);
                if (!set.contains(new Pair<>(temp.i-1, temp.j))) {
                    set.add(new Pair<>(temp.i-1, temp.j));
                    p.add(p1);
                }
            }
            if (temp.j-1 >= 0) {
                Pairs p2 = new Pairs(arr[temp.i] + arr1[temp.j - 1], temp.i, temp.j - 1);
                if (!set.contains(new Pair<>(temp.i, temp.j-1))) {
                    set.add(new Pair<>(temp.i, temp.j-1));
                    p.add(p2);
                }
            }
        }
        return list;
    }
}
class Pairs{
    int sum;
    int i;
    int j;
    Pairs(int sum, int i, int j){
        this.sum = sum;
        this.i = i;
        this.j = j;
    }
}

class Compare implements Comparator<Pairs>{

    @Override
    public int compare(Pairs o1, Pairs o2) {
        return o1.sum - o2.sum;
    }
}