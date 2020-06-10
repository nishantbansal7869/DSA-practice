package com.practice.strings;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {
    public static void main(String[] args) {
        String str = "jlmnbgforgeeks";
        System.out.println(leftRepeat(str));
    }
    public static int leftRepeat(String str){
        int arr[] = new int[256];
        Arrays.fill(arr,-1);
        int res = Integer.MAX_VALUE;
        for(int i = str.length()-1; i >=0; i--){
            if(arr[str.charAt(i)] == -1){
                arr[str.charAt(i)] = i;
            }
            else {
                res = arr[str.charAt(i)];
            }
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }
}
