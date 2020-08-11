/*
* Chef is interested in the history of SnackDown contests. He needs a program to verify if SnackDown
* was hosted in a given year.

SnackDown was hosted by CodeChef in the following years: 2010, 2015, 2016, 2017 and 2019.

Input
The first line contain the number of test-cases T.

The first line of each test-case contains a single integer N.

Output
For each test case print a single line containing the string "HOSTED" if SnackDown was hosted in year
* N or "NOT HOSTED" otherwise (without quotes).

Constraints
1≤T≤10
2010≤N≤2019
Example Input
2
2019
2018
Example Output
HOSTED
NOT HOSTED
* */
package com.practice.codechef;

import netscape.security.UserTarget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ChefAndSnackDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        for (int i = 0; i < test; i++){
            String val = br.readLine();
            if (val != null && !val.isEmpty()) {
               int year = Integer.parseInt(val);
               String result = wasHosted(year);
               System.out.println(result);
            }
        }
    }

    private static String wasHosted(int year) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2010);
        set.add(2015);
        set.add(2016);
        set.add(2017);
        set.add(2019);
        if (set.contains(year))
            return "HOSTED";
        return "NOT HOSTED";
    }
}
