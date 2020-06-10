package com.practice.bitsQuestions;

public class CountDigits {
    public static void main(String[] args) {
       System.out.println(countDigits(605));
        System.out.println(countDigits(3901));
        System.out.println(countDigits(1));
    }

    // complete the below function
    public static int countDigits(int n)
    {
        // add your code here
        if(n<10){
            return 1;
        }
        //count++;
        return countDigits(n/10)+1;

    }
}
