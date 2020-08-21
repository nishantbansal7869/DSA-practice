package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class CountTheTriangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int numberOfTriangles = triangles(arr, n);
            System.out.println(numberOfTriangles);
            test--;
        }
    }

    private static int triangles(int[] arr, int n) {
        int count  = 0;
        for (int i = 0; i < n-2; i++){
            for (int j = i+1; j < n-1; j++){
                for (int k = j + 1; k < n; k++){
                    int sum = arr[i] + arr[j];
                    int sum2 = arr[j] + arr[k];
                    int sum3 = arr[i] + arr[k];
                    if (sum > arr[k] && sum2 > arr[i] && sum3 > arr[j])
                        count++;
                }
            }
        }
        return count;
    }


   /* private static int triangles(int[] arr, int n, int k, int idx, ArrayList<Integer> sides) {
        if (k == 0){
            int sum = sides.get(0) + sides.get(1);
            int sum2 = sides.get(1) + sides.get(2);
            int sum3 = sides.get(0) + sides.get(2);
            if (sum > sides.get(2) && sum2 > sides.get(0) && sum3 > sides.get(1))
                return 1;
            return 0;
        }

        int count = 0;
        for (int i = idx; i < n; i++){
            sides.add(arr[i]);
            count += triangles(arr, n, k-1, i+1, sides);
            sides.remove(sides.size()-1);
            triangles(arr, n, k, i+1, sides);
        }
        return count;
    }*/
}
