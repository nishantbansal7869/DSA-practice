package com.practice.searching;

public class TwoRepeatedElement {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,1,3,4,3};
        twoRepeatedElement(arr, arr.length);
    }

    public static void twoRepeatedElement(int arr[], int n) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                temp = arr[arr[i] - 1];
                arr[arr[i] - 1] *= -1;
                /*if(temp < 0){
                    System.out.print(arr[i] + " ");
                }*/
                while (temp > 0) {
                        int temp1 = arr[temp - 1];
                        if(temp1 * -1 == i){
                            break;
                        }
                        arr[temp - 1] *= -1;
                        temp = temp1;
                }
            }
        }
        for(int i = 0; i < n-2; i++){
            if(arr[i] > 0){
                System.out.println(i+1);
            }
        }
    }
}
