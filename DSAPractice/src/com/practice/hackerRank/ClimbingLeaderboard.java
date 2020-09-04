package com.practice.hackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class ClimbingLeaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++)
            alice[i] = sc.nextInt();
        int[] ans = climbingLeaderboard(scores, alice);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        HashMap<Integer, Integer> ranks = getRank(scores);
        int idx = 0;
        int[] rank = new int[alice.length];
        for (int i : alice){
            rank[idx] = findRank(i, scores, ranks);
            idx++;
        }
        return rank;
    }

    private static int findRank(int i, int[] scores, HashMap<Integer, Integer> ranks) {
        int low = 0;
        int high = scores.length-1;
        int ans = Integer.MIN_VALUE;
        while (low <= high){
            int mid = (low+high)/2;
            if (scores[mid] < i)
                high = mid - 1;
            else if (scores[mid] == i)
                return ranks.get(scores[mid]);
            else {
                ans = scores[mid];
                low = mid+1;
            }
        }
        if (ans == Integer.MIN_VALUE)
            return 1;
        return ranks.get(ans)+1;
    }

    private static HashMap<Integer, Integer> getRank(int[] scores) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i : scores){
            if (!map.containsKey(i)){
                map.put(i, rank);
                rank++;
            }
        }
        return map;
    }
}
