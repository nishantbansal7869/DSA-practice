package com.practice.hashing;

import java.util.LinkedList;

public class HashWithChainingLinkedList {
    public static void main(String[] args) {
        Hashing hash = new Hashing(15);
        hash.insert(1);
        hash.insert(15);
        hash.insert(30);
        hash.insert(31);
        hash.insert(32);
        hash.insert(54);
        hash.delete(54);
        System.out.print(hash.search(54));
    }
}
class Hashing{
    LinkedList<Integer>[] list;
    int bucket;
    Hashing(int bucketLength){
        bucket = bucketLength;
        list = new LinkedList[bucket];
        for(int i = 0; i < bucket; i++){
            list[i] = new LinkedList<>();
        }
    }
    Hashing(){
        this(10);
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
        list[i].remove((Integer) 54);
    }
    boolean search(int key){
        int i = hashFunction(key);
        for(Integer n : list[i]){
            if(n == key){
                return true;
            }
        }
        return false;
    }
}
