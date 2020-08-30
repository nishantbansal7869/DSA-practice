/*
* There are N books in a shelf which are already arranged in non-increasing order of number of pages in the books.
* Each book will be given a rank starting from 1 depending on the number of pages. The book with the highest number
*  of pages will be ranked 1. You are writing a new book and it will be completed in M days. Everyday after adding
* some pages in your book, you want to find the rank of the book in the shelf. Please note that book's with same
*  number of pages will be given same rank. Write an algorithm to find the rank of your book in the shelf for each
* of the M days.

Input Format

First line of input contains T - number of test cases. Its followed by 4T lines, the first line contains N - number
* of books in the shelf and the second line contains N integers, which denotes the number of pages in ith book.
* The third line contains M - number of days to complete your new book and the fourth line contains M integers,
* which denotes the number of pages in your new book at the end of ith day.

Constraints

30 points
1 <= T <= 100
1 <= N, M <= 102
1 <= arr[i] <= 106

70 points
1 <= T <= 200
1 <= N, M <= 104
1 <= arr[i] <= 106

Output Format

For each testcase, print M integers denoting the rank of your book at the end of each of the M days, separated by a new line.

Sample Input 0

2
7
100 100 50 40 40 20 10
4
5 25 50 120
3
45 30 12
6
5 12 25 35 45 80
Sample Output 0

6 4 2 1
4 3 3 2 1 1
Explanation 0

Test Case 1
When your book has 5 pages, it will be ranked 6: 100 100 50 40 40 20 10 "5"
When your book has 25 pages, it will be ranked 4: 100 100 50 40 40 "25" 20 10
When your book has 50 pages, it will be ranked 2: 100 100 50 "50" 40 40 20 10
When your book has 120 pages, it will be ranked 1: "120" 100 100 50 40 40 20 10
* */
package com.practice.contest;

import java.io.*;
import java.util.HashMap;

public class RankingBooks {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String s = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            int[] brr = new int[m];
            String[] sArr = s.split(" ");
            String[] sBrr = s1.split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            for (int i = 0; i < m; i++)
                brr[i] = Integer.parseInt(sBrr[i]);
            HashMap<Integer, Integer> map = getRank(arr);
            for (int i = 0; i < m; i++){
                int rank = findRank(arr, map, brr[i]);
                bw.write(rank + " ");
            }
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    static HashMap<Integer, Integer> getRank(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], rank);
                rank++;
            }
        }
        return map;
    }

    static int findRank(int[] arr, HashMap<Integer, Integer> map, int k){
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MIN_VALUE;
        while(low <= high){
            int mid = (low+high)/2;
            if(arr[mid] < k)
                high = mid-1;
            else if(arr[mid] == k)
                return map.get(arr[mid]);
            else{
                ans = arr[mid];
                low = mid+1;
            }
        }
        if(ans == Integer.MIN_VALUE)
            return 1;
        return map.get(ans)+1;
    }
}
