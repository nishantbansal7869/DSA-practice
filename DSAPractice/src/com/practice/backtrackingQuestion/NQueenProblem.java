package com.practice.backtrackingQuestion;

public class NQueenProblem {
    public static void main(String[] args) {
        int n = 4;
        int board[][] = new int[n][n];
        if(nQueenPlaced(0,n,board)){
            System.out.println("true");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        }
        else
            System.out.println("false");
    }
    public static boolean nQueenPlaced(int col,int n, int board[][]){
        if(col == n)
            return true;
        for(int i = 0; i < n; i++){
            if(isSafe(i,col,board,n)){
                board[i][col] = 1;
                if(nQueenPlaced(col+1,n,board))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }
    public static boolean isSafe(int row, int col, int board[][],int n){
        for(int i = 0; i < col; i++){
            if(board[row][i] == 1)
                return false;
        }
        for(int i = row, j = col; i >= 0 && j >= 0;i--,j--){
            if(board[i][j] == 1)
                return false;
        }
        for(int i = row, j = col; i < n && j >= 0; i++,j--){
            if(board[i][j] == 1)
                return false;
        }
        return true;
    }
}
