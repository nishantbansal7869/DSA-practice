package com.practice.interviewbit;

import java.util.*;

public class TwoOutOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n1);
        ArrayList<Integer> b = new ArrayList<>(n2);
        ArrayList<Integer> c = new ArrayList<>(n3);
        for (int i = 0; i < n1; i++)
            a.add(i, sc.nextInt());
        for (int i = 0; i < n2; i++)
            b.add(i, sc.nextInt());
        for (int i = 0; i < n3; i++)
            c.add(i, sc.nextInt());
        ArrayList<Integer> res = findUniqueAndSorted(a, b, c);
        System.out.println(res);
    }

    private static ArrayList<Integer> findUniqueAndSorted(ArrayList<Integer> a, ArrayList<Integer> b,
                                                          ArrayList<Integer> c) {
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>(a);
        HashSet<Integer> set2 = new HashSet<>(b);
        HashSet<Integer> set3 = new HashSet<>(c);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : set1)
            map.put(i, 1);

        for (int i : set2){
            if (map.containsKey(i))
            {
                int count = map.get(i);
                map.put(i, count+1);
            }
            else
                map.put(i, 1);
        }

        for (int i : set3){
            if (map.containsKey(i))
            {
                int count = map.get(i);
                map.put(i, count+1);
            }
            else
                map.put(i, 1);
        }

        map.forEach((i,j) -> {
            if (j >= 2)
                res.add(i);
        });
        Collections.sort(res);
        return res;
    }
}
