/*
* Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more
* than n/k times.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
* Each test case contains an integer n denoting the size of the array. Then the next line contains n space
* separated integers forming the array. The last line of input contains an integer k.

Output:
Print the count of elements in array that appear more than n/k times.

User Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times
* appearance.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 102
1 <= N <= 104
1 <= a[i] <= 106
1 <= k <= N

Example:
Input:
2
8
3 1 2 2 1 2 3 3
4
4
2 3 3 2
3
Output:
2
2

Explanation:
Testcase 1: In the given array, 3 and 2 are the only elements that appears more than n/k times.
Testcase 2: In the given array, 3 and 2 are the only elements that appears more than n/k times. So the count
* of elements are 2.
* */
package com.practice.searching;

import java.util.ArrayList;
import java.util.Collections;

public class MoreThanNKOccurances {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,2,3,3};
        System.out.println(mareThanNKOccurance(arr,arr.length,3 ));
    }
   static class hashArray {
        int element;
        int value;
    }
    public static int mareThanNKOccurance(int arr[], int n, int k) {
        ArrayList<hashArray> countOccurance = new ArrayList<>(k-1);
        for(int i = 0; i < k-1; i++){
            hashArray el = new hashArray();
            el.value = 0;
            el.element = 0;
            countOccurance.add(i,el);
        }
        for(int i = 0; i < n; i++){
            int j = 0;
            for(j = 0; j < k-1; j++){
                if(arr[i] == countOccurance.get(j).element){
                    hashArray el = new hashArray();
                    el.value = countOccurance.get(j).value + 1;
                    el.element = countOccurance.get(j).element;
                    countOccurance.set(j,el);
                    break;
                }

            }
            if(j == k-1){
                int l;
                for(l = 0; l < k-1; l++){
                    if(countOccurance.get(l).value == 0){
                        hashArray el  = new hashArray();
                        el.element = arr[i];
                        el.value = 1;
                        countOccurance.set(l,el);
                        break;
                    }
                }
                if(l == k-1){
                    for(l = 0; l < countOccurance.size(); l++){
                        hashArray el = new hashArray();
                        el.element = countOccurance.get(l).element;
                        el.value = countOccurance.get(l).value - 1;
                        countOccurance.set(l,el);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < k-1;i++){
            int ac = 0;
            for(int j =0; j < n; j++){
                if(countOccurance.get(i).element == arr[j]){
                    ac++;
                }
            }
            if(ac > n/k){
                count++;
            }
        }
        return count;
    }
}
