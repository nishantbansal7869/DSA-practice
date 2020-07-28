package com.practice.hashing;

import java.util.ArrayList;

public class HashingWithCheiningArrayList {
    public static void main(String[] args) {
        HashingWithArrayList hash = new HashingWithArrayList(10);
        hash.insert(1);
        hash.insert(10);
        hash.insert(21);
        hash.insert(12);
        hash.insert(15);
        hash.delete(15);
        System.out.print(hash.search(15));
    }
}

class HashingWithArrayList{
    int bucket;
    ArrayList<Integer>[] list;
    HashingWithArrayList(int b){
        bucket = b;
        list = new ArrayList[bucket];
        for(int i = 0; i < bucket; i++){
            list[i] = new ArrayList<>();
        }
    }
    int hashFunction(int key){
        return key%bucket;
    }
    void insert(int key){
        int i = hashFunction(key);
        list[i].add(key);
    }
    void delete(int key){
        int i = hashFunction(key);
        list[i].remove((Integer)key);
    }
    boolean search(int key){
        int i = hashFunction(key);
        for(Integer n : list[i]){
            if(n == key)
                return true;
        }
        return false;
    }
}