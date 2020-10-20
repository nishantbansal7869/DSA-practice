package com.practice.hackerRank.trie;

import java.util.Scanner;

public class NoPrefixSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = new Node();
        boolean badState = false;
        while (n > 0){
            String s = sc.next();
            if (!insert(root, s)){
                badState = true;
                System.out.println("BAD SET");
                System.out.println(s);
            }
            n--;
        }
        if (!badState)
            System.out.println("GOOD SET");
    }

    private static boolean insert(Node root, String s) {
        int cur = 0;
        for (int i = 0; i < s.length(); i++){
            cur++;
            int idx = s.charAt(i)-'a';
            if (root.c[idx] == null) {
                if (root.count == cur)
                    return false;
                root.c[idx] = new Node();
            }
            root.c[idx].count = Math.max(root.c[idx].count, s.length());
            root = root.c[idx];
        }
        return true;
    }
}
class Node{
    Node[] c;
    int count;
    Node(){
        c = new Node[10];
        for (int i = 0; i < 10; i++){
            c[i] = null;
            count = 0;
        }
    }
}