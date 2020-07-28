package com.practice.matrix;

public class MakeMatrixBeautiful {
    public static void main(String[] args) {
        int[] mat[] = new int[][]{{1,2,3,4},{6,5,4,2},{3,2,1,5},{5,4,3,2}};
        int n = mat.length;
        int count = findMinOperation(mat,n);
        System.out.print(count);
    }
    static int findMinOperation(int[][] mat, int n){
        int count = 0;
        int maxSum = Integer.MIN_VALUE;
        int sumRow = 0;
        int sumCol = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sumRow += mat[i][j];
                sumCol += mat[j][i];
            }
            int sum = Math.max(sumCol,sumRow);
            maxSum = Math.max(sum,maxSum);
            sumCol = 0;
            sumRow = 0;
        }
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                sumRow += mat[0][j];
                sumCol += mat[j][i];
            }
            int sum = Math.max(sumCol,sumRow);
            count += maxSum-sum;
            sumCol = 0;
            sumRow = 0;
        }
        return count;
    }
}
