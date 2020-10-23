package com.practice.hackerRank.trie;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumXOR {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>(n);
            String[] arr = br.readLine().split(" ");
            for (String s : arr)
                list.add(Integer.parseInt(s));
            int ans = MaxXOR(list);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int MaxXOR(ArrayList<Integer> list) {
        Trie root = new Trie();
        int maxBit = (int)(Math.log10(Collections.max(list))/Math.log10(2));
        for (int i : list)
            insert(root, i, maxBit);
        int ans = 0;
        for (int i : list)
            ans = Math.max(ans, query(root, i, maxBit));
        return ans;
    }

    private static int query(Trie root, int i, int maxBit) {
        int ans = 0;
        for (int b = maxBit; b >= 0; b--){
            int idx = checkBit(i,b)?1:0;
            if (root.c[1-idx]!=null){
                ans = ans+(1<<b);
                root = root.c[1-idx];
            }
            else
                root = root.c[idx];
        }
        return ans;
    }

    private static void insert(Trie root, int x, int maxBit) {
        for (int b = maxBit; b >= 0; b--){
            int idx = checkBit(x,b) ? 1 : 0;
            if (root.c[idx] == null)
                root.c[idx] = new Trie();
            root = root.c[idx];
        }
    }

    private static boolean checkBit(int x, int b) {
        return (x&(1<<b)) >= 1;
    }
}

class Trie{
    Trie c[];
    Trie(){
        c = new Trie[2];
        for (int i = 0; i < 2; i++)
            c[i] = null;
    }
}