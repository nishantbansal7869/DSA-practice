package com.practice.backtrackingQuestion;

public class RatInAMaze {
    static int arr[][] = new int[][]{
            {1,0},
            {1,0}
    };
    static int sol[][] = new int[2][2];
    public static void main(String[] args) {
        System.out.println(solvemaze());
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++ ){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean solvemaze(){
        if(solveMazeRec(0,0) == false){

            return false;
        }
        else {
            return true;
        }
    }
    public static boolean solveMazeRec(int i, int j){
        if(i == 1 && j == 1){
            sol[i][j] = 1;
            return true;
        }
        if(isSafe(i,j)){
            sol[i][j] = 1;
            if(solveMazeRec(i+1,j))
                return true;
            else if(solveMazeRec(i,j+1))
                return true;
            sol[i][j] = 0;
        }
        return false;
    }
    public static boolean isSafe(int i, int j){
        return (i < 2 && j < 2 && arr[i][j] == 1);
    }
}
