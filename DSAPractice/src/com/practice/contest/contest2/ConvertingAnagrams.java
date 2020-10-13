package com.practice.contest.contest2;
import java.io.*;
import java.util.*;
public class ConvertingAnagrams {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while(test > 0){
            String[] s = br.readLine().split(" ");
            int ans = countDeleteChar(s);
            System.out.println(ans);
            test--;
        }
    }
    static int countDeleteChar(String[] s){
        HashMap<Character,Integer> map = new HashMap<>();
        String s1 = s[0];
        String s2 = s[1];
        for(int i = 0; i < s1.length(); i++){
            if(map.containsKey(s1.charAt(i)))
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            else
                map.put(s1.charAt(i), 1);
        }
        int count = 0;
        for(int i = 0; i < s2.length(); i++){
            if(!map.containsKey(s2.charAt(i)))
                count++;
            else{
                map.put(s2.charAt(i), map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i)) == 0)
                    map.remove(s2.charAt(i));
            }
        }
        for(int i = 0; i < s1.length(); i++){
            if(map.containsKey(s1.charAt(i)))
                count++;
        }
        return count;
    }
}
