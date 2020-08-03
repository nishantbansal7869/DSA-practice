/*
* Given a string, check if it contains only vowels.

Input Format

Input contains a string of lowercase and uppercase characters- S.

Constraints

1 <= len(S) <= 100

Output Format

Print "Yes" if string contains only vowels, "No" Otherwise.

Sample Input 0

askhtwsflk
Sample Output 0

No
* */

package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class VowelsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String isVowel = check(s);
        System.out.println(isVowel);
    }

    private static String check(String s) {
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++){
            if (!(s.charAt(i) == 'a' || s.charAt(i) == 'u' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o')){
                return "No";
            }
        }
        return "Yes";
    }
}
