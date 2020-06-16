/*
* You are given an array A having N integers.

You have to perform the following steps in a given order.

generate all subarrays of A.
take the maximum element from each subarray of A and insert it into a new array G.
replace every element of G with the product of their divisors mod 1e9 + 7.
sort G in descending order
perform Q queries
In each query, you are given an integer K, where you have to find the Kth element in G.

Note: Your solution will run on multiple test cases so do clear global variables after using them.


Input Format

The first argument given is an Array A, having N integers.
The second argument given is an Array B, where B[i] is the ith query.
Output Format

Return an Array X, where X[i] will have the answer for the ith query.
Constraints

1 <= N <= 1e5
1 <= A[i] <= 1e5
1 <= Q <= 1e5
1 <= k <= (N * (N + 1))/2
For Example

Input:
    A = [1, 2, 4]
    B = [1, 2, 3, 4, 5, 6]
Output:
    X = [8, 8, 8, 2, 2, 1]

Explanation:
    subarrays of A	  maximum element
    ------------------------------------
    1. [1]							1
    2. [1, 2]						2
    3. [1, 2, 4]					4
    4. [2]							2
    5. [2, 4]						4
    6. [4]							4

	original
	G = [1, 2, 4, 2, 4, 4]

	after changing every element of G with product of their divisors
	G = [1, 2, 8, 2, 8, 8]

	after sorting G in descending order
	G = [8, 8, 8, 2, 2, 1]
* */
package com.practice.arrayQuestions;

import java.util.ArrayList;

public class SimpleQuries {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        arr1.add(5);
        arr1.add(6);
        SolutionSimple obj = new SolutionSimple();
        obj.solve(arr,arr1);
    }
}

class SolutionSimple{
    public ArrayList<ArrayList<Integer>> resSub = new ArrayList<>();
    public ArrayList<Integer> res = new ArrayList<>();
    public  final long M = 1000000007;
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        subset(A, new ArrayList<Integer>(),0);
        //resSub.stream().forEach(a->System.out.println(a));
        findMax(resSub);
        findDivisors(res);
        resSub.stream().forEach(s->System.out.println(s));
        res.stream().forEach(a->System.out.println(a));
        return A;
    }
    public void subset(ArrayList<Integer> arr, ArrayList<Integer> sub, int index){
        resSub.add(new ArrayList<>(sub));
        for(int i = index; i < arr.size(); i++)
        {
            sub.add(arr.get(i));
            subset(arr,sub,i+1);
            sub.remove(sub.size()-1);
        }
    }
    public void findMax(ArrayList<ArrayList<Integer>> resSub){
        for(int i = 1; i < resSub.size(); i++){
            int max = 0;
            for(int j = 0; j < resSub.get(i).size();j++){
                max = Math.max(max,resSub.get(i).get(j));
            }
            res.add(max);
        }
    }
    public void findDivisors(ArrayList<Integer> res){

    }
}
