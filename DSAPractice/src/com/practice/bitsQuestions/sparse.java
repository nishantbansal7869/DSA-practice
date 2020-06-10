package com.practice.bitsQuestions;

public class sparse {
    public static void main(String[] args) {
    System.out.println(isSparse(24));
    }



    public static boolean isSparse(int n){

        // Your code here
        int counter = 0;
        int bit1 = n&1;
        n=n>>1;
        for(int i = 1; i < 32; i++){
            int bit2 = n&1;
            if(bit1 == bit2 && bit1 != 0 && bit2 != 0){
                counter = 1;
            }
            bit1 = bit2;
            n=n>>1;
        }
        if(counter ==1 ) {
            return false;
        }
    return true;
    }

}
