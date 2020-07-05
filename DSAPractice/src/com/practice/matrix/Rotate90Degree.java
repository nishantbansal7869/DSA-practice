package com.practice.matrix;

public class Rotate90Degree {
    public static void main(String[] args) {
        int[] multi[] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int n = multi.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                swap(multi,i,j);
            }
        }
        int i = 0;
        int k = n - 1;
        while (i < k){
            for(int j = 0; j < n; j++){
                swap(multi,i,j,k);
            }
            i++;
            k--;
        }
        for( i = 0; i < n; i++){
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
    static void swap(int[][] multi, int i, int j, int k){
        int temp = multi[i][j];
        multi[i][j] = multi[k][j];
        multi[k][j] = temp;
    }
}
