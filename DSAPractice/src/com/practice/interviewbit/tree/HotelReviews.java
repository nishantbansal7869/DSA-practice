package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HotelReviews {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            list.add(i, sc.next());
        ArrayList<Integer> ans = hotelReviews(s, list);
        System.out.println(ans);
    }

    private static ArrayList<Integer> hotelReviews(String s, ArrayList<String> list) {
        Tries root = new Tries();
        String[] arr = s.split("_");
        for (String a : arr)
            insert(root, a);
        int idx = 0;
        ArrayList<Pairs> list1 = new ArrayList<>();
        for (String a : list){
            String[] sArr = a.split("_");
            int count = 0;
            for (String b : sArr) {
                  boolean present = query(root, b);
                  if (present)
                      count++;
            }
            list1.add(new Pairs(idx, count));
            idx++;
        }
        list1.sort(new Comparators());
        ArrayList<Integer> ans = new ArrayList<>();
        for (Pairs p : list1)
            ans.add(p.idx);
        return ans;
    }

    private static boolean query(Tries root, String s) {
        for (int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            if (root.c[idx] == null)
                return false;
            root = root.c[idx];
        }
        return true;
    }

    private static void insert(Tries root, String s) {
        for (int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 'a';
            if(root.c[idx] == null)
                root.c[idx] = new Tries();
            root = root.c[idx];
        }
    }
}

class Tries{
    Tries c[];
    Tries(){
        c = new Tries[26];
        for (int i = 0; i < 26; i++)
            c[i] = null;
    }
}

class Pairs{
    int idx;
    int count;
    Pairs(int idx, int count){
        this.idx = idx;
        this.count = count;
    }
}

class Comparators implements Comparator<Pairs>{

    @Override
    public int compare(Pairs o1, Pairs o2) {
        if (o1.count == o2.count)
            return o1.idx - o2.idx;
        return o2.count - o1.count;
    }
}