package com.practice.hackerRank.trie;

import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        String[][] queries = new String[test][];
        for (int i = 0; i < test; i++){
            for (int j = 0; j < 2; j++)
                queries[i][j] = sc.next();
        }
        int[] ans = contacts(queries);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] contacts(String[][] queries) {
        Nodes root = new Nodes();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++){
            if (queries[i][0].equals("add"))
                insert(root, queries[i][1]);
            else
                ans.add(query(root, queries[i][1]));
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            a[i] = ans.get(i);
        return a;
    }

    private static int query(Nodes root, String word) {
        if (root.c[word.charAt(0)-'a'] == null)
            return 0;
        for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (root.c[idx] == null)
                return 0;
            root = root.c[idx];
        }
        return root.count;
    }

    private static void insert(Nodes root, String word) {
        for (int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if (root.c[idx] == null) {
                root.c[idx] = new Nodes();
            }
            root.c[idx].count += 1;
            root = root.c[idx];
        }
    }
}
class Nodes{
    Nodes[] c;
    int count;
    Nodes(){
        c = new Nodes[26];
        for (int i = 0; i < 26; i++){
            c[i] = null;
            count = 0;
        }
    }
}