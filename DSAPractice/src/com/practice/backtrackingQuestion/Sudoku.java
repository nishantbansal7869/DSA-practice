package com.practice.backtrackingQuestion;

public class Sudoku {
    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {1,0,3,0},
                {0,0,2,1},
                {0,1,0,2},
                {2,4,0,0}
        };
        if(solveSudoku(arr,arr.length)){
            for(int i = 0 ; i < arr.length; i++){
                for(int j = 0; j < arr.length; j++){
                    System.out.print(arr[i][j] + " ");}
                System.out.println();}
        }
    }
    public static boolean solveSudoku(int arr[][], int length){
        int i = 0;
        int j = 0;
        int flag = 0;
        for( i = 0; i< length; i++){
            for( j = 0; j < length; j++){
                if(arr[i][j] == 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1)
                break;
        }
        if(i == length && j == length)
            return true;
        for(int n = 1; n <= length; n++){
            if(isSafe(arr,i,j,n)){
                arr[i][j] = n;
                if(solveSudoku(arr,length))
                    return true;
                arr[i][j] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int arr[][], int i, int j, int n){
        for(int k = 0; k < arr.length;k++){
            if(arr[k][j] == n || arr[i][k] == n)
                return false;
        }
        int s = (int)Math.sqrt(arr.length);
        int rs = i-(i%s);
        int cs = j-(j%s);
        for(int l = 0; l < s; l++)
            for(int m =0; m < s; m++)
                if(arr[l+rs][m+cs] == n)
                    return false;

        return true;
    }
}
