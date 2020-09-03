/*
* Given a string, find the minimum number of cuts needed to obtain a perfect string. A perfect string is a string in
* 'which it has only single type of character. Eg: aaaaa. A cut in the string should be done exactly in the middle
*  dividing the string into two equal halves.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single string
* consisting only lowercase english alphabets.

Constraints

1 <= T <= 103
1 <= len(str) <= 104

Output Format

For each test case, print the minimum number of cuts required to get a perfect string, separated by a new line.
* If it is not possible to obtain a perfect string print -1.

Sample Input 0

2
aacabbaa
ab
Sample Output 0

2
1
Explanation 0

Test Case 1
Cut-1: [aaca][bbaa], Cut-2: [bb][aa]

Test Case 2
Cut-1: [a][b]
* */
package com.practice.contest;

import java.util.Scanner;

public class SplittingString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            String s = sc.next();
            int ans = splittingString(s);
            System.out.println(ans);
            test--;
        }
    }
    static int ans = Integer.MAX_VALUE;
    private static int splittingString(String s) {
        if (s.length() > 1 && s.length()%2 != 0)
            return 0;
        if (valid(s))
            return 1;

        int count = 0;
        count += splittingString(s.substring(0, s.length()/2));
        count += splittingString(s.substring(s.length()/2));
        return count;
    }

    private static boolean valid(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 0; i < s.length()-1; i++)
            if (s.charAt(i) != s.charAt(i+1))
                return false;
        return true;
    }
}
