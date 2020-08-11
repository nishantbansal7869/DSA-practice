package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayingWithMatches {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test =0 ;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        for (int i = 0; i < test; i++){
            String val = br.readLine();
            if (val != null && !val.isEmpty())
            {
                String[] arr = val.split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int count = countMatches(a, b);
                System.out.println(count);
            }
        }
    }

    private static int countMatches(int a, int b) {
        int arr[] = {6,2,5,5,4,5,6,3,7,6};
        int sum = a+b;
        int count = 0;
        while (sum > 0){
            int n = sum % 10;
            count += arr[n];
            sum /= 10;
        }
        return count;
    }
}
