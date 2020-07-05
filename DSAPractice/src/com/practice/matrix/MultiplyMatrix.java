package com.practice.matrix;

public class MultiplyMatrix {
    public static void main(String[] args) {
        int[] arr1[]=  new int[][]{{4,8},{0,2},{1,6}};
        int[] arr2[] = new int[][]{{5,2}};
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int n2 = arr2.length;
        int m2 = arr2[0].length;
        if(m1 != n2){
            System.out.print(-1);
            return;
        }
        int mul = 0;
        int sum = 0;
        int[] arr3[] = new int[n1][m2];
        for(int k = 0; k < m2; k++){
            for(int i = 0; i < n1; i++){
                for (int j = 0; j < m1; j++){
                  mul = arr1[i][j] * arr2[j][k];
                  sum += mul;
                }
                arr3[i][k] = sum;
                sum = 0;
            }
        }
        for(int i = 0; i < n1; i++){
            for (int j = 0; j < m2; j++){
                System.out.print(arr3[i][j] + " ");
            }
        }
    }
}
