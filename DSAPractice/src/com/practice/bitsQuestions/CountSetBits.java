package com.practice.bitsQuestions;

public class CountSetBits {
   static int table[] = new int[256];
    public static void main(String[] args) {
        int n = 4;
        initialize();
        System.out.println(count(n));
    }
    public static void initialize(){
        table[0] = 0;
        for(int i = 1; i < 256; i++) {
            table[i] = (i & 1) + table[i / 2];
        }
    }
    public static int count(int n){
        int res = table[n & 0xff];
        n=n>>8;
        res += table[n & 0xff];
        n=n>>8;
        res += table[n & 0xff];
        n=n>>8;
        res += table[n & 0xff];
        return res;
    }
}









