package com.practice.searching;


public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2};
        int arr2[] = new int[]{2,3,4};
        System.out.println(getMedian(arr1,arr2,arr1.length,arr2.length));
    }
    public static double getMedian(int arr[], int brr[], int n, int m){
        int begin1 = 0;
        int end1 = 0;
        if(n < m){
            begin1 = 0;
            end1 = n;
        }
        else{
            begin1 = 0;
            end1 = m;
        }
        while(begin1 <= end1){
            int i1 = (begin1+end1)/2;
            int i2 = ((n+m+1)/2)-i1;
            int min1 = 0;
            int max1 = 0;
            int min2 = 0;
            int max2 = 0;
            if(n < m){
                min1 = (i1 == n)?Integer.MAX_VALUE : arr[i1];
                min2 = (i2 == m)?Integer.MAX_VALUE : brr[i2];
                max1 = (i1 == 0)?Integer.MIN_VALUE : arr[i1-1];
                max2 = (i2 == 0)?Integer.MIN_VALUE : brr[i2-1];
            }
            else{
                min1 = (i1 == n)?Integer.MAX_VALUE : brr[i1];
                min2 = (i2 == m)?Integer.MAX_VALUE : arr[i2];
                max1 = (i1 == 0)?Integer.MIN_VALUE : brr[i1-1];
                max2 = (i2 == 0)?Integer.MIN_VALUE : arr[i2-1];
            }
            if(max1 <= min2 && max2 <= min1){
                if((n+m)%2 == 0){
                    return ((double)(Math.max(max1,max2) + Math.min(min1,min2))/2);
                }
                else
                    return (Math.max(max1,max2));
            }
            if(max1 > min2)
                end1 = i1-1;
            else
                begin1 = i1+1;
        }
        return 0;
    }
}
