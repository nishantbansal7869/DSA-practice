package com.practice.interviewbit;

import java.util.ArrayList;

public class RemoveDuplicates {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5000);
        a.add(5000);
        a.add(5000);
        a.add(5002);
        a.add(50003);
        int length = removeDup(a);
        System.out.println(length);
    }

    private static int removeDup(ArrayList<Integer> a) {
        int i = 0;
        for (int j = 1; j < a.size(); j++){
            if (! a.get(i).equals(a.get(j)))
                a.set(++i, a.get(j));
        }
        while (a.size() > i + 1)
            a.remove(a.size()-1);
        return a.size();
    }
}
