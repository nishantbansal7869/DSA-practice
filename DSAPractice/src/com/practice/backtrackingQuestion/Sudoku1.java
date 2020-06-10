package com.practice.backtrackingQuestion;
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class Sudoku1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        ArrayList<Character> elements = new ArrayList<>();
        elements.add('5');
        elements.add('3');
        elements.add('.');
        elements.add('.');
        elements.add('7');
        elements.add('.');
        elements.add('.');
        elements.add('.');
        elements.add('.');
        board.add(new ArrayList<>(elements));
        elements.set(0,'6');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'1');
        elements.set(0,'9');
        elements.set(0,'5');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        board.add(new ArrayList<>(elements));
        elements.set(0,'.');
        elements.set(0,'9');
        elements.set(0,'8');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'6');
        elements.set(0,'.');
        board.add(new ArrayList<>(elements));
        elements.set(0,'8');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'6');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'3');
        board.add(new ArrayList<>(elements));
        elements.set(0,'4');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'8');
        elements.set(0,'.');
        elements.set(0,'3');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'1');
        board.add(new ArrayList<>(elements));
        elements.set(0,'7');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'2');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'6');
        board.add(new ArrayList<>(elements));
        elements.set(0,'.');
        elements.set(0,'6');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'2');
        elements.set(0,'8');
        elements.set(0,'.');
        board.add(new ArrayList<>(elements));
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'4');
        elements.set(0,'1');
        elements.set(0,'9');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'5');
        board.add(new ArrayList<>(elements));
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'8');
        elements.set(0,'.');
        elements.set(0,'.');
        elements.set(0,'7');
        elements.set(0,'9');
        board.add(new ArrayList<>(elements));
        Solution obj = new Solution();
        obj.solveSudoku(board);
    }
}
class Solution {
    public void solveSudoku(ArrayList<ArrayList<Character>> board) {
        solveSudoku1(board);
        int n = board.size();
        board.clear();
        for(int i = 0; i < n; i++){
            ArrayList<Character> temp = (ArrayList)res.get(i).clone();
            board.add(temp);
        }
        board.stream().forEach(s->System.out.print(s));
    }
    ArrayList<ArrayList<Character>> res = new ArrayList<>();
    public void solveSudoku1(ArrayList<ArrayList<Character>> board){
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
                if(isEmpty == true)
                    break;
            }
        }
        if(!isEmpty){
            for(int i = 0; i < n; i++){
                ArrayList<Character> temp = (ArrayList)board.get(i).clone();
                res.add(temp);
            }
            return;
        }
        for(int num = 1; num <= n; num++){
            char num1 = (char)('1'+num-1);
            if(isSafe(board,num1,row,col)){
                board.get(row).set(col,num1);
                solveSudoku1(board);
                board.get(row).set(col,'.');
            }
        }
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
