package com.practice.hackerRank;

public class MagicSquare {
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] matrix = {
                {4,5,8},
                {2,4,1},
                {1,9,7}
        };
        int[] arr = new int[9];
        boolean[] taken = new boolean[9];
        solveMagicSquare(matrix, arr, 0, taken);
        System.out.println(ans);
    }

    private static void solveMagicSquare(int[][] matrix, int[] arr, int idx, boolean[] taken) {
        if (idx == 9){
            if (magicSquare(arr) == true){
                ans = Math.min(ans, cost(matrix, arr));
                return;
            }
        }

        for (int i = 1; i <= 9; i++){
            if (taken[i - 1] == false){
                taken[i - 1] = true;
                arr[idx] = i;
                solveMagicSquare(matrix, arr, idx + 1, taken);
                taken[i - 1] = false;
            }
        }
    }

    private static int cost(int[][] matrix, int[] arr) {
        int cost = 0;
        int k = 0;
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                cost += Math.abs(arr[k] - matrix[j][i]);
                k++;
            }
        }
        return cost;
    }

    private static boolean magicSquare(int[] arr) {
        int[][] matrix = new int[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                matrix[j][i] = arr[k];
                k++;
            }
        }
        int sum = arr[0] + arr[1] + arr[2];
        for (int i = 0; i < 3; i++){
            int tempSumRow = 0;
            int tempSumCol = 0;
            for (int j = 0; j < 3; j++){
                tempSumRow += matrix[i][j];
                tempSumCol += matrix[j][i];
            }
            if (tempSumCol != sum || tempSumRow != sum)
                return false;
        }
        int sumD1 = arr[0] + arr[4] + arr[8];
        int sumD2 = arr[2] + arr[4] + arr[6];
        if (sumD1 != sumD2)
            return false;
        return true;
    }
}
