package com.practice.lrucache;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        LRUCacheImpl cache = new LRUCacheImpl();
        int[] arr = {5, 12, 8, 12, 10, 7, 4, 10, 7, 2, 18, 7, 12, 7, 12};
        for (int i = 0; i < arr.length; i++)
            cache.put(arr[i]);
        cache.get();
    }
}

class LRUCacheImpl{
    HashMap<Integer, Node> map = new HashMap<>();
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
    void put(int data){
        int size = map.size();
        if (!map.containsKey(data) && size != cacheSize)
            insertElement(data);
        else if (map.containsKey(data))
            replaceData(data);
        else
            removeAndReplace(data);
    }

    private void removeAndReplace(int data) {
        map.remove(head.next.data);
        head.next = head.next.next;
        head.next.prev = head;
        Node n = new Node(data);
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
        map.put(data, n);
    }

    private void replaceData(int data) {
        Node n = map.get(data);
        if (n == tail)
            return;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        tail.next = n;
        n.prev = tail;
        tail = n;
        tail.next = null;
    }

    private void insertElement(int data) {
        Node n = new Node(data);
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
        map.put(data, n);
    }

    //returns first element in the cache
    Node get(){
        return head != null ? head.next : null;
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