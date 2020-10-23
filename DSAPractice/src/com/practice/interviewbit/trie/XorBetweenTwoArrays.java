package com.practice.interviewbit.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class XorBetweenTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        for (int i = 0; i < n; i++)
           list1.add(i, sc.nextInt());
        int ans = maxXor(list, list1);
        System.out.println(ans);
    }

    private static int maxXor(ArrayList<Integer> list, ArrayList<Integer> list1) {
        Trie root = new Trie();
        Trie root1 = new Trie();
        int maxBit = (int)(Math.log10(Collections.max(list))/Math.log10(2));
        int maxBit1 = (int)(Math.log10(Collections.max(list1))/Math.log10(2));
        for (int i : list)
            insert(root, i, maxBit, maxBit1);
        for (int i : list1)
            insert(root1, i, maxBit1, maxBit1);
        int ans = 0;
        for (int i : list)
            ans = Math.max(ans, query(root, root1, i, Math.max(maxBit, maxBit1)));
        return ans;
    }

    private static int query(Trie root, Trie root1, int i, int maxBit) {
        int ans = 0;
        for (int b = maxBit; b >= 0; b--){
            int idx = checkBit(i,b)?1:0;
            if (root1.c[1-idx]!=null){
                ans = ans+(1<<b);
                root1 = root1.c[1-idx];
            }
            else
                root1 = root1.c[idx];
            root = root.c[idx];
        }
        return ans;
    }

    private static void insert(Trie root, int x, int maxBit, int maxBit1) {
        if (maxBit > maxBit1){
            int diff = maxBit - maxBit1;
            for (int i = 0; i < diff; i++)
                if (root.c[0] == null)
                    root.c[0] = new Trie();
                root = root.c[0];
        }
        else if (maxBit < maxBit1){
            int diff = maxBit1 - maxBit;
            for (int i = 0; i < diff; i++)
                if (root.c[0] == null)
                    root.c[0] = new Trie();
            root = root.c[0];
        }
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