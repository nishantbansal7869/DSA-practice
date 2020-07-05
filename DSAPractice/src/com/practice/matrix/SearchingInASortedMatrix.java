package com.practice.matrix;

public class SearchingInASortedMatrix {
    public static void main(String[] args) {
        int[] matrix[] = new int[][]{{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        int x = 50;
        int i = 0;
        int j = matrix.length-1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] == x){
                System.out.print(x + " found at [" + i + "," + j + "]" );
                return;
            }
            else if (matrix[i][j] > x){
                j--;
            }
            else
                i++;
        }
        System.out.print("Not found");
    }
}
