package com.practice.hackerRank.heap;

import java.io.*;

public class Rhymes {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Node root = new Node();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            insert(root, br.readLine());
        }
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++){
            int ans = query(root, br.readLine());
            bw.write(ans+"");
            bw.newLine();
        }
        bw.flush();
    }

    private static int query(Node root, String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        if (root.c[sb.charAt(0)-'a'] == null)
            return 0;
        for (int i = 0; i < sb.length(); i++){
            int idx = sb.charAt(i) - 'a';
            if (root.c[idx] == null)
                break;
            root = root.c[idx];
        }
        return root.count;
    }

    private static void insert(Node root, String word) {
        StringBuilder sb = new StringBuilder(word);
        sb.reverse();
        for (int i = 0; i < sb.length(); i++){
            int idx = sb.charAt(i) - 'a';
            if (root.c[idx] == null) {
                root.c[idx] = new Node();
            }
            root.c[idx].count = Math.max(root.c[idx].count, word.length());
            root = root.c[idx];
        }
    }
}

class Node{
    Node[] c;
    int count;
    Node(){
        c = new Node[26];
        for (int i = 0; i < 26; i++){
            c[i] = null;
            count = 0;
        }
    }
}