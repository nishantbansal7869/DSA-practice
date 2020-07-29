/*
* "Contestant who earns a score equal to or greater than the k-th place finisher's score will advance to the next round,
*  as long as the contestant earns a positive score..." — an excerpt from contest rules.

A total of n participants took part in the contest ( n ≥ k), and you already know their scores. Calculate how many
* participants will advance to the next round.

Input
The first line of the input contains two integers n and k (1 ≤ k ≤ n ≤ 50) separated by a single space.

The second line contains n space-separated integers a 1, a 2, ..., a n (0 ≤ a i ≤ 100), where a i is the score earned
* by the participant who got the i-th place. The given sequence is non-increasing (that is, for all i from 1 to n - 1
* the following condition is fulfilled: a i ≥ a i + 1).

Output
Output the number of participants who advance to the next round.

Examples
inputCopy
8 5
10 9 8 7 7 7 5 5
outputCopy
6
inputCopy
4 2
0 0 0 0
outputCopy
0
Note
In the first example the participant on the 5th place earned 7 points. As the participant on the 6th place also earned
* 7 points, there are 6 advancers.
* In the second example nobody got a positive score.
* */

package com.practice.codeforces;

import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] scores = new int[n];
        for(int i = 0; i < n; i++)
            scores[i] = sc.nextInt();
        int countOfParticipants = checkScores(scores, n, k);
        System.out.println(countOfParticipants);
    }

    private static int checkScores(int[] scores, int n, int k) {
        int score = scores[k-1];
        if(score == 0){
            int i = k-1;
            while (i >= 0){
                if(scores[i] != 0)
                    return i + 1;
                i--;
            }
            return 0;
        }
        else {
            int i = k - 1;
            while (i < n){
                if (scores[i] == score)
                    i++;
                else
                    break;
            }
            return i;
        }
    }
}
