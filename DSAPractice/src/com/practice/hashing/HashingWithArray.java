package com.practice.hashing;

import java.util.ArrayList;
import java.util.Arrays;

public class HashingWithArray {
    public static void main(String[] args) {
        int[] arr = {92,4,14,24,44,91};
        int hashSize = 6;
        int n = arr.length;
        hashMethod(arr,n,hashSize);
    }
    static void hashMethod(int[] arr, int n, int hashSize){
        int[] arr1 = new int[n] ;
        Arrays.fill(arr1,-1);
        ArrayList<ArrayList<Integer>> hashTable = new ArrayList<>(hashSize);
        for(int i = 0; i < hashSize; i++){
            hashTable.add(i,new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int probe = hashFunc(arr[i],hashSize);
            hashTable.get(probe).add(arr[i]);
        }
        System.out.print(hashTable);
    }
    static int hashFunc(int key, int size){
        return key%size;
    }
}
