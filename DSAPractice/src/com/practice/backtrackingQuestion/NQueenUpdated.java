package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Scanner;


public class NQueenUpdated {
    public static void main(String[] args) {
        int testcases = 0;
        Scanner sc = new Scanner(System.in);
        testcases = sc.nextInt();
        int n[] = new int[testcases];
        for(int i = 0; i < testcases; i++){
            n[i] = sc.nextInt();
        }
        for(int i = 0; i < testcases; i++){
            solveNQueen(n[i]);
            for(int k = 0; k < res.size(); k++){
                for(int j = 0; j < res.get(k).size(); j++){
                    res.get(k).set(j,res.get(i).get(j)+1);
                }
            }
            res.stream().forEach(s->System.out.print(s + " "));
        }
    }
    public static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void solveNQueen(int n){
        ArrayList<Integer> window = new ArrayList<>();
        res.clear();
        nQueen(res,window,n);
    }
    public static void nQueen(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> window, int n){
        if(window.size() == n){
            res.add(new ArrayList<>(window));
            return;
        }
        for(int col = 0;col < n; col++){
            if(isSafe(window,col)){
                window.add(col);
                nQueen(res,window,n);
                window.remove(window.size()-1);
            }
        }
    }
    public static boolean isSafe(ArrayList<Integer> window, int curCol){
        for(int row = 0; row < window.size(); row++){
            if(curCol == window.get(row)){
                return false;
            }
            int col = window.get(row);
            int curRow = window.size();
            if((curCol-col) == (curRow-row) || (curRow-row) == (col-curCol)){
                return false;
            }
        }
        return true;
    }
}
