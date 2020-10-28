package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class PathInAMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] ar = br.readLine().split(" ");
            int n = Integer.parseInt(ar[0]);
            int m = Integer.parseInt(ar[1]);
            int b = Integer.parseInt(ar[2]);
            int[][] blockedCells = new int[b][2];
            int[][] matrix = new int[n][m];
            for (int i = 0; i < b; i++)
            {
                String[] sArr = br.readLine().split(" ");
                blockedCells[i][0] = Integer.parseInt(sArr[0]);
                blockedCells[i][1] = Integer.parseInt(sArr[1]);
            }
            implementBaseCond(matrix, blockedCells, n, m);
            int ans = findAllPaths(matrix, n, m);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int findAllPaths(int[][] matrix, int n, int m) {
        int mod =  (int)1e9+7;
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][j] == -1)
                    matrix[i][j] = 0;
                else {
                    matrix[i][j] = (int)((((long)matrix[i-1][j] + matrix[i][j-1])%mod + matrix[i-1][j-1])%mod);
                }
            }
        }
        return matrix[n-1][m-1];
    }

    private static void implementBaseCond(int[][] matrix, int[][] blockedCells, int n, int m) {
        for (int[] blockedCell : blockedCells) {
            int k = blockedCell[0];
            int l = blockedCell[1];
            matrix[k][l] = -1;
        }
        if (matrix[0][0] == -1){
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }
        else {
            int i;
            for (i = 0; i < n; i++) {
                if (matrix[i][0] != -1)
                    matrix[i][0] = 1;
                else
                    break;
            }
            for (; i < n; i++)
                matrix[i][0] = 0;

            int j;
            for (j = 0; j < m; j++) {
                if (matrix[0][j] != -1)
                    matrix[0][j] = 1;
                else
                    break;
            }
            for (; j < m; j++)
                matrix[0][j] = 0;
        }
    }
}
