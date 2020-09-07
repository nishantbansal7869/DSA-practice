package com.practice.hackerRank;

import java.io.*;
import java.util.ArrayList;

public class LargestPallindromicSubstringHard {

    static ArrayList<Integer> power1 = new ArrayList<>();
    static ArrayList<Integer> power2 = new ArrayList<>();
    static ArrayList<Integer> forwardHash1 = new ArrayList<>();
    static ArrayList<Integer> forwardHash2 = new ArrayList<>();
    static ArrayList<Integer> backwardHash1 = new ArrayList<>();
    static ArrayList<Integer> backwardHash2 = new ArrayList<>();
    static final int z = (int)1e9+7;
    static final int p1 = 59;
    static final int p2 = 79;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        computePower((int)1e5);
        int test = Integer.parseInt(br.readLine());
        while (test > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int ans = longestPallindromicString(s, n);
            bw.write(ans + " ");
            bw.newLine();
            forwardHash1.clear();
            forwardHash2.clear();
            backwardHash2.clear();
            backwardHash1.clear();
            test--;
        }
        bw.flush();
    }

    private static int longestPallindromicString(String s, int n) {
        if (n == 1)
            return 1;
        computeForwardHash(s, n);
        computeBackWardHash(s, n);
        int oddPallindrome = Integer.MIN_VALUE;
        int evenPallindrome = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            int length = binarySearch(s, i, i, n);
            oddPallindrome = Math.max(length, oddPallindrome);
        }

        for (int i = 0; i < n-1; i++){
            int length = binarySearch(s, i, i+1, n);
            evenPallindrome = Math.max(length, evenPallindrome);
        }
        return Math.max(oddPallindrome, evenPallindrome);
    }

    private static int binarySearch(String s, int c1, int c2, int n) {
        int low = c1;
        int high = Math.min(c1, n - c2 - 1);
        int ans = 0;
        while (low <= high){
            int mid = (low+high)/2;
            if (valid(c1 - mid, c2 + mid, n)){
                ans = mid;
                low = mid+1;
            }
            else
                high = mid - 1;
        }
        return 2 * ans + 1 + (c2-c1);
    }

    private static boolean valid(int x, int y, int n) {
        int forward1 = (forwardHash1.get(y) - (x == 0 ? 0 : forwardHash1.get(x-1)) + z)%z;
        int forward2 = (forwardHash2.get(y) - (x == 0 ? 0 : forwardHash2.get(x-1)) + z)%z;
        int backward1 = (backwardHash1.get(x) - (y == n-1 ? 0 : backwardHash1.get(y+1)) + z)%z;
        int backward2 = (backwardHash2.get(x) - (y == n-1 ? 0 : backwardHash2.get(y+1)) + z)%z;

        int pwrSmallestForward = x + 1;
        int pwrSmallestBackward = n - y;
        int d= Math.abs(pwrSmallestForward - pwrSmallestBackward);

        if (pwrSmallestForward < pwrSmallestBackward){
            forward1 = (int)(((long)forward1 * power1.get(d))%z);
            forward2 = (int)(((long)forward2 * power2.get(d))%z);
        }
        else {
            backward1 = (int)(((long)backward1 * power1.get(d))%z);
            backward2 = (int)(((long)backward2 * power2.get(d))%z);
        }

        return forward1 == backward1 && forward2 == backward2;
    }

    private static void computeForwardHash(String s, int n) {
        forwardHash1.add(hashFunc1(s.charAt(0), 1));
        forwardHash2.add(hashFunc2(s.charAt(0), 1));
        for (int i = 1; i < s.length(); i++){
            int hash1 = (int)(((long)forwardHash1.get(i-1) + hashFunc1(s.charAt(i), i+1))%z);
            forwardHash1.add(hash1);
            int hash2 = (int)(((long)forwardHash2.get(i-1) + hashFunc2(s.charAt(i), i+1))%z);
            forwardHash2.add(hash2);
        }
    }

    private static void computeBackWardHash(String s, int n) {
        for (int i = 0; i < s.length(); i++){
            backwardHash2.add(0);
            backwardHash1.add(0);
        }
        backwardHash1.set(n-1, hashFunc1(s.charAt(n-1), 1));
        backwardHash2.set(n-1, hashFunc2(s.charAt(n-1), 1));
        int idx = n-2;
        for (int i = n-2; i >=0; i--){
            int hash1 = (int)(((long)backwardHash1.get(i + 1) + hashFunc1(s.charAt(i), n-i))%z);
            backwardHash1.set(idx, hash1);
            int hash2 = (int)(((long)backwardHash2.get(i + 1) + hashFunc2(s.charAt(i), n-i))%z);
            backwardHash2.set(idx, hash2);
            idx--;
        }
    }

    private static int hashFunc1(char c, int i){
        long hash = ((long)c * power1.get(i))%z;
        return (int)hash;
    }

    private static int hashFunc2(char c, int i){
        long hash = ((long)c * power2.get(i))%z;
        return (int)hash;
    }

    private static void computePower(int n) {
        power1.add(0,0);
        power2.add(0,0);
        power1.add(1, p1);
        power2.add(1, p2);
        for (int i = 2; i <= n+1; i++){
            long mul1 = ((long)power1.get(i-1)*p1)%z;
            power1.add((int)mul1);
            long mul2 = ((long)power2.get(i-1)*p2)%z;
            power2.add((int)mul2);
        }
    }
}
