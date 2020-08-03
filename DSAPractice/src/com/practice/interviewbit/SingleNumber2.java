package com.practice.interviewbit;

import java.util.ArrayList;

public class SingleNumber2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(7);
        list.add(7);
        list.add(8);
        list.add(8);
        int num = repeatOnce(list);
        System.out.print(num);
    }

    private static int repeatOnce(ArrayList<Integer> list) {
        int count1 = 0;
        int count0 = 0;
        int num = 0;
        int bit;
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < list.size(); j++){
                if ((list.get(j)&1<<i) != 0)
                    count1++;
                else
                    count0++;
            }
            if (count1 % 3 != 0)
                bit = 1;
            else
                bit = 0;
            count0 = 0;
            count1=0;
            num = num | (bit<<i);
        }
        return num;
    }
}
