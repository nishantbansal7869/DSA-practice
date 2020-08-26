/**/
package com.practice.arrayQuestions;

public class AlternatingOddEvenSubArray {
    public static void main(String[] args) {
        int arr[] = new int[]{5,10,20,6,3,8};
        System.out.println(maxAlterArray(arr,arr.length));
    }
    public static int maxAlterArray(int arr[], int n){
        int res = 1;
         int cur = 1;
         for(int i = 1; i < n; i++){
             if(arr[i]%2==0 && arr[i-1]%2 != 0 ||
             arr[i]%2 != 0 && arr[i-1]%2==0){
                 cur++;
                 res = Math.max(res,cur);
             }
             else {
                 cur = 1;
             }
         }
         return res;
    }
}
