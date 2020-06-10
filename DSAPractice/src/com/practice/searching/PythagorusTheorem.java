package com.practice.searching;

public class PythagorusTheorem {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,6,7};
        pythagorusTheorem(arr,arr.length);
    }
    public static void pythagorusTheorem(int arr[], int n){
       /* int a = 0;
        int b = n-1;
        int c = arr[b] * arr[b];*/
        boolean bool = false;
        for(int i = n-1; i>= 2; i--){
            bool =  twoPointerApproach(arr,arr.length,arr[i]*arr[i]);
           if(bool)
               break;
        }
        System.out.println(bool);
    }
    public static boolean twoPointerApproach(int arr[], int n, int sum){
        int low = 0;
        int high = n-2;
        while (low < high){
            if((arr[low]*arr[low])+(arr[high]*arr[high]) == sum)
            {
                System.out.println(arr[low] + " " + arr[high]);
                return true;
            }
            if((arr[low]*arr[low])+(arr[high]*arr[high]) > sum)
                high--;
            else
                low++;
        }
        return false;
    }
}

