package com.practice.backtrackingQuestion;

import com.sun.xml.internal.bind.v2.util.EditDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {
    public static void main(String[] args) {
        String num = "12";
       SolutionLetterPhone obj = new SolutionLetterPhone();
        ArrayList<String> res = new ArrayList<>();
       res = obj.letterPhone(num);
       res.stream().forEach(s->System.out.print(s));
    }
}

class SolutionLetterPhone{
    ArrayList<String> res = new ArrayList<>();
    public Map<Character,String> map = new HashMap(){{
        put('0',"0");
        put('1',"1");
       put('2',"abc");
       put('3',"def");
       put('4',"ghi");
       put('5',"jkl");
       put('6',"mno");
       put('7',"pqrs");
       put('8',"tuv");
       put('9',"wxyz");
    }};
    public ArrayList<String> letterPhone(String digits){
        if(digits == null || digits.length() == 0){
            return res;
        }
        allCombination(digits,new StringBuilder());
        return res;
    }

    public void allCombination(String digits, StringBuilder s){
        if(s.length() == digits.length()){
            StringBuilder str = new StringBuilder("\"");
            str.append(s);
            str.append("\"");
            res.add(str.toString());
            return;
        }
        String button = map.get(digits.charAt(s.length()));
        for(int i = 0; i < button.length(); i++){
            s.append(button.charAt(i));
            allCombination(digits,s);
            s.setLength(s.length()-1);
        }
    }
}
