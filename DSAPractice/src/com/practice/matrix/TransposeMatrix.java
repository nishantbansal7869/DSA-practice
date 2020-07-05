package com.practice.matrix;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[] multi[] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int transpose[][] = new int[multi.length][multi.length];
        int n = multi.length;
        for(int i = 0; i < n ; i ++){
            for(int j = i+1; j < n; j++){
                swap(multi, i , j);
            }
        }
        for(int i = 0; i < n ; i ++){
            for(int j = 0; j < n; j++){
               System.out.print(multi[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void swap(int[][] multi, int i, int j){
        int temp = multi[i][j];
        multi[i][j] = multi[j][i];
        multi[j][i] = temp;
    }
}
