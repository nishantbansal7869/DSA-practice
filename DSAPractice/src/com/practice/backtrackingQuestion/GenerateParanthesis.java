/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
Make sure the returned list of strings are sorted.
* */
package com.practice.backtrackingQuestion;

import java.util.ArrayList;

public class GenerateParanthesis {
    public static void main(String[] args) {
        int n = 2;
        SolutionParanthesis obj = new SolutionParanthesis();
        obj.generateParanthesis(n);
    }
}
class SolutionParanthesis{
    public ArrayList<String> res = new ArrayList<>();
    public void generateParanthesis(int n){
        char arr[] = new char[2*n];
        generate(n,0,0, arr);
        res.stream().forEach(s->System.out.println(s));
    }
    public void generate(int n, int left,int right,char[] arr){
       int pos = left+right;
       if(pos == 2*n){
           String s = new String(arr);
           res.add(s);
       }
       if(left < n){
           arr[pos] = '(';
           generate(n,left+1,right,arr);
       }
       if(right<left){
           arr[pos] = ')';
           generate(n,left,right+1,arr);
       }
    }
}
