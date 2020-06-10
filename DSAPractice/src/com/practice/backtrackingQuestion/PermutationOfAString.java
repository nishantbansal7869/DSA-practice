package com.practice.backtrackingQuestion;

public class PermutationOfAString {
    public static void main(String[] args) {
        String str = "abc";
        permutation(str,0,str.length()-1);
    }
    public static void permutation(String str, int l, int r){
        if(l == r){
            System.out.println(str);
            return;
        }
        for(int i = l;i <= r; i++){
          //  if(isSafe(str,l,i,r)) {
                str = swap(str, l, i);
                permutation(str, l + 1, r);
                str = swap(str, l, i);
           // }
        }
    }
    public static String swap(String str, int l, int i){
        StringBuilder str1 = new StringBuilder(str);
        char temp = str1.charAt(i);
        str1.setCharAt(i,str.charAt(l));
        str1.setCharAt(l,temp);
        return str1.toString();
    }
    public static boolean isSafe(String str, int l, int i, int r){
        if(l!=0 && str.charAt(l-1)=='a' && str.charAt(i)=='b')
            return false;
        if(r == l+1 && str.charAt(i) == 'a' && str.charAt(l) == 'b')
            return false;
        return true;
    }
}
