package com.practice.arrayQuestions;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = new int[]{10,5,7};
        int i = 0;
        int j = arr.length-1;
        while(i < j){
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
        for(i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
