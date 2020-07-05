package com.practice.OCAExam;

import java.util.ArrayList;

public class Test3 {
    public static void main(String[] args) {
        StringBuilder one = new StringBuilder("one");
        StringBuilder two = new StringBuilder("two");
        ArrayList<StringBuilder> arr = new ArrayList<>();
        arr.add(one);
        arr.add(two);
        System.out.println(one);
        ArrayList<StringBuilder > arr1 = (ArrayList<StringBuilder>) arr.clone();
        arr.stream().forEach(s->System.out.println("arr " +s));
        arr1.stream().forEach(a->System.out.println("arr1 "+ a));
        //arr.add("hi");
        arr.remove(1);
        StringBuilder a = arr.get(0);
        arr.get(0).append("g");
        arr.add(new StringBuilder("hii"));
        StringBuilder b = arr1.get(0);
        System.out.println(a==b);
        System.out.println(arr);
        System.out.println(arr1);
       // one =  one.replace("O", "b");
        //arr.add(one);
        //arr1.stream().forEach(a->System.out.println("After modified arr1 "+ a));
       // arr1.remove(1);
        //arr.stream().forEach(a->System.out.println("Mod "+ a));
        //int c = 0;
        //c = c*2+3;
        //System.out.println(c);
        //System.out.println(one);

    }
}
