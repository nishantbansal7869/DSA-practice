package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class CollectApples {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++){
                String[] sArr = br.readLine().split(" ");
                for (int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(sArr[j]);
                }
            }
            int ans = findPath(matrix, n, m);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int findPath(int[][] matrix, int n, int m) {
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                matrix[i][j] = Math.max(matrix[i-1][j]+matrix[i][j], matrix[i][j-1]+matrix[i][j]);
            }
        }
        return matrix[n-1][m-1] + matrix[0][0];
    }
}
