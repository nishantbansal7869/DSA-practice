package com.practice.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class IWaanaBeTheGuy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int m = (int)1e9+7;
        String littleX = br.readLine();
        String littleY = br.readLine();
        String[] arrX = littleX.split(" ");
        String[] arrY = littleY.split(" ");
        String result = canPassTheGame(n, arrX, arrY);
        System.out.print(result);
    }

    private static String canPassTheGame(int n, String[] arrX, String[] arrY) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < arrX.length; i++)
            if (!arrX[i].equals("0"))
            set.add(arrX[i]);
        for (int i = 0; i < arrY.length; i++)
            if (!arrY[i].equals("0"))
            set.add(arrY[i]);
        if (set.size() == n)
            return "I become the guy.";
        else
            return "Oh, my keyboard!";
    }


}
