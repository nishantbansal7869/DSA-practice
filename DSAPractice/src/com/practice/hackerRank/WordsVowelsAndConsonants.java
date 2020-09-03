package com.practice.hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordsVowelsAndConsonants {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String s = br.readLine();
            int[] arr = countWVC(s);
            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            test--;
        }
    }

    private static int[] countWVC(String s) {
        int[] count = new int[3];
        s = s.trim();
        s = s.toLowerCase();
        String[] arr = s.split("\\s+");
        if (s.equals(""))
            count[0] = 0;
        else
            count[0] = arr.length;
        int[] chars = new int[26];
        int countLength = 0;
        for (String str : arr){
            countLength += str.length();
            for (int i = 0; i < str.length(); i++)
                chars[str.charAt(i) - 'a']++;
        }
        int countVowel = chars[0] + chars[4] + chars[8] + chars[14] + chars[20];
        int countConst = countLength - countVowel;
        count[1] = countVowel;
        count[2] = countConst;
        return count;
    }
}
