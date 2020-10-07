package com.practice.tree;

import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;

public class BinarySearchTree {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = new Nodes(8);
        tree.root.left = new Nodes(3);
        tree.root.left.left = new Nodes(1);
        tree.root.left.right = new Nodes(6);
        tree.root.left.right.left = new Nodes(4);
        tree.root.left.right.right = new Nodes(7);
        tree.root.right = new Nodes(10);
        tree.root.right.right = new Nodes(14);
        tree.root.right.right.left = new Nodes(13);
        inorderTraversal(tree.root);
        System.out.println();
        searchKey(tree.root, 11);
        insertKey(tree.root, 11);
        System.out.println();
        inorderTraversal(tree.root);
        deleteKey(tree.root, 11);
        System.out.println();
        inorderTraversal(tree.root);
        System.out.println();
        System.out.println(findLCA(tree.root, 3,6).data);
        ArrayList<Integer> path = longestPath(tree.root);
        System.out.println("LongestPath");
        Collections.reverse(path);
        for (int i : path){
            System.out.print(i + " ");
        }
    }

    public static void inorderTraversal(Nodes node){
        if (node == null)
            return;
        inorderTraversal(node.left);
        System.out.print(node.data + " ");
        inorderTraversal(node.right);
    }

    public static void searchKey(Nodes node, int key){
        if (node == null || node.data == key) {
            if (node != null)
                System.out.println(node.data);
            else
                System.out.println("Not found");
            return;
        }
        if (node.data > key)
            searchKey(node.left, key);
        else
            searchKey(node.right, key);
    }

    public static Nodes insertKey(Nodes node, int key){
        if (node == null){
            node = new Nodes(key);
            return node;
        }
        if (node.data >= key)
            node.left = insertKey(node.left, key);
        else
            node.right = insertKey(node.right, key);
        return node;
    }

    public static Nodes deleteKey(Nodes node, int key){
        if (node == null)
            return node;
        if (node.data < key)
            node.right = deleteKey(node.right, key);
        else if (node.data > key)
            node.left = deleteKey(node.left, key);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            node.data = minValue(node.right);
            node.right = deleteKey(node.right, node.data);
        }
        return node;
    }

    private static int minValue(Nodes node) {
        int minValue = node.data;
        while (node.left != null){
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public static Nodes findLCA(Nodes node, int n1, int n2){
        if (node == null)
            return null;
        if (node.data > n1 && node.data > n2)
            return findLCA(node.left, n1, n2);
        if (node.data < n1 && node.data < n2)
            return findLCA(node.right, n1, n2);
        return node;
    }

    public static ArrayList<Integer> longestPath(Nodes node){
        if (node == null)
            return new ArrayList<>();
        ArrayList<Integer> left = longestPath(node.left);
        ArrayList<Integer> right = longestPath(node.right);

        if (left.size() > right.size())
            left.add(node.data);
        else
            right.add(node.data);
        return left.size()>right.size() ? left : right;
    }
}

class Nodes{
    int data;
    Nodes left,right;
    public Nodes(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BST{
    Nodes root;
    public BST(){
        root = null;
    }
    public BST(int key)
    {
        root = new Nodes(key);
    }
}