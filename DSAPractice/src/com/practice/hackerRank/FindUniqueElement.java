package com.practice.hackerRank;

import java.util.*;

public class FindUniqueElement {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> num = new ArrayList<>();
        findUniqueElement(arr,n,num);
    }
    public static void findUniqueElement(int[] arr, int n, ArrayList<Integer> num){
        //boolean contains = true;
        int i = 0;
        while(i < n){
            if(num.contains(arr[i]+100)){
                i++;
                continue;
            }
            else if(num.contains(arr[i])){
               int index = num.indexOf(arr[i]);
               num.set(index,arr[i]+100);
            }
            else {
                num.add(arr[i]);
            }
            i++;
        }
        for(Integer k : num){
            if(k < 100){
                System.out.print(k + " ");
            }
        }
    }
}
