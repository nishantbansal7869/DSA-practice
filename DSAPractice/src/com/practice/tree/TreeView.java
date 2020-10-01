package com.practice.tree;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeView {
    public static void main(String[] args) {
        BinaryTrees tree = new BinaryTrees();
        tree.root = new Node1(1);
        tree.root.left = new Node1(2);
        tree.root.right = new Node1(3);
        tree.root.left.left = new Node1(4);
        tree.root.left.right = new Node1(5);
        tree.root.right.right = new Node1(6);
        leftView(tree.root, 1);
        System.out.println();
        maxLevel = 0;
        rightView(tree.root, 1);
        System.out.println();
        topView(tree.root);
        System.out.println();
        bottomView(tree.root);
    }

    static int maxLevel = 0;

    static void leftView(Node1 node, int level){
        if (node == null)
            return;
        if (maxLevel < level){
            System.out.print(node.data+" ");
            maxLevel = level;
        }
        leftView(node.left, level+1);
        leftView(node.right, level+1);
    }

    static void rightView(Node1 node, int level){
        if (node == null)
            return;
        if (maxLevel < level)
        {
            System.out.println(node.data + " ");
            maxLevel = level;
        }
        rightView(node.right, level+1);
        rightView(node.left, level+1);
    }

    static void topView(Node1 node){
        class QueueObj{
            Node1 node;
            int hd;
            public QueueObj(Node1 node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> queue = new ArrayDeque<>();
        Map<Integer, Node1> map = new TreeMap<>();
        queue.add(new QueueObj(node, 0));
        while (!queue.isEmpty()){
            QueueObj temp = queue.poll();
            if (!map.containsKey(temp.hd))
                map.put(temp.hd, temp.node);
            if (temp.node.left != null)
                queue.add(new QueueObj(temp.node.left, temp.hd - 1));
            if (temp.node.right != null)
                queue.add(new QueueObj(temp.node.right, temp.hd + 1));
        }

        for (Integer i : map.keySet()){
            System.out.print(map.get(i).data + " ");
        }
    }

    static void bottomView(Node1 node){
        class queueObj{
            Node1 node;
            int hd;
            public queueObj(Node1 node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<queueObj> queue = new ArrayDeque<>();
        Map<Integer, Node1> map = new TreeMap<>();
        queue.add(new queueObj(node, 0));
        while (!queue.isEmpty()){
            queueObj temp = queue.poll();
            map.put(temp.hd, temp.node);
            if (temp.node.left != null)
                queue.add(new queueObj(temp.node.left, temp.hd-1));
            if (temp.node.right != null)
                queue.add(new queueObj(temp.node.right, temp.hd+1));
        }
        for (int i : map.keySet()){
            System.out.print(map.get(i).data + " ");
        }
    }
}

class Node1{
    int data;
    Node1 left, right;

    public Node1(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTrees{
    Node1 root;
    public BinaryTrees(){
        root = null;
    }
    public BinaryTrees(int key){
        root = new Node1(key);
    }
}
