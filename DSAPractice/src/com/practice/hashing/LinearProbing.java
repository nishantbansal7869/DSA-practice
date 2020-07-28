package com.practice.hashing;

import java.util.Arrays;

public class LinearProbing {
    public static void main(String[] args) {
        int[] arr = {21,10,32,43};
        int hashSize = 11;
        int n = arr.length;
        int hash[] = linearProbing(hashSize,arr,n);
        Arrays.stream(hash).forEach(s-> System.out.print(s + " "));
    }

    private static int[] linearProbing(int hashSize, int[] arr, int n) {
        int hash[] = new int[hashSize];
        Arrays.fill(hash,-1);
        for(int i = 0; i < n; i++){
            insert(arr[i], hash, hashSize);
        }
        return hash;
    }
    static int hashFunc(int key, int hashSize){
        return key%hashSize;
    }
    static boolean insert(int key,int[] hash, int hashSize){
        int probe = hashFunc(key,hashSize);
        int offset = 1;
        int start = probe;
        while(hash[probe] != -1 && hash[probe] != key){
            probe = (probe+offset*offset)%hashSize;
            offset++;
            if(probe == start || hash[probe] == key){
                return false;
            }
        }
        hash[probe] = key;
        return true;
    }
}
