package com.practice.searching;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int arr[] = new int[]{8};
        subarrayWithSum(arr.length, 8, arr);
    }
    public static void subarrayWithSum(int n, int sum, int arr[]){
        if(arr[0] == sum){
            System.out.println(1 + " " + 1);
            return;
        }
        int i = 0;
        int j = 1;
        int flag = 0;
        int sum1 = arr[i] + arr[j];
        while(i < n && j < n){
            if(sum1 == sum){
                flag = 1;
                System.out.println(i+1 + " " + (j+1));
                break;
            }
            if(sum1 < sum) {
                j++;
                if(j < n)
                    sum1 = sum1 + arr[j];
            }
            else {
                sum1 = sum1 - arr[i];
                i++;
            }

        }
        if(flag == 0){
            System.out.println("-1");
        }
    }
}
