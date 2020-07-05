package com.practice.matrix;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[] matrix[] = new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}, {21,22,23,24,25}};
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        while (top <= bottom && left <= right){
            // Top row
            for(int i = left; i <= right; i++){
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            // Right column
            for (int i = top; i <= bottom; i++){
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            // Bottom row
            if(top <= bottom)
            for (int i = right; i >= left; i--){
                System.out.print(matrix[bottom][i] + " ");
            }
            bottom--;
            //Left column
            if(left<=right)
            for (int i = bottom; i >= top; i--){
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
    }
}
