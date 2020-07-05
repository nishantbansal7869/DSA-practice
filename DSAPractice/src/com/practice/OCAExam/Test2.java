package com.practice.OCAExam;

public class Test2 {
    public static void main(String[] args) {
        Employee e = new Employee();
        int age = 10;
        System.out.println(age);
        System.out.println("Instance value"+ e.age);
        e.modify(age);
        System.out.println("Instance value"+ e.age);
        System.out.println(age);
    }
}

class Employee{
    int age;
    public void modify(int age){
        age = age+1;
        System.out.println(age);
    }
}
