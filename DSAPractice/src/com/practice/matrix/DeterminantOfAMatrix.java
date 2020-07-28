package com.practice.matrix;

public class DeterminantOfAMatrix {
    static final int N = 7;
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,10,9}};
        int n = matrix.length;
        int d = determinant(matrix, n);
        System.out.print(d);
    }
    static int determinant(int[][] matrix, int n){
        int D = 0;
        if( n == 1)
            return matrix[0][0];
        int[][] temp = new int[N][N];
        int sign = 1;
        for(int f = 0; f < n; f++){
            getCoFactor(matrix,n,0,f,temp);
            D += sign * matrix[0][f] * determinant(temp,n-1);
            sign = -sign;
        }
    return D;
    }

    static void getCoFactor(int[][] matix, int n, int p, int q, int[][] temp){
        int i = 0;
         int j = 0;
         for(int row = 0; row < n; row++){
             for(int col = 0; col < n; col++){
                 if(row != p && col != q){
                     temp[i][j++] = matix[row][col];
                     if(j == n-1){
                         j = 0;
                         i++;
                     }
                 }
             }
         }
    }
}
