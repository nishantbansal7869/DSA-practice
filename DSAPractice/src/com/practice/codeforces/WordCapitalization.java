/*
* Capitalization is writing a word with its first letter as a capital letter. Your task is to capitalize the given word.

Note, that during capitalization all the letters except the first one remains unchanged.

Input
A single line contains a non-empty word. This word consists of lowercase and uppercase English letters.
* The length of the word will not exceed 103.

Output
Output the given word after capitalization.

Examples
inputCopy
ApPLe
outputCopy
ApPLe
inputCopy
konjac
outputCopy
Konjac
* */
package com.practice.codeforces;

import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String updatedStr = wordCapitalization(s);
        System.out.println(updatedStr);
    }

    private static String wordCapitalization(String s) {
        char c = s.charAt(0);
        if(c >= 65 && c <= 90)
            return s;
        c = Character.toUpperCase(c);
        return c + s.substring(1);
    }
}
