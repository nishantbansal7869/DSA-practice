package com.practice.OCAExam;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;

abstract class Super{
    public abstract void m1() throws IOException;
}

class Sub extends Super{

    @Override
    public void m1() throws IOException {
        throw new FileNotFoundException();
    }
}

public class MockExam {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(200);
        list.remove((Integer)100);
        System.out.println(list);
        Period p = Period.parse("p0y0m0d");
        System.out.println(p);*/
        Super s = new Sub();
        try {
            s.m1();
        }  catch (IOException e) {
          //  e.printStackTrace();
        }
        Integer i = Integer.valueOf(10);
        Integer j = Integer.valueOf(10);
        System.out.println(i == j);
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.now();
        System.out.println(date == date1);
        System.out.println(date.equals(date1));
        StringBuilder sb = new StringBuilder("b");
        StringBuilder sb1 = new StringBuilder("b");
        System.out.println(sb == sb1);
        System.out.println(sb.equals(sb1));
    }
}
