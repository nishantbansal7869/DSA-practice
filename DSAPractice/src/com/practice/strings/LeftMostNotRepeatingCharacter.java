package com.practice.strings;

import java.util.Arrays;

public class LeftMostNotRepeatingCharacter {
    public static void main(String[] args) {
        String str = "geveksaforgeeks";
        System.out.println(leftNotRepeating(str));
    }
    public static int leftNotRepeating(String str){
        int count[] = new int[256];
        Arrays.fill(count,-1);
        for(int i = 0; i < str.length(); i++){
            if(count[str.charAt(i)] == -1){
                count[str.charAt(i)] = i;
            }
            else
                count[str.charAt(i)] = -2;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++){
            if(count[i] >= 0){
                res = Math.min(res,count[i]);
            }
        }
        return (res == Integer.MAX_VALUE)?-1:res;
    }
}
