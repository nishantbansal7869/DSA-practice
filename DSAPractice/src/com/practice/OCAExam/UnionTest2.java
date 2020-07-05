package com.practice.OCAExam;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionTest2 {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,3,4,5};
        int arr2[] = new int[]{1,2,3};
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> output = findUnion(arr1,arr2,n,m);
        output.stream().forEach(s->System.out.print(s+" "));
    }
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(i > 0 && arr1[i] == arr1[i-1]){
                i++;
                continue;
            }
            if(j > 0 && arr2[j] == arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i] < arr2[j]){
                output.add(arr1[i]);
                i++;
            }
            else if(arr2[j] < arr1[i]){
                output.add(arr2[j]);
                j++;
            }
            else if(arr1[i] == arr2[j]){
                output.add(arr1[i]);
                i++;
                j++;
            }
        }
        while(i < n){
            if(i > 0 && arr1[i] == arr1[i-1]){
                i++;
                continue;
            }
            else{
                output.add(arr1[i]);
                i++;
            }
        }
        while(j < m){
            if(j > 0 && arr2[j] == arr2[j-1]){
                j++;
                continue;
            }
            else{
                output.add(arr2[j]);
                j++;
            }
        }
        return output;
    }
}
