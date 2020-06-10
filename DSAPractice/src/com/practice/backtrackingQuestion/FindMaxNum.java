package com.practice.backtrackingQuestion;

public class FindMaxNum {
    static String max = "";
    public static void main(String[] args) {
        char ar[] = new char[]{'1','2','3','4','5','6','7'};
        int k = 4;
       System.out.println( findMax(ar,k));
    }
    public static String findMax(char ar[], int k){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < ar.length; i++){
            s.append(ar[i]);
        }
         max = s.toString();
        findMaxNum(s.toString(),k,0);
        return max;
    }
    public static void findMaxNum(String s, int k, int ctr){
        if(k == 0 || ctr == s.length()-1)
            return;
        int n = s.length();
        char maxm = s.charAt(ctr);
        for(int i = ctr+1; i < s.length();i++){
            if(s.charAt(i) > maxm)
                maxm = s.charAt(i);
        }
        if(maxm != s.charAt(ctr))
            k-=1;
        for(int j = ctr; j < n; j++){
            if(s.charAt(j) == maxm) {
                s = swap(s, j, ctr);
                if (s.compareTo(max) > 0)
                    max = s;
                findMaxNum(s, k, ctr + 1);
                s = swap(s,j,ctr);
            }
        }
    }
    public static String swap(String s, int j, int ctr){
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(j);
        sb.setCharAt(j,s.charAt(ctr));
        sb.setCharAt(ctr,temp);
        s = sb.toString();
        return s;
    }

}
