package com.practice.sorting;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = new int[]{7,10,4,20,15};
        int k = 4;
        int index= kthSmallest(arr,arr.length,k);
        if(index != -1)
            System.out.println(arr[index]);
        else
            System.out.println(index);
    }
    public static int kthSmallest(int[] arr, int n, int k){
        int l = 0;
        int r = n-1;
        while (l <= r){
            int p = partition(arr,l,r);
            if(p == k-1){
                return p;
            }
            if(p > k-1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }
    public static int partition(int arr[], int l, int r){
        int i = l-1;
        int range = r-l;
        int rand = (int)(Math.random() * range)+l;
        int pivot = arr[rand];
        swap(arr,rand,r);
        for(int j = l; j <= r-1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,r);
        return i+1;
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
