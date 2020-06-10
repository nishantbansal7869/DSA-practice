package com.practice.hackerRank;

public class NoOfPages {
    public static void main(String[] args) {
        int n = 6;
        int p = 4;
        System.out.println(noOfPages(n,p));
    }
    public static int noOfPages(int n, int p){
        int count = 0;
        if(p == n){
            return 0;
        }
        if(n%2 != 0){
            if(p == n || p == n-1)
                return 0;
        }
        if(n%2==0)
            n+=1;

        for(int i = 1; i < n;i+=2){
            if(p > i){
                count++;
            }
            if(p <= i){
                break;
            }
        }
        int count1 = 0;
        for(int i = n; i >=1; i-=2){
            if(p >= i || p == i-1)
                break;
            if(p < i){
                count1++;
            }
        }
        return Math.min(count,count1);
    }
}
