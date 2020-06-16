package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMazeUpdated {
    public static  ArrayList<String> sol = new ArrayList<>();
    public static void main(String[] args) {
        /*int maze[][] = new int[][]{
                {1,0,0,0,0,0,0},
                {1,0,1,1,1,1,0},
                {1,0,1,0,0,1,0},
                {1,1,1,0,1,1,0},
                {0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0},
                {0,0,0,0,1,1,1}
        };*/
        int maze[][] = new int[][]{
                {1,0,0,0},
                {1,1,0,1},
                {1,1,0,0},
                {0,1,1,1}
        };
        int n = maze.length;
        int[][] visited = new int[n][n];
       // int index = 0;
        String s = "";
        path(maze,0,0,s,n,visited);
            sol.stream().forEach(a->System.out.println(a));
        System.out.println(sol.size());
    }
   /* public static void solveMaze(int[][] maze, int i, int j, int n, String s, int visited[][]) {
        if(i == n-1 && j == n-1){
            sol.add(s);
            return;
        }
        if(maze[i][j] == 0 || visited[i][j] == 1)
            return;
        visited[i][j] = 1;
        if(i > 0){
            solveMaze(maze,i-1,j,n,s+"U",visited);
        }
        if(j > 0){
            solveMaze(maze,i,j-1,n,s+"L",visited);
        }
        if(i < n){
            solveMaze(maze,i+1,j,n,s+"D",visited);
        }
        if(j < n){
            solveMaze(maze,i,j+1,n,s+"R",visited);
        }
        visited[i][j] = 0;
    }*/
   public static void path(int[][] m, int x, int y, String dir, int n, int[][] visited) {
       if (x == n - 1 && y == n - 1) {
           sol.add(dir);
           return;
       }

       if (x<0 || y < 0 || x > n-1 || y > n-1 || m[x][y] == 0 || visited[x][y] == 1) {
           return;
       }

       visited[x][y] = 1;
     //  if (x > 0) {
           path(m, x - 1, y, dir + 'U', n,visited);
       //}
       //if (y > 0) {
           path(m, x, y - 1, dir + 'L', n,visited);
       ///}
       //if (x < n - 1) {
           path(m, x + 1, y, dir + 'D', n,visited);
      // }
       //if (y < n - 1) {
           path(m, x, y + 1, dir + 'R', n,visited);
       //}
       visited[x][y] = 0;
   }
}
