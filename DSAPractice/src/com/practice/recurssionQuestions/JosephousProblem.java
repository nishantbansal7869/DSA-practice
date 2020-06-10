package com.practice.recurssionQuestions;

public class JosephousProblem {
    public static void main(String[] args) {
        System.out.println(jos(3,2));
    }
    public static int jos(int n, int k){
        if(n==1)
            return 0;
        return (jos(n-1,k)+k)%n;
    }
}
