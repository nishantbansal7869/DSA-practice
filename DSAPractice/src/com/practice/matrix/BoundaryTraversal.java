package com.practice.matrix;

public class BoundaryTraversal {
    public static void main(String[] args) {
        int[] multi[] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        if(multi.length == 1){
            for (int i = 0; i < multi[0].length; i++){
                System.out.print(multi[0][i]);
            }
        }
        else if(multi[0].length == 1){
            for(int i = 0; i < multi.length; i++ ){
                System.out.print(multi[i][0]);
            }
        }
        else {
            int c = multi[0].length;
            int r = multi.length;
            for (int i = 0; i < c; i++){
                System.out.print(multi[0][i] + " ");
            }
            System.out.println();
            for (int i = 1; i < r; i++){
                System.out.print(multi[i][c-1] + " ");
            }
            System.out.println();
            for (int i = c - 2; i >= 0; i--){
                System.out.print(multi[r-1][i] + " ");
            }
            System.out.println();
            for (int i = r-2; i > 0; i--){
                System.out.print(multi[i][0] + " ");
            }
        }
    }
}
