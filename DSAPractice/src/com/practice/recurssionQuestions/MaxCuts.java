package com.practice.recurssionQuestions;

public class MaxCuts {
    public static void main(String[] args) {
        System.out.println(maxCuts(9,3,2,2));
    }
    public static int maxCuts(int n, int a, int b, int c){
        if(n==0){
            return 0;
        }
        if(n<0){
            return -1;
        }
        int res = Math.max(Math.max(maxCuts(n-a,a,b,c), maxCuts(n-b,a,b,c)), maxCuts(n-c,a,b,c));
        if(res == -1){
            return -1;
        }
        return res+1;
    }
}
