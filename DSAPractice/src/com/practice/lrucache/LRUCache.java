package com.practice.lrucache;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl(1);
        cache.put(2, 1);
        //cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(3,2);
       // cache.put(4,1);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        //System.out.println(cache.get(10));
        //cache.put(6, 14);
        //System.out.println(cache.get(5));
    }
}

class LRUCacheImpl{
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Integer, Integer> mapKey = new HashMap<>();
    int cacheSize;
    Node cache;
    Node dummy = new Node(0);
    Node head = dummy;
    Node tail = dummy;
    LRUCacheImpl(){
        this(5);
    }
    LRUCacheImpl(int size){
        cacheSize = size;
    }
    void put(int key, int data){
        int size = map.size();
        if (!map.containsKey(key) && size != cacheSize)
            insertElement(key, data);
        else if (map.containsKey(key))
            replaceData(key, data);
        else
            removeAndReplace(key, data);
    }

    private void removeAndReplace(int key, int data) {
        map.remove(head.next.data);
        mapKey.remove(head.next.data);
        if (head.next == tail)
            tail = head;
        else {
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node n = new Node(key);
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
        map.put(key, n);
        mapKey.put(key, data);
    }

    private void replaceData(int key, int data) {
        Node n = map.get(key);
        mapKey.put(key, data);
        if (n == tail)
            return;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        tail.next = n;
        n.prev = tail;
        tail = n;
        tail.next = null;
    }

    private void insertElement(int key, int data) {
        Node n = new Node(key);
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
        map.put(key, n);
        mapKey.put(key, data);
    }

    //returns first element in the cache
    int get(int key){
        if (map.containsKey(key)) {
            replaceData(key, mapKey.get(key));
            return mapKey.get(key);
        }
        return -1;
    }
}

class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data = data;
        prev = null;
        next = null;
    }
}