package com.practice.matrix;

public class SumOfMatrix {
    public static void main(String[] args) {
        int[] arr1[] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[] arr2[] = new int[][]{{1,2,3},{2,4,5},{3,5,6}};
        int n1 = arr1.length;
        int m1 = arr1[0].length;
        int n2 = arr2.length;
        int m2 = arr2[0].length;
        if(n1 != n2 && m1 != m2){
            System.out.print(-1);
        }
        else {
            for(int i = 0; i < n1; i++){
                for(int j = 0; j < m1; j++){
                    arr1[i][j] = arr1[i][j] + arr2[i][j];
                }
            }
            for(int i = 0; i < n1; i++){
                for(int j = 0; j < m1; j++){
                    System.out.print(arr1[i][j] + " ");
                }
            }
        }
        }
    }


