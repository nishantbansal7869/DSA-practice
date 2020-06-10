package com.practice.strings;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "geeks";
        String str2 = "eedkgs";
        System.out.println(anagram(str1,str2));
    }
    public static boolean anagram(String str1, String str2){
        if(str1.length()!=str2.length())
            return false;
        int arr[] = new int[256];
        for(int i = 0; i < str1.length(); i++){
            arr[str1.charAt(i)]++;
        }
        for(int i = 0; i < str2.length();i++){
            arr[str2.charAt(i)]--;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0)
                return false;
        }
        return true;
    }

}
