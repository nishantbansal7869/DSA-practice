package com.practice.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public static void main(String[] args) {
        BT tree = new BT();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        printPostOrder(tree.root);
        System.out.println();
        printPreOrder(tree.root);
        System.out.println();
        printInorder(tree.root);
        System.out.println();
        levelOrderTraversal(tree.root);
        insertNodeInLevelOrderTraversal(tree.root, 6);
        insertNodeInLevelOrderTraversal(tree.root, 7);
        System.out.println();
        levelOrderTraversal(tree.root);
        System.out.println();
        deleteNode(tree.root, 4);
        levelOrderTraversal(tree.root);
        System.out.println();
        System.out.println(findLCA(tree.root, 7, 5).data);
        /*tree.root = mirrorTree(tree.root);
        System.out.println("Mirror");
        levelOrderTraversal(tree.root);*/
        System.out.println("ZigZag");
        zigZagTraversal(tree.root);

    }

    static void printPostOrder(Node node){
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    static void printPreOrder(Node node){
        if (node == null)
            return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

     static void printInorder(Node node){
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
     }

     static void levelOrderTraversal(Node node){
         Queue<Node> queue = new ArrayDeque<>();
         queue.add(node);
         while (!queue.isEmpty()){
             Node tempNode = queue.poll();

             System.out.print(tempNode.data + " ");
             if (tempNode.left != null)
                 queue.add(tempNode.left);
             if (tempNode.right != null)
                 queue.add(tempNode.right);
         }
     }

     static void insertNodeInLevelOrderTraversal(Node node, int key){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            if (tempNode.left == null){
                tempNode.left = new Node(key);
                return;
            }
            else
                queue.add(tempNode.left);
            if (tempNode.right == null){
                tempNode.right = new Node(key);
                return;
            }
            else
                queue.add(tempNode.right);
        }
     }

     static void deleteNode(Node node, int key){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node keyNode = null;
        Node temp = null;
        while (!queue.isEmpty()){
            temp = queue.poll();
            if (temp.data == key)
                keyNode = temp;
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
        int x = temp.data;
        deletedDeepest(node, temp);
        keyNode.data = x;
     }

    private static void deletedDeepest(Node node, Node temp) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Node tempNode;
        while (!queue.isEmpty()){
            tempNode = queue.poll();
            if (tempNode.left != null){
                if (tempNode.left == temp){
                    tempNode.left = null;
                    return;
                }
                else
                    queue.add(tempNode.left);
            }
            if (tempNode.right != null){
                if (tempNode.right == temp){
                    tempNode.right = null;
                    return;
                }
                else
                    queue.add(tempNode.right);
            }
        }
    }

    static Node findLCA(Node node, int n1, int n2){
        if (node == null)
            return node;
        if (node.data == n1 || node.data == n2)
            return node;
        Node leftLCA = findLCA(node.left, n1, n2);
        Node rightLCA = findLCA(node.right, n1, n2);
        if (leftLCA != null && rightLCA != null)
            return node;
        return leftLCA != null ? leftLCA : rightLCA;
    }
    static Node mirrorTree(Node node){
        if (node == null)
            return node;
        Node leftNode = mirrorTree(node.left);
        Node rightNode = mirrorTree(node.right);
        node.left = rightNode;
        node.right = leftNode;
        return node;
    }

    static void zigZagTraversal(Node node){
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(node);
        while (!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            System.out.print(temp.data + " ");
            if (leftToRight){
                if (temp.left != null)
                    nextLevel.push(temp.left);
                if (temp.right != null)
                    nextLevel.push(temp.right);
            }
            else {
                if (temp.right != null)
                    nextLevel.push(temp.right);
                if (temp.left != null)
                    nextLevel.push(temp.left);
            }
            if (currentLevel.isEmpty()){
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
                leftToRight = !leftToRight;
            }
        }
    }
}

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BT{
    Node root;
    public BT(){
        root = null;
    }
    public BT(int key){
        root = new Node(key);
    }
}
