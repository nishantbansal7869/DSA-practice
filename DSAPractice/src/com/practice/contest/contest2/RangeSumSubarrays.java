package com.practice.contest.contest2;

import java.io.*;

public class RangeSumSubarrays {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test >0){
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int a = Integer.parseInt(arr[1]);
            int b = Integer.parseInt(arr[2]);
            int[] array = new int[n];
            String[] sArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                array[i] = Integer.parseInt(sArr[i]);
             countSubArray(array,a ,b);
            bw.write(count + " ");
            bw.newLine();
            test--;
            count=0;
        }
        bw.flush();
    }
    static int count = 0;
    private static void countSubArray(int[] arr, int a, int b) {
        for (int i = 0; i < arr.length; i++){
            int sum = arr[i];
            if (sum >= a && sum <= b)
                count++;
            for (int j = i+1; j < arr.length; j++)
            {
                sum += arr[j];
                if (sum >= a && sum <= b)
                    count++;
            }
        }
    }
}
