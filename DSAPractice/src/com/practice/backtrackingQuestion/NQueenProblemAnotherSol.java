package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenProblemAnotherSol {
    public static void main(String[] args) {
        int n = 4;
        SolutionNQueen obj = new SolutionNQueen();
        obj.solveNQueen(n);
    }
}
class SolutionNQueen{
    public void solveNQueen(int n){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        ArrayList<Integer> window = new ArrayList<>();
        findSol(n,res,window);
        res.stream().forEach(s->System.out.print(s));
    }

    public void findSol(int n, ArrayList<ArrayList<String>> res, ArrayList<Integer> window ){
        if(window.size() == n){
            ArrayList<String> sol = new ArrayList<>();
            for(int row = 0; row < n ; row++){
                StringBuilder s = new StringBuilder();
                for(int col = 0; col < n; col++){
                    if(col == window.get(row)){
                        s.append("Q");
                    }
                    else {
                        s.append(".");
                    }
                }
                sol.add(s.toString());
            }
            res.add(sol);
            return;
        }
        for(int col = 0; col < n; col++){
            if(isSafe(window,col)){
                window.add(col);
                findSol(n,res,window);
                window.remove(window.size()-1);
            }
        }
    }

    public boolean isSafe(ArrayList<Integer> window, int curCol){
        for(int row = 0; row < window.size(); row++){
            if(curCol == window.get(row)){
                return false;
            }
            int col = window.get(row);
            int curRow = window.size();
            if((curCol-col) == (curRow-row) || (curRow-row) == (col-curCol))
                return false;
        }
        return true;
    }
}
