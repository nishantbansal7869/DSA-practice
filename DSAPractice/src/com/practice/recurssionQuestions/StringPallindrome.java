package com.practice.recurssionQuestions;

public class StringPallindrome {
    public static void main(String[] args) {
        String str = "abcdba";
        System.out.println(Ispallindrome(str,0,str.length()-1));
    }
    public static boolean Ispallindrome(String str, int low, int high){
        if(low >= high)
            return true;
        if(str.charAt(low) != str.charAt(high))
            return false;
        return Ispallindrome(str,low+1,high-1);
    }
}
