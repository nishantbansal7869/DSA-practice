package com.practice.backtrackingQuestion;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Sudoku1 {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++){
            ArrayList<Character> list = new ArrayList<>();
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < 9; j++)
                list.add(s[j].charAt(0));
            board.add(list);
        }
        Solution obj = new Solution();
        obj.solveSudoku(board);
    }
}
class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> board) {
        solveSudoku1(board);
        board.forEach(System.out::println);
    }
    public boolean solveSudoku1(ArrayList<ArrayList<Character>> board){
        int row = -1;
        int col = -1;
        int n = board.size();
        int m = board.get(0).size();
        boolean isEmpty = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board.get(i).get(j) == '.'){
                    row = i;
                    col = j;
                    isEmpty = true;
                    break;
                }
                if(isEmpty)
                    break;
            }
        }
        if(!isEmpty){
            return true;
        }
        for(int num = 1; num <= n; num++){
            char num1 = (char)('1'+num-1);
            if(isSafe(board,num1,row,col)){
                board.get(row).set(col,num1);
                if (solveSudoku1(board))
                    return true;
                board.get(row).set(col,'.');
            }
        }
        return false;
    }
    public boolean isSafe(ArrayList<ArrayList<Character>> board, char num, int row, int col){
        int n = board.size();
        for(int i = 0; i < n; i++){
            char c1 = board.get(row).get(i);
            if(c1 == num)
            {
                return false;
            }
        }
        for(int i = 0; i < n; i++){
            char c1 = board.get(i).get(col);
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
                char c1 = board.get(i).get(j);
                if(c1==num){
                    return false;
                }
            }
        }
        return true;
    }
}
