package com.practice.hackerRank.trie;

import java.util.ArrayList;
import java.util.Scanner;

public class NoPrefixSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node root = new Node();
        ArrayList<String> list = new ArrayList<>();
        while (n > 0){
            String s = sc.next();
            list.add(s);
            n--;
        }
        String ans = findPrefix(root, list);
        if (ans.equals(""))
            System.out.println("GOOD SET");
        else {
            System.out.println("BAD SET");
            System.out.println(ans);
        }
    }

    private static String findPrefix(Node root, ArrayList<String> list) {
        for (String s : list) {
            if (!insert(root, s))
                return s;
        }
        String str = "";
        for (String s : list) {
            str = query(root, s);
            if (!str.equals(""))
                break;
        }
        return str;
    }

    private static String query(Node root, String s) {
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (i == s.length()-1 && root.c[idx].count > 1)
                return s;
            root = root.c[idx];
        }
        return "";
    }

    private static boolean insert(Node root, String s) {
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (root.c[idx] == null) {
                root.c[idx] = new Node();
                if (root.c[idx].present)
                    return false;
            }
            if (i == s.length()-1)
                root.c[idx].present = true;
            root.c[idx].count += 1;
            root = root.c[idx];
        }
        return true;
    }

}
class Node{
    Node[] c;
    int count;
    boolean present;
    Node(){
        c = new Node[10];
        for (int i = 0; i < 10; i++){
            c[i] = null;
            count = 0;
            present = false;
        }
    }
}