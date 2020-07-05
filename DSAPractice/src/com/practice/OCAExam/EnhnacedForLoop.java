package com.practice.OCAExam;

public class EnhnacedForLoop {
    public static void main(String[] args) {
        String[] str = {"Hi", "Hiii", "ello"};
        for(String s : str){
            System.out.println(s);
        }
        for(String s : str){
            s = s.replace('H','Y');
            System.out.println(s);
        }
        for(String s: str){
            System.out.println(s);
        }

        if(pased()){
            System.out.println("hoo");
        }
    }
    public static boolean pased(){
        return true;
    }
}
