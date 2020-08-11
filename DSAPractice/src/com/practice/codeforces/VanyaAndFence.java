package com.practice.codeforces;

import java.util.Scanner;

public class VanyaAndFence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfFriends = sc.nextInt();
        int heightOfFence = sc.nextInt();
        int[] heightOfFriends = new int[noOfFriends];
        for (int i =0; i < noOfFriends; i++){
            heightOfFriends[i] = sc.nextInt();
        }
        int width = findWidth(noOfFriends, heightOfFence, heightOfFriends);
        System.out.print(width);
    }

    private static int findWidth(int noOfFriends, int heightOfFence, int[] heightOfFriends) {
        int width = 0;
        for (int i = 0; i < noOfFriends; i++){
            if (heightOfFriends[i] > heightOfFence){
                width += 2;
            }
            else
                width += 1;
        }
        return width;
    }
}
