package com.practice.matrix;

public class SumOfUpperAndLowerTriangle {
    public static void main(String[] args) {
        int[] matrix[] = new int[][]{{6,5,4},{1,2,5},{7,9,7}};
        int n = matrix.length;
        sum(matrix,n);
    }
    static void sum(int[][] matrix, int n){
        int lowerSum = 0;
        int upperSum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == i){
                    lowerSum += matrix[i][j];
                    upperSum += matrix[i][j];
                }
                else if (j < i){
                    lowerSum += matrix[i][j];
                }
                else
                    upperSum += matrix[i][j];
            }
        }
        System.out.print(upperSum + " " + lowerSum);
    }
}
