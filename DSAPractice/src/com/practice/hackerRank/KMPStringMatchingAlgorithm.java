package com.practice.hackerRank;

import java.io.*;

public class KMPStringMatchingAlgorithm {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] arr = br.readLine().split(" ");
            String a = arr[0];
            String b = arr[1];
            int count = stringMatch(a, b);
            bw.write(count + "");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int stringMatch(String a, String b) {
        int[] table = computeTable(a);
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < b.length()){
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }
            else if (i > 0)
                i = table[i];
            else
                j++;

            if (i == a.length())
            {
                count++;
                i = table[i];
            }
        }
        return count;
    }

    private static int[] computeTable(String a) {
        int[] table = new int[a.length() + 1];
        table[0] = table[1] = 0;
        for (int i = 2; i <= a.length(); i++){
            int j = table[i-1];
            for (;;){
                if (a.charAt(j) == a.charAt(i-1)){
                    table[i] = j+1;
                    break;
                }
                if (j == 0){
                    table[i] = 0;
                    break;
                }
                j = table[j];
            }
        }
        return table;
    }
}
