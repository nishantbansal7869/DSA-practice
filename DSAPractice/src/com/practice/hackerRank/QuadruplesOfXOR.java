package com.practice.hackerRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class QuadruplesOfXOR {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int arr1[] = new int[n];
            int arr2[] = new int[n];
            int arr3[] = new int[n];
            int arr4[] = new int[n];
            for (int i = 0; i < n; i++)
                arr1[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr2[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr3[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arr4[i] = sc.nextInt();
            int ans = quadruplesOfXOR(arr1, arr2, arr3, arr4);
            System.out.println(ans);
            test--;
        }
    }

    private static int quadruplesOfXOR(int[] arr1, int[] arr2, int[] arr3, int[] arr4) {
        int count = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i : arr1){
            for (int j : arr2){
                if (map1.containsKey(i^j)){
                    map1.put(i^j, map1.get(i^j)+1);
                }
                else
                    map1.put(i^j, 1);
            }
        }
        for (int i : arr3){
            for (int j : arr4){
                if (map2.containsKey(i^j))
                    map2.put(i^j, map2.get(i^j)+1);
                else
                    map2.put(i^j, 1);
            }
        }
        Set<Integer> set = map1.keySet();
        Set<Integer> set2 = map2.keySet();
        for (int i : set){
            for (int j : set2){
                if ((i^j) == 0){
                    count += map1.get(i) * map2.get(j);
                }
            }
        }
        return count;
    }
}
