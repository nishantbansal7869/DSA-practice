package com.practice.recurssionQuestions;

public class factorial {
    public static void main(String[] args) {
        System.out.println(fact(4,1));
    }
    public static int fact(int n, int val){
       if(n==0){
           return val;
       }
       return fact(n-1,n*val);
    }
}
