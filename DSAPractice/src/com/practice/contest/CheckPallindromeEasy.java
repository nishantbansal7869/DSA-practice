/*
* Given a string, check if its a palindrome.

Input Format

First line of input contains T - number of test cases. Its followed by 2T lines, the first line contains N - the size
* of the string. The second line contains a string of N characters.

Constraints

1 <= T <= 1000
1 <= N <= 1000
'a' <= str[i] <= 'z'

Output Format

For each test case, print "Yes" if the string is a palindrome, "No" otherwise, separated by new line.

Sample Input 0

2
5
madam
6
tester
Sample Output 0

Yes
No
* */
package com.practice.contest;

import java.util.Scanner;

public class CheckPallindromeEasy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            int n = sc.nextInt();
            String s = sc.next();
            boolean check = pallindrome(s);
            if(check)
                System.out.println("Yes");
            else
                System.out.println("No");
            test--;
        }
    }
    static boolean pallindrome(String s){
        if(s.length() == 1)
            return true;
        int i = 0;
        int j = s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
