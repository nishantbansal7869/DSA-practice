package com.practice.contest.contest2;

import java.io.*;
import java.util.HashSet;

public class RoboticExhibition {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            String[] a = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(a[i]);
            HashSet<Integer> set = new HashSet<>();
            minPower(arr, 0, 0, set);
            int ans = getMin(set);
            bw.write(ans + "");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int getMin(HashSet<Integer> set) {
        int pow = 1;
        for (int i = 0; i < set.size(); i++)
            if (set.contains(pow))
                pow++;
            else
                break;
        return pow;
    }

    private static void minPower(int[] arr, int sum, int idx, HashSet<Integer> set) {
        if (idx == arr.length) {
            set.add(sum);
            return;
        }
        set.add(sum);
        minPower(arr, sum+arr[idx], idx+1, set);
        minPower(arr, sum, idx+1, set);
    }
}
