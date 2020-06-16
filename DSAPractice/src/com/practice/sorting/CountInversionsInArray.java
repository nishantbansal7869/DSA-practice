package com.practice.sorting;

public class CountInversionsInArray {
    public static void main(String[] args) {
        int arr[] = new int[]{2,4,1,3,5};
        System.out.println(countInversions(arr,0,arr.length-1));
    }
    public static int countInversions(int arr[], int l, int r){
        int res = 0;
        if(r > l){
            int m = (r+l)/2;
            res += countInversions(arr,l,m);
            res += countInversions(arr,m+1,r);
            res += countAndMerge(arr,l,m,r);
        }
        return res;
    }
    public static int countAndMerge(int arr[], int l ,int m, int r){
        int res = 0;
        int n1 = m-l+1;
        int n2 = r-m;
        int larr[] = new int[n1];
        int rarr[] = new int[n2];
        for(int i = 0; i < n1; i++){
            larr[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            rarr[j] = arr[m+1+j];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(larr[i] > rarr[j]){
                res+=(n1-i);
                arr[k++] = rarr[j++];
            }
            else {
                arr[k++] = larr[i++];
            }
        }
        while (i < n1){
            arr[k++] = larr[i++];
        }
        while (j < n2){
            arr[k++] = rarr[j++];
        }
        return res;
    }
}
