/*
* Given a number N, check if you can split the number into 2 non-zero even parts.

Input Format

First line of input contains T - number of test cases. Its followed by T lines, each line contains a single integer N.

Constraints

1 <= T <= 105
0 <= N <= 1018

Output Format

For each test case, print "Yes" if you can split the number into 2 non-zero even parts, "No" otherwise, separated by new line.

Sample Input 0

2
8
1
Sample Output 0

Yes
No
Explanation 0

Test Case 1
You can split 8 as 4,4 or 6,2.

Test Case 2
You cannot split 1 into 2 even parts.
* */
package com.practice.contest;

import java.util.Scanner;

public class EvenSplit {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            long n = sc.nextLong();
            boolean check = split(n);
            if(check)
                System.out.println("Yes");
            else
                System.out.println("No");
            test--;
        }
    }

    static boolean split(long n){
        if(n == 0 || n == 2)
            return false;
        if(n%2 == 0)
            return true;
        return false;
    }
}
