package com.practice.OCAExam;

public class TestExceptions {
    public static void main(String[] args) {
        Multiple m = new Multiple();
        System.out.println("main" + m.get());
    }
}

class Multiple{
    String get(){
        String  s = "10";
        try {
            String[] str = {"a","c"};
            System.out.print(str[4]);
        }
        catch (Exception e){
            System.out.println("Catch" + s);
            return s;
        }
        finally {
            s = "20";
            System.out.println("Finally" + s);
        }
        return s;
    }
}