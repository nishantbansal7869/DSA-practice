package com.practice.OCAExam;

import java.util.ArrayList;
import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        Bank b1 = new Bank();
        b1.acct = "0123";
        b1.type = 1;
        Bank b2 = new Bank();
        b2.acct = "0123";
        b2.type = 1;
        System.out.println(b1.equals(b2));
        ArrayList<Bank> arr = new ArrayList<>();
        arr.add(b1);
        //arr.add(b2);
        System.out.print(arr.contains(b2));
    }
}

class Bank{
    String acct;
    int type;
    public boolean equals(Object obj){
        if(obj instanceof Bank){
            Bank b = (Bank) obj;
            return (acct.equals(b.acct) && type == b.type);
        }
        else {
            return false;
        }
    }
}
