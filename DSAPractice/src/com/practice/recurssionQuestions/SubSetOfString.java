package com.practice.recurssionQuestions;

public class SubSetOfString {
    public static void main(String[] args) {
        subset("abc","",0);
    }
    public static void subset(String str, String curr, int index){
        if(index == str.length()){

                System.out.println(curr);
                return;

        }
        subset(str,curr,index+1);
        subset(str,curr+str.charAt(index), index+1);
    }
}
