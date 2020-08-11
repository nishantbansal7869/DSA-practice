package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowMuchScholarship {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        if (n != null && !n.isEmpty()){
            int num = Integer.parseInt(n);
            if (num > 100)
                System.out.println(0);
            else{
                int scholarship = findScholarShip(num);
                System.out.println(scholarship);
            }
        }

    }

    private static int findScholarShip(int num) {
        if (num >= 1 && num <=50)
            return 100;
        else
            return 50;
    }
}
