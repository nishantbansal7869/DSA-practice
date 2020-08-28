package com.practice.hashing;

import javafx.util.Pair;

import java.util.ArrayList;

public class ImplementingHashmap {
    public static void main(String[] args) {
        ImplementingHashmap2 map = new ImplementingHashmap2(10);
    }
}

class ImplementingHashmap2{
    static ArrayList<Pair<Integer, Integer>> list;

    ImplementingHashmap2(int size){
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            list.add(new Pair<>(null, null));
    }
    ImplementingHashmap2(){
        this(100);
    }

    private int hashFunc(int key, int i){
        return ((hashFunc1(key) + (i*hashFunc2(key)))%list.size());
    }

    private int hashFunc2(int key) {
        int sum = 0;
        while (key>0){
            sum += key%10;
            key /= 10;
        }
        return sum;
    }

    private int hashFunc1(int key) {
        return (key%list.size());
    }

    public int search(int key){
        int i = 1;
        int initialHash = hashFunc(key, i);
        while (true){
            int hash = hashFunc(key, i);
            if (null == list.get(hash).getKey() || (i > 1 && hash == initialHash))
                return -1;
            else if (list.get(hash).getKey() == key)
                return hash;
            else
                i++;
        }
    }

    public String deleteKey(int key){
        int idx = search(key);
        if (idx == -1)
            return "Key not found";
        list.set(idx, new Pair<>(Integer.MIN_VALUE, Integer.MIN_VALUE));
        return "Key deleted";
    }

    public String insertKey(int key){
        int idx = search(key);
        if (idx != -1){
            list.set(idx, new Pair<>(key, list.get(idx).getValue()+1));
        }
        else {
            int i = 1;
            int initialHash = hashFunc(key, i);
            while (true){
                int hash = hashFunc(key, i);
                if (i > 1 && hash == initialHash)
                    return "No empty slot left";
                else if (null == list.get(hash).getKey() || list.get(hash).getKey() == Integer.MIN_VALUE) {
                    list.set(hash, new Pair<>(key, 1));
                    return "Key inserted";
                }
                else i++;
            }
        }
        return "Key inserted";
    }

    public int getValue(int key){
        int idx = search(key);
        if (idx == -1)
            return 0;
        return list.get(idx).getValue();
    }

    public int size(){
        int count = 0;
        for (Pair<Integer, Integer> p : list){
            if (null != p.getKey() && p.getKey() != Integer.MIN_VALUE)
                count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return " " + list;
    }
}
