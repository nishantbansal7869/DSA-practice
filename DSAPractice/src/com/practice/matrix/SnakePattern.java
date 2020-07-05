package com.practice.matrix;

public class SnakePattern {
    public static void main(String[] args) {
        int[] multi[] = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int j = 0;
        for(int i = 0;i < multi.length; i++){
            if(j == 0){
                for (; j < multi[i].length; j++){
                    System.out.print(multi[i][j] + " ");
                }
                j--;
                System.out.println();
            }
            else {
                for (; j >= 0; j--){
                    System.out.print(multi[i][j] + " ");
                }
                j = 0;
                System.out.println();
            }
        }
    }
}
