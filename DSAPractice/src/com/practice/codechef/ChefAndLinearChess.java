package com.practice.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndLinearChess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        int test = 0;
        if (t != null && !t.isEmpty())
            test = Integer.parseInt(t);
        while (test > 0){
            String s = br.readLine();
            if (s != null && !s.isEmpty()){
                String arr[] = s.split(" ");
                int n = Integer.parseInt(arr[0]);
                int chefPos = Integer.parseInt(arr[1]);
                String s1 = br.readLine();
                if (s1 != null && !s1.isEmpty()){
                    String arr1[] = s1.split(" ");
                    int ans = Integer.MAX_VALUE;
                    int resPos = -1;
                    for (int i = 0; i < arr1.length; i++){
                        int pos = Integer.parseInt(arr1[i]);
                        if (pos <= chefPos && chefPos % pos == 0){
                            if(ans > chefPos/pos - 1){
                                ans = chefPos/pos - 1;
                                resPos = pos;
                            }
                        }
                    }
                    System.out.println(resPos);
                }
            }
            test--;
        }
    }
}
