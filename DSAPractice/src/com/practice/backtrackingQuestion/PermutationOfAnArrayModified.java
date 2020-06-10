package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfAnArrayModified {
    public static void main(String[] args) {
        int n = 3;
        int k = 4;
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(i+1);
        }
      String res =  permutation(arr,k-1);
        System.out.print(res);
    }
    public static String permutation(List<Integer> arr, int k){
        int n = arr.size();
        if(n == 0)
            return "";
        int fact_n = fact(n-1);
        int index = k/fact_n;
        int num = arr.get(index);
        arr.remove(index);
        k %= fact_n;
        return num + permutation(arr,k);
    }
    public static int fact(int n){
        int fact = 1;
        for(int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

}
