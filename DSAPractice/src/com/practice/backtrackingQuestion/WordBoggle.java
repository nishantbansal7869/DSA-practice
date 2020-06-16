package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Calendar;

public class WordBoggle {
    public static void main(String[] args) {
        String[] dictionary = new String[]{"geeks","for","quiz","go"};
        int n = 3;
        int m = 3;
        char[][] boggle = new char[][]{
                {'g','i','z'},
                {'u','e','k'},
                {'q','s','e'}
        };
        int k = 0;
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr.add(boggle[i][j]);
            }
        }
        findWord(dictionary,arr,0);
        res.stream().forEach(a->System.out.println(a));
    }
    public static StringBuilder s = new StringBuilder();
    public static ArrayList<String> res = new ArrayList<>();
    public static int[] visited = new int[9];
    public static void findWord(String[] dictionary, ArrayList<Character> arr, int l){
        for(int i = 0; i < dictionary.length;i++){
            if(s.toString().contains(dictionary[i])){
                res.add(dictionary[i]);
                break;
            }
        }
        int r = arr.size()-1;
        if(l==r){
         //System.out.println(s);
            return;
        }
        for(int i = l; i <= r; i++){
            s.append(arr.get(i));
            findWord(dictionary,arr,l+1);
            s.setLength(s.length()-1);
        }
    }
}
