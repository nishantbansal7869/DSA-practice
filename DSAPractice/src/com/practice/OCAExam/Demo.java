package com.practice.OCAExam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Demo {
    String name;
    boolean contract;
    double salary;
   /* Demo(String name, boolean sal){
       // this();
    this.name = name;
    this.contract = sal;
    }*/
    private void a(){
        System.out.print("a");
    }
    private void b(){
        a();
        System.out.print("b");
    }



    public static void main(String[] args) {
       // int a = new Integer(10);
        Demo d = new Demo();
        LocalDate dt = LocalDate.of(2014,7,30);
        dt.plusWeeks(2);
       // dt.plusDays(30);
        //dt.plusMonths(1);
        System.out.print(dt.plusWeeks(2));
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(null);
        a.remove(null);
        a.remove(1);
        StringBuilder sb = new StringBuilder("nishant");
        StringBuilder sb1 = new StringBuilder("nishant");
        String sb2 = "nishant";
        System.out.println(sb.equals(sb2));
        String b = "nish";
        String[] arr = new String[]{"1","2"};
        arr[0] = null;
        Arrays.stream(arr).forEach(t->System.out.print(t));
       ArrayList<StringBuilder> list = new ArrayList<>();
       list.add(new StringBuilder("1"));
       list.remove(0);
       System.out.println(list);
        b = b.substring(2,3);
        String s = null;
        //System.out.println(s.equals(null));
        LocalDateTime ldt = LocalDateTime.now();
        sb.getClass();
        //String s = new String();
        System.out.print(b);
        System.out.println(LocalDateTime.now());
        Period p = Period.of(4,0,4);
        System.out.println(p);
    }
}
