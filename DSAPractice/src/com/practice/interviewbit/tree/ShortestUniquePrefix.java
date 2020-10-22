package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortestUniquePrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.next());
        ArrayList<String> ans = shortestPrefixes(list);
        System.out.println(ans);
    }

    private static ArrayList<String> shortestPrefixes(ArrayList<String> list) {
        ArrayList<String> ans = new ArrayList<>();
        Trie root = new Trie();
        for (String s : list)
            insert(root, s);
        for (String s : list){
            int length = query(root, s);
            ans.add(s.substring(0, length));
        }
        return ans;
    }

    private static int query(Trie root, String s) {
        int count = 1;
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (root.c[idx].count == 1)
                return count;
            count++;
            root = root.c[idx];
        }
        return 0;
    }

    private static void insert(Trie root, String s) {
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (root.c[idx] == null)
                root.c[idx] = new Trie();
            root.c[idx].count += 1;
            root = root.c[idx];
        }
    }
}

class Trie{
    Trie c[];
    int count;
    Trie(){
        c = new Trie[26];
        for (int i = 0; i < 26; i++)
            c[i] = null;
        count = 0;
    }
}
