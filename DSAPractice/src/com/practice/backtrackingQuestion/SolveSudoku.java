package com.practice.backtrackingQuestion;

import java.util.ArrayList;

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'3','.','.','.','.','.','.','.','.'},
                {'5','2','9','1','3','4','7','6','8'},
                {'4','8','7','6','2','9','5','3','1'},
                {'2','6','3','4','1','5','9','8','7'},
                {'9','7','4','8','6','3','1','2','5'},
                {'8','5','1','7','9','2','6','4','3'},
                {'1','3','8','9','4','7','2','5','6'},
                {'6','9','2','3','5','1','8','7','4'},
                {'7','4','5','2','8','6','3','1','9'},
        };
        if(solveSudoku(arr,arr.length)){
            for(int i = 0; i < arr.length; i++){
                System.out.print("[");
                for(int j = 0; j < arr.length; j++){
                    System.out.print("\""+arr[i][j]+"\""+",");
                }
                System.out.println("]");
            }
        }
    }
    public static boolean solveSudoku(char[][] arr, int length){
        int i;
        int j  =0;
        int flag = 0;
        for(i = 0;i < length; i++){
            for(j = 0; j < length; j++){
                if(arr[i][j] == '.'){
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
            char num1 = (char)('1'+n-1);
            if(isSafe(arr,num1,i,j)){
                arr[i][j] = num1;
                if(solveSudoku(arr,length))
                    return true;
                arr[i][j] = '.';
            }
        }
        return false;
    }
    public static boolean  isSafe(char[][] board, char num, int row, int col){
        int n = board.length;
        for(int i = 0; i < n; i++){
            char c1 = board[row][i];
            if(c1 == num)
            {
                return false;
            }
        }
        for(int i = 0; i < n; i++){
            char c1 = board[i][col];
            if(c1 == num)
            {
                return false;
            }
        }
        int s = (int)Math.sqrt(n);
        int rs = row-row%s;
        int cs = col-col%s;
        for(int i = rs; i < rs+s;i++){
            for(int j = cs; j < cs+s;j++){
                char c1 = board[i][j];
                if(c1==num){
                    return false;
                }
            }
        }
        return true;
    }
}
