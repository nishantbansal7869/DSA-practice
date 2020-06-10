package com.practice.backtrackingQuestion;

public class SolveSudoku {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
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
            if(isSafe(arr,i,j,n)){
                arr[i][j] = (char)(n+48);
                if(solveSudoku(arr,length))
                    return true;
                arr[i][j] = '.';
            }
        }
        return false;
    }
    public static boolean isSafe(char[][] arr, int i, int j, int n){
        for(int k = 0; k < arr.length; k++){
            if(arr[k][j] == (char)(n+48) || arr[i][k] == (char)(n+48))
                return false;
        }
        int s = (int)Math.sqrt(arr.length);
        int rs = i-(i%s);
        int cs = j-(j%s);
        for(int l = 0; i < rs; i++){
            for(int k = 0; j < cs; j++){
                if(arr[l+rs][k+cs] == (char)(n+48))
                    return false;
            }
        }
        return true;
    }
}
