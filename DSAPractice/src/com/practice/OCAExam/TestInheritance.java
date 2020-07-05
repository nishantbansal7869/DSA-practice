package com.practice.OCAExam;

public class TestInheritance {
    public static void main(String[] args) {
        Prog emp = new Prog();
        Emp emp1 = new Emp();
        System.out.print(emp.getName());
        System.out.print(emp1.getName());
    }
}

class Emp{
    String name = "Emp";
    public String getName(){
        return name;
    }
}

class Prog extends Emp{
    String name = "Prog";
    public String getName(){
        super.name = "P";
        return name;
    }
}