package com.practice.codeforces;

import java.util.Scanner;

public class Translation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String berland = sc.next();
        String birland = sc.next();
        String result = checkIfCorrect(berland, birland);
        System.out.print(result);
    }

    private static String checkIfCorrect(String berland, String birland) {
        if (berland.length() != birland.length())
            return "NO";
        int j = birland.length() - 1;
        for (int i = 0; i < berland.length(); i++){
            if (berland.charAt(i) != birland.charAt(j))
                return "NO";
            j--;
        }
        return "YES";
    }
}
