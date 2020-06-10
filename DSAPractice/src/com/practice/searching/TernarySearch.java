package com.practice.searching;

public class TernarySearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(ternarySearch(arr,0,arr.length,5));
    }
    public static int ternarySearch(int arr[],int low, int high,int x){
       if(high >= low){
            int mid1 = low + (high-low)/3;
            int mid2 = high - (high-low)/3;
            if(arr[mid1] == x)
                return mid1;
            if(arr[mid2] == x)
                return mid2;
            if(arr[mid1] > x)
                return  ternarySearch(arr,low,mid1-1,x);
            else if(arr[mid2] < x)
                return ternarySearch(arr,mid2+1,high,x);
            else
                return ternarySearch(arr,mid1+1,mid2-1,x);
        }
        return -1;
        /*if (r >= l)
        {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (ar[mid1] == key)
            {
                return mid1;
            }
            if (ar[mid2] == key)
            {
                return mid2;
            }
            if (key < ar[mid1])
            {
                return ternarySearch(l, mid1 - 1, key, ar);
            }
            else if (key > ar[mid2])
            {
                return ternarySearch(mid2 + 1, r, key, ar);
            }
            else
            {
                return ternarySearch(mid1 + 1, mid2 - 1, key, ar);
            }
        }
        return -1;*/
    }
}
