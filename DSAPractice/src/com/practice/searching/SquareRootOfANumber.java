package com.practice.searching;

public class SquareRootOfANumber {
    public static void main(String[] args) {
        int x = 3;
        System.out.println(squareRoot(x));
    }
    public static int squareRoot(int x){
        int low = 1;
        int high = x;
        int ans = 0;
        while (low <= high){
            int mid = (low+high)/2;
            if(mid*mid == x)
                return mid;
            if(mid*mid < x){
                low = mid + 1;
                      ans = mid;
            }
            else
                high = mid -1;
        }
        return ans;
    }
}
