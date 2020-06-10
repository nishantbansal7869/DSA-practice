package com.practice.backtrackingQuestion;

public class RatInAMaze {
    static int arr[][] = new int[][]{
            {1,0,1},
            {1,1,0},
            {0,1,1}
    };
    static int sol[][] = new int[3][3];
    public static void main(String[] args) {
        System.out.println(solvemaze());
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
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
        if(i == 2 && j == 2){
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
        return (i < 3 && j < 3 && arr[i][j] == 1);
    }
}
