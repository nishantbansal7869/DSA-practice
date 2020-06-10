package com.practice.recurssionQuestions;

public class TowerOfHanoi {
    public static void main(String[] args) {
        towerOfHanoi(4,'A','B','C',0);
    }
    public static void towerOfHanoi(int n, char source, char aux, char des,int count){
        if(n == 1){
            System.out.println("move 1 from"+ source +"to" + des);
            return;
        }

        towerOfHanoi(n-1,source,des,aux,count+1);
        System.out.println("move"+n+"from"+ source +"to" + des);
        towerOfHanoi(n-1,aux,source,des,count+1);
    }
}
