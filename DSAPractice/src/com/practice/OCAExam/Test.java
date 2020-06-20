package com.practice.OCAExam;

public class Test {
    public static void main(String[] args) {
       A php = new A("PHP");
       A java = new A("Java");
       System.out.println("Before changing");
       php.display();
       java.display();
       php.set(java);
       java.set(php);
       System.out.println("After vhaning");
       php.display();
       java.display();
       System.out.println("OBj");
       php.show();
       java.show();
       php = null;
       java = null;
       System.out.println("After null");
       //php.show();
       //php.display();
       java.show();
       java.display();
    }
}

class A {
   private String name;
   private A obj;
   public A(String name){
       this.name = name;
   }
   public void set(A a){
       obj = a;
   }
   public void display(){
       System.out.println(name);
   }
   public void show(){
       System.out.println(obj.name);
   }
}
